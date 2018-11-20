package oopd.project.code.doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oopd.project.logging.LogExceptionsToFile;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class DoctorRefer extends JFrame {

	private int docId,pId,recId;
	private JFrame frame;
	Connection con;
	 Statement st;
   ResultSet rs;
   PreparedStatement pstmt = null;
   JComboBox referDocComboBox = new JComboBox();
   
   List<String> idList=new ArrayList<>();
   
   LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
   
   public DoctorRefer() {
	// TODO Auto-generated constructor stub
}
   
	/**
	 * Create the frame.
	 */
	public DoctorRefer(int docId,int pId,int recId) {
		this.recId=recId;
		this.docId=docId;
		this.pId=pId;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void databaseConn()
	{	
		try 
		{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
        st = (Statement) con.createStatement();
        
        
        
		}
		catch (Exception e) {
		// TODO: handle exception
			logs.LOGGER.info(""+e);
		e.printStackTrace();
		}
	}
	
	
	void initialize() {
		
		
		//System.out.println(docId);
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 502);
		frame.setTitle("Refer to Doctor");
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("        Refer to Other Doctor");
		
		titleLabel.setBounds(83, 37, 543, 61);
		titleLabel.setForeground(Color.red);

		titleLabel.setFont(new Font("Serif", Font.BOLD,30));
		frame.getContentPane().add(titleLabel);
		
		JLabel lblChooseADoctor = new JLabel("Choose A Doctor");
		lblChooseADoctor.setBounds(54, 137, 133, 26);
		frame.getContentPane().add(lblChooseADoctor);
		
		
		
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(54, 368, 114, 25);
		frame.getContentPane().add(backButton);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(54, 331, 114, 25);
		frame.getContentPane().add(submitButton);
		
		//database con
		databaseConn();
		
		//checking whether the doctor is eligible to refer in other dept
		Boolean referToOtherDept=checkDoctorRank(docId,st);
		
		Vector v1=new Vector();
        v1.add("None");
		
		if(referToOtherDept)
		{
			//can refer to other dept
			
	        int dId=0,deptId=0;
	        String name=null;
	        
	        try {
				ResultSet rs1=st.executeQuery("Select Did,Name,DeptId from Doctor");
				while(rs1.next())
				{
					dId=rs1.getInt("Did");
					deptId=rs1.getInt("DeptId");
					name=rs1.getString("Name");
					
					if(dId!=docId)
					{
						v1.add("DocName = "+name+" ,"+"DocId = "+dId+" ,"+"DeptId = "+deptId);
					}
						
					
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        //referDocComboBox=new JComboBox<>(v1);
	        
		}
		else
		{
			/*Vector v2=new Vector();
	        v2.add("None");*/
	        
	        int dId=0,deptId=0;
	        String name=null;
	        
	        deptId=findingDeptId(docId,st);
	        
	        try {
				ResultSet rs2=st.executeQuery("Select Did,Name from Doctor Where DeptId="+deptId);
				
				while(rs2.next())
				{
					dId=rs2.getInt("Did");
					//deptId=rs2.getInt("DeptId");
					name=rs2.getString("Name");
					
					if(dId!=docId)
					{
						v1.add("DocName = "+name+" ,"+"DocId = "+dId+" ,"+"DeptId = "+deptId);
					}
						
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        
		}
		
		referDocComboBox=new JComboBox(v1);
		
		referDocComboBox.setBounds(220, 138, 437, 24);
		frame.getContentPane().add(referDocComboBox);
		
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = (String)referDocComboBox.getSelectedItem();
				if(!str.equalsIgnoreCase("None"))
				{
					
				str = str.replaceAll("[^-?0-9]+", ":");
				
				idList=  Arrays.asList(str.trim().split(":"));
				
				int newDocId=Integer.parseInt(idList.get(1));
				String SQL = "Update Record SET DId =? WHERE RecId=?";
				try {
					
					pstmt=con.prepareStatement(SQL);
					pstmt.setInt(1, newDocId);
					pstmt.setInt(2, recId);
					int status=pstmt.executeUpdate();
					
					if(status==1)
					{
						JOptionPane.showMessageDialog(frame,"Update Successfully!!");
						frame.dispose();
						new DoctorView(docId);
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					logs.LOGGER.info(""+e);
				}
				
				
				
				}
				else
				{	JOptionPane.showMessageDialog(frame, "Suitable Doctor not Found!!");
					System.out.println("Suitable Doctor not Found!!");
					logs.LOGGER.info("Suitable Doctor not Found!!");
				}
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DoctorPatientOptions(docId, pId, recId);
				frame.dispose();
				
			}
		});
	
	}
	
	public boolean checkDoctorRank(int docId,Statement sat)
	{
		 String rank = null;
		 try {
			
		 ResultSet rs = sat.executeQuery("select Rank from Doctor Where Did="+docId);
		 if(rs.next())
			rank=rs.getString("Rank");
		 //System.out.println(rank);
		 if(rank.equalsIgnoreCase("Specialist")||rank.equalsIgnoreCase("Senior_Specialist"))
		 {
			 return true;
		 }
		 
		} catch (Exception e) {
			logs.LOGGER.info(""+e);
			e.printStackTrace();
		}
		return false;
		
	}
	
	public int findingDeptId(int docId,Statement sat)
	{
		try {
			 rs = sat.executeQuery("select DeptId from Doctor Where Did="+docId);
			 if(rs.next())
				return rs.getInt("DeptId");
			 
			} catch (Exception e) {
				logs.LOGGER.info(""+e);
				e.printStackTrace();
			}
		return 0;
	}
}
