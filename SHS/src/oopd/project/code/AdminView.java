package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class AdminView {

	private JFrame frame;
	private String adminId="admin";
	private String adminPassword="admin";
	private JTextField textField;
	private JTextField textField_1;
	private JTextPane txtpnPassword;
	 
	/**
	 * Launch the application.
	 */
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(145, 74, 149, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 145, 149, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtpnUserName = new JTextPane();
		txtpnUserName.setText("User Name");
		txtpnUserName.setBounds(145, 41, 149, 21);
		frame.getContentPane().add(txtpnUserName);
		
		txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(144, 112, 150, 21);
		frame.getContentPane().add(txtpnPassword);
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Login successful");
				String username = textField.getText();
				String password = textField_1.getText();
				System.out.println("User name = "+username);
				System.out.println("Password ="+password);
				try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","");
		 
		            String sql = "INSERT INTO Doctor(Name, Password) values (?, ?)";
		            PreparedStatement statement = conn.prepareStatement(sql);
		            statement.setString(1, username);
		            statement.setString(2, password);
		 
		            int row = statement.executeUpdate();
		            if (row > 0) {
		                System.out.println("Insert in Database successfully done.");
		            }
		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        } 
			}
		});
		button.setBounds(154, 192, 86, 23);
		frame.getContentPane().add(button);
	}
}