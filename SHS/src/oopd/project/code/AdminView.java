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

public class AdminView {

	private JFrame frame;
	private String adminId="admin";
	private String adminPassword="admin";
	private JTextField textField;
	private JTextField textField_1;

	 
	/**
	 * Launch the application.
	 */
	static AdminView window=new AdminView();
	private JLabel lblPas;
	public void invoke()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
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
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Admin");
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
				System.out.println("Login successful");
				String username1 = textField.getText();
				String password1 = textField_1.getText();
				
				if(username1.equals(adminId) & password1.equals(adminPassword))
				{
					System.out.println("Login Succsessfully done!");
					AdminWork adminWork = new AdminWork();
					window.frame.dispose();
					adminWork.invoke();
					
				}
				else
				{
					System.out.println("Incorrect Info!");
					JOptionPane.showMessageDialog(frame, "Incorrect Info!");
					window.frame.dispose();
					window.invoke();
					
				}
				
//				System.out.println("User name = "+username);
//				System.out.println("Password ="+password);
//				try {
//		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","");
//		 
//		            String sql = "INSERT INTO Doctor(Name, Password) values (?, ?)";
//		            PreparedStatement statement = conn.prepareStatement(sql);
//		            statement.setString(1, username);
//		            statement.setString(2, password);
//		 
//		            int row = statement.executeUpdate();
//		            if (row > 0) {
//		                System.out.println("Insert in Database successfully done.");
//		            }
//		            conn.close();
//		        } catch (SQLException ex) {
//		            ex.printStackTrace();
//		        } 
			
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(145)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(223))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPas)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addGap(146))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
								.addGap(145)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogin)
					.addGap(86))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}