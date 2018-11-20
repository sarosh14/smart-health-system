package oopd.project.code.doctor;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import oopd.project.logging.LogExceptionsToFile;

import javax.swing.JComboBox;
import javax.swing.JButton;


public class DocViewPatients extends JFrame {

	private int docId;
	private JFrame frame;
	JComboBox comboBox=new JComboBox() ;
	private Connection con;
    private ResultSet rs,rs1,rs2;
    private Statement st,st1,st2;
    String patientName;
	int patientId;
 int recId;
	int sortType;
	List<String> patientAppointmentList=new ArrayList<>();
	
    
    LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
	/**
	 * Create the frame.
	 * 
	 */
	public DocViewPatients(int docId, int sortType) {
		this.docId=docId;
		this.sortType=sortType;
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
	
	void initialize() {
		//System.out.println(docId);
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 502);
		frame.setTitle("Patient Appointment List");
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("       Patient Appointment List");
		
		titleLabel.setBounds(83, 37, 543, 61);
		titleLabel.setForeground(Color.red);

		titleLabel.setFont(new Font("Serif", Font.BOLD,30));
		frame.getContentPane().add(titleLabel);
		
		JLabel patientLabel = new JLabel("PatientList");
		patientLabel.setBounds(64, 166, 179, 35);
		frame.getContentPane().add(patientLabel);
		
		
		
		//database
		try {

            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
            st = (Statement) con.createStatement();
            st1=(Statement) con.createStatement();
            st2=(Statement) con.createStatement();
    
            
            long time=System.currentTimeMillis();
        	Date date=new Date(time);
        	String dt=""+date;
        	dt=dt.replaceAll("-","");
        	String mod="'"+dt+"'";
        	
        	  Vector v = new Vector();
              v.add("None");
              
              Date dischargeDate;
            if(sortType==1)
            {
            	//System.out.println("in by id "+mod);
            rs = st.executeQuery("select Pid,RecId,Discharge_Date from Record Where Did="+docId+" and Admit_Date >= "+mod+" ORDER BY Pid");
            
            while (rs.next()) {

                
                patientId = rs.getInt("Pid");
                recId=rs.getInt("RecId");
                dischargeDate=rs.getDate("Discharge_Date");
             //  patientAppointmentList.add(recId);
                if(dischargeDate==null)
                {
                rs1=st1.executeQuery("select Name from Patient Where Pid="+patientId);
                rs1.next();
                patientName = rs1.getString("Name");
              
               
                v.add("Name = "+patientName+" ,"+"Pid = "+patientId+" ,"+"RecId = "+recId);
                }
            	}
          
            }
            else if(sortType==2)
            {
            	//System.out.println("in by name: "+mod);
            	
            	 rs = st.executeQuery("select Pid from Patient where Pid in (select Pid from Record Where Did="+docId+" and Admit_Date >= "+mod+")"+" ORDER BY Patient.Name");
            	
            	  while (rs.next()) {

                      
                      patientId = rs.getInt("Pid");
                      
                      rs2=st2.executeQuery("select RecId,Discharge_Date from Record Where Did="+docId+" and Pid="+patientId);
                      if(rs2.next())
                      recId=rs2.getInt("RecId");
                      dischargeDate=rs2.getDate("Discharge_Date");
                    // patientAppointmentList.add(patientId);
                      if(dischargeDate==null)
                      {
                      rs1=st1.executeQuery("select Name from Patient Where Pid="+patientId);
                      rs1.next();
                      patientName = rs1.getString("Name");
                    
                     
                      v.add("Name = "+patientName+" ,"+"Pid = "+patientId+" ,"+"RecId = "+recId);
                      }
                  	}
            	  
            	
            	 
            }
         

          
           
            	
               

                
            
            comboBox=new JComboBox(v);
        
           
           
            
		 }
         catch(Exception e)
         {
            System.out.println("Database Error!");
            logs.LOGGER.severe("Database Error : "+e);
         }
		finally {
			try {
			st.close();
			st1.close();
			rs.close();
		//	rs1.close();
			}catch(Exception e)
			{	e.printStackTrace();
				logs.LOGGER.warning("Closing Db instances "+e);
			}
		}
		
		comboBox.setBounds(320, 166, 341, 35);
		frame.getContentPane().add(comboBox);
		frame.getContentPane().setLayout(null);
		
		JButton selectPatientButton = new JButton("Select Patient");
		selectPatientButton.setBounds(64, 318, 156, 25);
		frame.getContentPane().add(selectPatientButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(556, 12, 114, 25);
		frame.getContentPane().add(backButton);
		
		selectPatientButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = (String)comboBox.getSelectedItem();
				if(!str.equalsIgnoreCase("None"))
				{
					
				str = str.replaceAll("[^-?0-9]+", ":");
				
				patientAppointmentList=  Arrays.asList(str.trim().split(":"));
				
				patientId=Integer.parseInt(patientAppointmentList.get(1));
				recId=Integer.parseInt(patientAppointmentList.get(2));
				
				//System.out.println("rec"+recId+"  :  "+patientId);
				new DoctorPatientOptions(docId, patientId,recId);
				JOptionPane.showMessageDialog(frame, "Patient Selected with ID : "+patientId);
				frame.dispose();
				
				}
				else
				{	JOptionPane.showMessageDialog(frame, "Patient not Selected!!");
					System.out.println("patient not selected");
					logs.LOGGER.info("patient not selected");
				}
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new DoctorSortPatient(docId);
				frame.dispose();
			}
		});
		
		
	}
}
