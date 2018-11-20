package oopd.project.code.doctor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import oopd.project.code.HomePage;
import oopd.project.logging.LogExceptionsToFile;
import java.sql.*;

public class DoctorSignIn {
	
	LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
	private JFrame frame;
	private String adminId="admin";
	private String adminPassword="admin";
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblPas;
	
	Connection con;

	    ResultSet rs;

	    Statement st;
	    private JButton btnHomepage;

	
	
	/**
	 * Create the application.
	 */
	public DoctorSignIn() {
		

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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Doctor");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		textField = new JTextField();
		textField.setColumns(20);
		int flag = 0;
		
		JLabel lblUserName = new JLabel("User Name");
		passwordField = new JPasswordField();
		
		lblPas = new JLabel("Password");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Login successful");
				String username = textField.getText();
				String password = passwordField.getText();
				String name,pass;
				int docId = 0;
				int flag=0;
				
				//database conn
				try {

		            Class.forName("com.mysql.jdbc.Driver");

		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "");
		            st = con.createStatement();
		            rs = st.executeQuery("select Did,Name,Password from Doctor");
		            while (rs.next()) {
		            	docId=rs.getInt("Did");
		                name = rs.getString("Name");
		                pass=rs.getString("Password");
		              
		                if(username.equals(name) & password.equals(pass))
						{
							flag=1;
							break;
						}
		            }
		            
				}catch (Exception e) {
					System.out.println(e);
					logs.LOGGER.warning("Database exception");
		        }
				
				
				if(flag==1)
				{
				DoctorView doctorView = new DoctorView(docId);
				
				
			frame.dispose();
				
				
				
			}
			else
			{	logs.LOGGER.warning("Incorrect Doctor userName or password!");
				System.out.println("Incorrect Doctor userName or password!");
				JOptionPane.showMessageDialog(frame, "Incorrect Doctor userName or password!");
				
			}
				
			}		
		});
		
		btnHomepage = new JButton("HomePage");
		btnHomepage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HomePage homePage=new HomePage();
				frame.dispose();
				homePage.invoke();
			}
		});
		
		//textField_1 = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(145)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(214))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addGap(149))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPas, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(230))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addGap(146))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(331, Short.MAX_VALUE)
					.addComponent(btnHomepage)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(btnHomepage)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPas, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(68))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
