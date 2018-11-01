package oopd.project.code;
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

public class DoctorSignIn {

	private JFrame frame;
	private String adminId="admin";
	private String adminPassword="admin";
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	static DoctorSignIn window=new DoctorSignIn();
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
	public DoctorSignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Doctor");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		int flag = 0;
		
		JLabel lblUserName = new JLabel("User Name");
		
		lblPas = new JLabel("Password");
		
		JButton btnLogin = new JButton("Login");
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
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
							.addGap(149))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPas, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(230))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
							.addGap(146))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPas, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(68))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
