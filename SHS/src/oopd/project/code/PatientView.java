package oopd.project.code;

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
import java.sql.*;
public class PatientView {

	private JFrame frame;
	private String Patientname;
	private String PatientPassword;
	private JTextField textField;
	private JTextField textField_1;
	public static int patientid;
	/**
	 * Launch the application.
	 */
	static PatientView window=new PatientView();
	private JLabel lblPas;
	private ResultSet rs;
	public void invoke()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PatientView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Patient");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		int flag = 0;
		
		JLabel lblUserName = new JLabel("User Name");
		
		lblPas = new JLabel("Password");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Login successful");
				String username1 = textField.getText();
				String password1 = textField_1.getText();//Select Password from Patient where name=username1
				try{  
					//Class.forName("com.mysql.cj.jdbc.Driver");  
					
							Class.forName("com.mysql.jdbc.Driver");
							//connection setup
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","");  
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
								patientid=rs.getInt(1);
							}
							
					
					
					
					PatientWork patientwork = new PatientWork();
					
					window.frame.dispose();
					patientwork.invoke();    
					
				}
				else
				{
					System.out.println("Incorrect Info!");
					JOptionPane.showMessageDialog(frame, "Incorrect Info!Please correct it");
					window.frame.dispose();
					window.invoke();
					
				}
				}catch(Exception e){ System.out.println(e);}
			}
			
		});
		
		JButton btnNewUser = new JButton("New User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if new user in patient
				AddNewPatient addnewPatient = new AddNewPatient();
				window.frame.dispose();
				addnewPatient.invoke();
			}
		});
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(145)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPas, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(225))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addGap(146))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
							.addGap(145))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(212))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(327)
					.addComponent(btnNewUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(21))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(4)
					.addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(86))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}