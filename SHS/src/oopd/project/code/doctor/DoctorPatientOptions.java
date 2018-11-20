package oopd.project.code.doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import oopd.project.logging.LogExceptionsToFile;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class DoctorPatientOptions extends JFrame {
	
	private int docId,pId,recId;
	private JFrame frame;
	Connection con ;
	
	  ResultSet rs;
	  
	LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
	/**
	 * Create the frame.
	 */
	public DoctorPatientOptions(int docId, int pId,int recId) {
		this.docId=docId;
		this.pId=pId;
		this.recId=recId;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "");
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String[] columnNames = {"Did","Test_Adviced","Test_Report","Medicine_Prescribed", "Date","Patient_Status","Fees_Per_Day","WardId","Location"};
	//to display the patient history
	 public void showTableData() 
	 {
	       JFrame frame1 = new JFrame("Database Search Result");
	        frame1.setVisible(true);
	        frame1.getContentPane().setLayout(new BorderLayout());
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columnNames);
	       JTable table = new JTable();
	        table.setModel(model);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        table.setFillsViewportHeight(true);
	        JScrollPane scroll = new JScrollPane(table);
	        scroll.setHorizontalScrollBarPolicy(

	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	        scroll.setVerticalScrollBarPolicy(

	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	//String textvalue = textbox.getText();

	        String Did = "";
	        String Test_Adviced="";
	        String Test_Report  = "";
	        String Medicine_Prescribed="";
	        String Date = "";
	        String Patient_Status = "";
	        String Fees_Per_Day= "";
	        String WardId= "";
	        String Location= "";
	        try {
	        	System.out.println("pid =="+pId);
	        	
	            PreparedStatement pst = (PreparedStatement) con.prepareStatement("select Did,Test_Adviced,Test_Report,Medicine_Prescribed,"
	            		+ "Date,Patient_Status,Fees_Per_Day,WardId,Location"
	            		+ " from Patient_History where RecId in (select RecId from Record where Pid = "+pId+" )");

	             rs = pst.executeQuery();

	            int i = 0;
	            while(rs.next()) {
	            	
	                Did = rs.getString("Did");
	                System.out.println("Did = "+Did);
	                Test_Adviced= rs.getString("Test_Adviced");
	                System.out.println("Test_Adviced = "+Test_Adviced);
	                Test_Report=rs.getString("Test_Report");
	                Medicine_Prescribed = rs.getString("Medicine_Prescribed");
	                Date = rs.getString("Date");
	                Patient_Status=rs.getString("Patient_Status");
	                Fees_Per_Day=rs.getString("Fees_Per_Day");
	                WardId = rs.getString("WardId");
	                Location = rs.getString("Location");
	                model.addRow(new Object[]{Did,Test_Adviced,Test_Report, Medicine_Prescribed, 
							Date,Patient_Status,Fees_Per_Day,WardId,Location});

	                i++;

	            }
	            if (i < 1) {
	                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
	            }

	            if (i == 1) {
	                System.out.println(i + " Record Found");
	            } else {
	                System.out.println(i + " Records Found");
	            }
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        frame1.getContentPane().add(scroll);
	        frame1.setVisible(true);
	        frame1.setSize(400, 300);
	    }	
	
	void Discharge(int recId,int docId)
	{
		 Date date=new Date(System.currentTimeMillis());
		 try {
			 String SQL = "Update Record SET Discharge_Date =? WHERE RecId = ?";
		PreparedStatement pst=(PreparedStatement) con.prepareStatement(SQL);
		pst.setDate(1, date);
		pst.setInt(2, recId);
		int status=pst.executeUpdate();
		if(status==1)
		{
			JOptionPane.showMessageDialog(frame,"Discharged Successfully!!");
			frame.dispose();
			new DoctorView(docId);
	
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logs.LOGGER.info(""+e);
		}
		 
	}
	
	void initialize() {
		//System.out.println(docId);
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 502);
		frame.setTitle("Patients List");
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("       Choose a Option ");
		titleLabel.setBounds(83, 12, 543, 61);
		titleLabel.setForeground(Color.red);

		titleLabel.setFont(new Font("Serif", Font.BOLD,30));
		frame.getContentPane().add(titleLabel);
		
		JRadioButton treatmentRadioButton = new JRadioButton("Start Treatment");
		treatmentRadioButton.setBounds(215, 142, 210, 23);
		frame.getContentPane().add(treatmentRadioButton);
		
		JRadioButton historyRadioButton = new JRadioButton("View History");
		historyRadioButton.setBounds(215, 181, 202, 23);
		frame.getContentPane().add(historyRadioButton);
		
		JRadioButton referRadio = new JRadioButton("Refer to Other Doctor");
		referRadio.setBounds(217, 221, 225, 23);
		frame.getContentPane().add(referRadio);
		
		JRadioButton dischargeRadioButton = new JRadioButton("Discharge Patient");
		dischargeRadioButton.setBounds(215, 258, 227, 23);
		frame.getContentPane().add(dischargeRadioButton);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(139, 325, 114, 25);
		frame.getContentPane().add(submitButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(417, 325, 114, 25);
		frame.getContentPane().add(backButton);
		
		JRadioButton rdbtnViewPatientDescription = new JRadioButton("View Patient Description");
		rdbtnViewPatientDescription.setBounds(215, 106, 250, 23);
		frame.getContentPane().add(rdbtnViewPatientDescription);
		
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(treatmentRadioButton);
		buttonGroup.add(referRadio);
		buttonGroup.add(dischargeRadioButton);
		buttonGroup.add(historyRadioButton);
		buttonGroup.add(rdbtnViewPatientDescription);
		
		
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DoctorSortPatient(docId);
				frame.dispose();
			}
		});
		
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(rdbtnViewPatientDescription.isSelected())
				{
					new PatientDescInDoctor(docId, pId, recId);
					frame.dispose();
				}
				else if(treatmentRadioButton.isSelected())
				{
					new DoctorTreatment(docId, pId, recId);
					frame.dispose();
				}
				else if(historyRadioButton.isSelected())
				{
					showTableData();
					//frame.dispose();
				}
				else if(referRadio.isSelected())
				{
					new DoctorRefer(docId, pId, recId);
					frame.dispose();
				}
				else if(dischargeRadioButton.isSelected())
				{
					//changes only in record table i.e. discharge date
					 Discharge(recId,docId);
					
				}
				else
				{
					System.out.println("You have not selected any Option!");
					JOptionPane.showMessageDialog(frame, "You have not selected any Option!");
					logs.LOGGER.info("You have not selected any Option!");
				}
			
			}
		});
		
		
	}
}
