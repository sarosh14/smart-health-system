package oopd.project.code.doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;
import com.sun.org.apache.regexp.internal.RE;

import oopd.project.code.admin.AdminWork;
import oopd.project.logging.LogExceptionsToFile;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class DoctorTreatment extends JFrame {

	private int docId,pId,recId;
	private JFrame frame;
	LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
	private JTextField diseaseTextField;

	
	public DoctorTreatment(int docId, int pId ,int recId) {
		this.docId=docId;
		this.pId=pId;
		this.recId=recId;
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
		frame.setTitle("Patient Treatment");
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("        Treatment Form ");
		titleLabel.setBounds(105, 12, 543, 51);
		titleLabel.setForeground(Color.red);

		titleLabel.setFont(new Font("Serif", Font.BOLD,30));
		frame.getContentPane().add(titleLabel);
		
		JLabel testLabel = new JLabel("Test Adviced");
		testLabel.setBounds(105, 90, 157, 15);
		frame.getContentPane().add(testLabel);
		
		JLabel Medicinelabel = new JLabel("Medicines Prescribed");
		Medicinelabel.setBounds(105, 206, 157, 15);
		frame.getContentPane().add(Medicinelabel);
		
		JLabel statusLabel = new JLabel("Patient status");
		statusLabel.setBounds(105, 275, 157, 30);
		frame.getContentPane().add(statusLabel);
		
		JLabel locationLabel = new JLabel("Location");
		locationLabel.setBounds(105, 327, 147, 35);
		frame.getContentPane().add(locationLabel);
		
		JComboBox statusComboBox = new JComboBox();
		statusComboBox.setBounds(352, 282, 283, 24);
		frame.getContentPane().add(statusComboBox);
		statusComboBox.addItem("None");
		statusComboBox.addItem("NonCritical");
		statusComboBox.addItem("Critical");
		
		JComboBox locationComboBox = new JComboBox();
		locationComboBox.setBounds(352, 332, 283, 24);
		frame.getContentPane().add(locationComboBox);
		locationComboBox.addItem("None");
		locationComboBox.addItem("Local");
		locationComboBox.addItem("OPD");
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(105, 416, 114, 25);
		frame.getContentPane().add(submitButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(319, 416, 114, 25);
		frame.getContentPane().add(backButton);
		
		JTextArea testArea = new JTextArea();
		testArea.setBounds(352, 90, 281, 51);
		testArea.setAutoscrolls(true);
	//	JScrollPane sp = new JScrollPane(testArea);
		frame.getContentPane().add(testArea);
		
		JTextArea medicineArea = new JTextArea();
		medicineArea.setBounds(352, 206, 281, 51);
		medicineArea.setAutoscrolls(true);
	//	JScrollPane sp1 = new JScrollPane(medicineArea);
		frame.getContentPane().add(medicineArea);
		
		JLabel label = new JLabel("Disease Identified");
		label.setBounds(105, 153, 147, 30);
		frame.getContentPane().add(label);
		
		diseaseTextField = new JTextField();
		diseaseTextField.setBounds(352, 153, 283, 41);
		frame.getContentPane().add(diseaseTextField);
		diseaseTextField.setColumns(10);
	
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new DoctorPatientOptions(docId, pId, recId);
				frame.dispose();
				
			}
		});
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String testAdvice=testArea.getText();
				String medicine=medicineArea.getText();
				String status=statusComboBox.getSelectedItem().toString();
				String location=locationComboBox.getSelectedItem().toString();
				String diseaseIdentity=diseaseTextField.getText();
				//both can not be null at same time
				if(testAdvice.length()==0 && medicine.length()==0)
				{
					JOptionPane.showMessageDialog(frame, "First two field cannot be null at same time");
					logs.LOGGER.info("First two field cannot be null at same time");
				}
				else if(diseaseIdentity.length()==0 && medicine.length()==0)
				{
					JOptionPane.showMessageDialog(frame, "DiseaseIdentity and Medicine field cannot be null at same time");
					logs.LOGGER.info("First two field cannot be null at same time");
				}
				else if(testAdvice.length()==0 && medicine.length()==0 && diseaseIdentity.length()==0)
				{
					JOptionPane.showMessageDialog(frame, "First three field cannot be null at same time");
					logs.LOGGER.info("First two field cannot be null at same time");
				}
				else if(status.equalsIgnoreCase("None")||location.equalsIgnoreCase("None"))
				{
					JOptionPane.showMessageDialog(frame, "Location and status can not be None");
					logs.LOGGER.info("Location and status can not be None");
				}
				else
				{
					
					try {
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
			           Statement st = (Statement) conn.createStatement();
			            ResultSet rs = st.executeQuery("select OpdFees from Doctor Where Did="+docId);
			            String sql = "INSERT INTO Patient_History(Did, RecId, Test_Adviced, Test_Report, Medicine_Prescribed, Date, Patient_Status, Fees_Per_Day, Location) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			            int fees = 0;
			            PreparedStatement statement = conn.prepareStatement(sql);
			            statement.setInt(1, docId);
			            statement.setInt(2, recId);
			            statement.setString(3, testAdvice);
			            statement.setString(4, "");
			            statement.setString(5, medicine);
			            Date date=new Date(System.currentTimeMillis());		            
			            statement.setDate(6, date);
			            statement.setString(7, status);
			            
			            //disease & location both will be inserted together
			            if(diseaseIdentity.length()!=0)
			            {
			            String SQL = "Update Record SET Disease_Identified =?,Location =? WHERE RecId = ?";
			    		PreparedStatement pst=(PreparedStatement) conn.prepareStatement(SQL);
			    		pst.setString(1, diseaseIdentity);
			    		pst.setString(2,location);
			    		pst.setInt(3, recId);
			    		int status1=pst.executeUpdate();
			    		if(status1==1)
			    		{
			    			System.out.println("Disease_Identified and location inserted Successfully");
			    			logs.LOGGER.info("Disease_Identified and location inserted Successfully");
			    	
			    		}
			            }
			            if(rs.next())
			            	fees=rs.getInt("OpdFees");
			            statement.setInt(8, fees);
			            statement.setString(9, location);
			           
			            
			            int row = statement.executeUpdate();
			            if (row > 0) {
			                System.out.println("Insert in Database successfully done.");
			                JOptionPane.showMessageDialog(frame, "Successfully Added !");
			              new DoctorPatientOptions(docId, pId, recId);
							frame.dispose();
							
			            }
			            conn.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        } 
				//	System.out.println(testAdvice+" : "+medicine+" : "+"  :  "+location+"  : "+status);
				}
			}
		});
		
	}
	
	
	
}
