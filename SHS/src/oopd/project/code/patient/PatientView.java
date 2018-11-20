package oopd.project.code.patient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Button;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import oopd.project.code.HomePage;

import java.sql.*;
import javax.swing.JPasswordField;
public class PatientView {

	private JFrame frame;
	private String Patientname;
	private String PatientPassword;
	private JTextField textField;
	private int pid=0;

	//public static int pid;
	/**
	 * Launch the application.
	 */
	//static PatientView window=new PatientView();
	private JLabel lblPas;
	private ResultSet rs;
	private JPasswordField textField_1;
	private JButton btnBack;
	
	
	public PatientView() {
		

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


	/**
	 * Create the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Patient");
		frame.setBounds(100, 100, 711, 481);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setBounds(274, 159, 159, 24);
		textField.setColumns(10);
		int flag = 0;
			
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(274, 108, 293, 39);
		
		lblPas = new JLabel("Password");
		lblPas.setBounds(274, 195, 80, 47);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(274, 293, 72, 24);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Login successful");
				String username1 = textField.getText();
				String password1 = textField_1.getText();//Select Password from Patient where name=username1
				try{  
					//Class.forName("com.mysql.cj.jdbc.Driver");  
					
							Class.forName("com.mysql.jdbc.Driver");
							//connection setup
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");  
							//here shs_db is database name, root is username and password  is empty
							Statement  stmt=con.createStatement(); 
							
							System.out.println("1==="+username1);
							try
							{
							 rs=stmt.executeQuery("SELECT Name,Password FROM Patient "+
							"where Name='"+username1+"'");
							}
						    catch(Exception e){ System.out.println(e);}
							
								while(rs.next())  
								{
									Patientname=rs.getString(1);
									PatientPassword=rs.getString(2);       
								}
							
							//String pswrd=rs.getString(1);  
							
				if(username1.equals(Patientname) & password1.equals(PatientPassword))
				//if(password1.equals(pswrd))
				{
					System.out.println("Login Succsessfully done!");
					
					
						try
						{
						 rs=stmt.executeQuery("SELECT Pid FROM Patient "+
						"where Name='"+username1+"' and Password='"+password1+"'");
						 
						}
					    catch(Exception e){ System.out.println(e);}
						
							while(rs.next())  
							{
								//patientid=rs.getInt(1);
								pid=rs.getInt(1);

							}
							
					
					
					
					PatientWork patientwork = new PatientWork(pid);
					
					frame.dispose();
					//patientwork.invoke();    
					
				}
				else
				{
					System.out.println("Incorrect Info!");
					JOptionPane.showMessageDialog(frame, "Incorrect Info!Please correct it");
					//frame.dispose();
					
					
				}
				}catch(Exception e){ System.out.println(e);}
			}
			
		});
		
		JButton btnNewUser = new JButton("New User");
		btnNewUser.setBounds(597, 12, 102, 25);
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Hello......");
				//if new user in patient
				AddNewPatient addnewPatient = new AddNewPatient();
				frame.dispose();
				//addnewPatient.invoke();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblPas);
		frame.getContentPane().add(lblUserName);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(btnLogin);
		frame.getContentPane().add(btnNewUser);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(274, 241, 159, 24);
		frame.getContentPane().add(textField_1);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage homePage = new HomePage();
				homePage.invoke();
				frame.dispose();
			}
			
		});
		btnBack.setBounds(12, 12, 93, 25);
		frame.getContentPane().add(btnBack);
	}
}