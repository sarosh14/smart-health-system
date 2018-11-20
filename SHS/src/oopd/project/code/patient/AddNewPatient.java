package oopd.project.code.patient;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Date;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddNewPatient {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField dtrpnAddress;
	private JTextField textField_6;
	private JComboBox comboBox;
	private JTextField textField_1;
	private JButton btnNewButton;
	//private int pid;
	/**
	 * Launch the application.
	 */
	//static AddNewPatient window = new AddNewPatient();
	private JLabel lblYyyymmdd;
	private JButton btnBack;
	public AddNewPatient() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					//window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add New Patient");
		frame.setBounds(100, 100, 695, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
			
		
		JTextField dtrpnName = new JTextField();
		dtrpnName.setBounds(95, 27, 163, 26);
		dtrpnName.setText("1- Name");
		dtrpnName.setEditable(false);
		frame.getContentPane().add(dtrpnName);
		
		JTextField dtrpnDepartmentId = new JTextField();
		dtrpnDepartmentId.setBounds(95, 260, 159, 30);
		dtrpnDepartmentId.setText("5- Contact No.");
		frame.getContentPane().add(dtrpnDepartmentId);
		dtrpnDepartmentId.setEditable(false);
		
		JTextField dtrpnRank = new JTextField();
		dtrpnRank.setBounds(95, 318, 135, 30);
		dtrpnRank.setText("6- Password");
		frame.getContentPane().add(dtrpnRank);
		dtrpnRank.setEditable(false);
		
		JTextField dtrpnDob = new JTextField();
		dtrpnDob.setBounds(95, 74, 163, 30);
		dtrpnDob.setText("2- D.O.B");
		frame.getContentPane().add(dtrpnDob);
		dtrpnDob.setEditable(false);
		
		JTextField dtrpnGender = new JTextField();
		dtrpnGender.setBounds(95, 134, 164, 30);
		dtrpnGender.setText("3- Gender");
		frame.getContentPane().add(dtrpnGender);
		dtrpnGender.setEditable(false);
		
		dtrpnAddress = new JTextField();
		dtrpnAddress.setBounds(95, 196, 159, 36);
		dtrpnAddress.setText("4- Address");
		dtrpnAddress.setEditable(false);
		frame.getContentPane().add(dtrpnAddress);
		dtrpnAddress.setEditable(false);
		
		textField = new JTextField();
		textField.setBounds(303, 25, 174, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(303, 78, 170, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(300, 260, 173, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		textField_4 = new JTextField();
		textField_4.setBounds(300, 320, 173, 28);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		

		textField_6 = new JTextField();
		textField_6.setBounds(300, 199, 173, 30);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		lblYyyymmdd = new JLabel("* yyyy/MM/dd");
		lblYyyymmdd.setBounds(517, 78, 124, 21);
		frame.getContentPane().add(lblYyyymmdd);
		
		//frame.getContentPane().add(combobox1);
		String gender[]={"None","M","F"}; 
		comboBox = new JComboBox(gender);
		comboBox.setBounds(302, 136, 77, 24);
		frame.getContentPane().add(comboBox);
		btnNewButton = new JButton("Add");
		btnNewButton.setBounds(95, 377, 148, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String gend = comboBox.getSelectedItem().toString();

				
				//String gend = (String)comboBox.getEditor().getItem();
				//System.out.println("sxxsxs"+gend);
				String patientname = textField.getText();
				String dob = textField_1.getText();
				String address = textField_6.getText();
				String contact = textField_3.getText();
				String password = textField_4.getText();
				//String location1 = combobox1.getSelectedItem().toString();
				if(gend.length()==0 || patientname.length()==0 || dob.length()==0 || address.length()==0 || contact.length()==0 || 
						password.length()==0)
				{
					JOptionPane.showMessageDialog(frame, "All Fields require!");
					
				}
				else
				{
				try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
		            String sql = "INSERT INTO Patient(Name, DOB, Gender, Address, ContactNo, Password ) Values (?, ?, ?, ?, ?, ?) ";
		            PreparedStatement statement = conn.prepareStatement(sql);
		            statement.setString(1, patientname);
		            statement.setString(2, dob);
		            statement.setString(3, gend);
		            statement.setString(4, address);
		            statement.setString(5, contact);
		            statement.setString(6, password);
		            int row = statement.executeUpdate();
		            if (row > 0) {
		                //System.out.println("Insert in Database successfully done.");
		                JOptionPane.showMessageDialog(frame, "Successfully Added !");
		                new PatientView();
		                frame.dispose();
		            }
		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
				}
			}
		});
		
		
		
		btnBack = new JButton("Back");
		btnBack.setBounds(303, 377, 163, 25);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PatientView patientView =  new PatientView(); 
				frame.dispose();
			}
		});
		
		
		
	          

	
	}
}
