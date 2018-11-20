package oopd.project.code.admin;

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

import javax.swing.JPasswordField;

public class AdminView {

	private JFrame frame;
	private String adminId="admin";
	private String adminPassword="admin";
	private JTextField textField;

	


	 
	/**
	 * Launch the application.
	 */
	static AdminView window=new AdminView();
	private JLabel lblPas;
	private JPasswordField textField_1;
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
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
		private void initialize() {
		frame = new JFrame("Admin");
		frame.setBounds(100, 100, 790, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setBounds(260, 163, 226, 22);
		textField.setColumns(10);
		int flag = 0;
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(260, 128, 293, 29);
		
		lblPas = new JLabel("Password");
		lblPas.setBounds(260, 191, 226, 15);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(264, 276, 81, 25);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Login successful");
				String username1 = textField.getText();
				String password1 = textField_1.getText();
				
				if(username1.equals(adminId) & password1.equals(adminPassword))
				{
					//System.out.println("Login Succsessfully done!");
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
			}
			
		});
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(260, 218, 226, 22);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnLogin);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(lblPas);
		frame.getContentPane().add(lblUserName);
		frame.getContentPane().add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage homePage = new HomePage();
				window.frame.dispose();
				homePage.invoke();
			}
		});
		btnBack.setBounds(664, 12, 114, 25);
		frame.getContentPane().add(btnBack);
	}
}
