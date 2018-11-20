package oopd.project.code.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import oopd.project.code.HomePage;

public class AdminWork {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static AdminWork window = new AdminWork();
	
	public void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					AdminWork window = new AdminWork();
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
	public AdminWork() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Admin");
		frame.setBounds(100, 100, 714, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtn1 = new JRadioButton("");
		rdbtn1.setBounds(402, 182, 149, 25);
		
		JRadioButton rdbtn2 = new JRadioButton("");
		rdbtn2.setBounds(402, 122, 149, 44);
		
		JRadioButton rdbtn3 = new JRadioButton("");
		rdbtn3.setBounds(402, 226, 159, 36);
		
		JRadioButton rdbtn4 = new JRadioButton("");
		rdbtn4.setBounds(403, 277, 287, 25);
		
		JRadioButton rdbtn5 = new JRadioButton("");
		rdbtn5.setBounds(403, 314, 169, 29);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtn1);
		G.add(rdbtn2);
		G.add(rdbtn3);
		G.add(rdbtn4);
		G.add(rdbtn5);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(196, 381, 104, 32);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtn2.isSelected())
				{
					AddDoctor addDoctor = new AddDoctor();
					window.frame.dispose();
					addDoctor.invoke();
					
				}
				else if(rdbtn1.isSelected())
				{
					ARemoveDoctor aRemoveDoctor = new ARemoveDoctor();
					window.frame.dispose();
					aRemoveDoctor.invoke();
				}
				else if(rdbtn3.isSelected())
				{
					AViewPatient aViewPatient = new AViewPatient();
					window.frame.dispose();
					aViewPatient.invoke();
				}
				else if(rdbtn4.isSelected())
				{
					AViewDoctor aViewDoctor = new AViewDoctor();
					window.frame.dispose();
					aViewDoctor.invoke();
				}
				else if(rdbtn5.isSelected())
				{
					AaddDepartment aaddDepartment = new AaddDepartment(); 
					window.frame.dispose();
					aaddDepartment.invoke();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("                       Welcome Admin");
		lblNewLabel.setBounds(210, 17, 295, 15);
		
		JLabel lblNewLabel_1 = new JLabel("You can perform following task");
		lblNewLabel_1.setBounds(196, 74, 276, 15);
		
		JLabel lblAddDoctor = new JLabel("1- Add Doctor");
		lblAddDoctor.setBounds(196, 122, 133, 44);
		
		JLabel lblRemoveDoctor = new JLabel("2- Remove Doctor");
		lblRemoveDoctor.setBounds(196, 178, 144, 29);
		
		JLabel lblViewPatient = new JLabel("3- View Patient Info");
		lblViewPatient.setBounds(196, 226, 144, 29);
		
		JLabel lblViewDoctor = new JLabel("4- View Doctor Info");
		lblViewDoctor.setBounds(196, 270, 144, 32);
		
		JLabel lblReassignDoctor = new JLabel("5- Add Department");
		lblReassignDoctor.setBounds(196, 314, 144, 29);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(622, 12, 92, 25);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage homePage =new HomePage();
				window.frame.dispose();
				homePage.invoke();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblAddDoctor);
		frame.getContentPane().add(lblRemoveDoctor);
		frame.getContentPane().add(rdbtn2);
		frame.getContentPane().add(rdbtn1);
		frame.getContentPane().add(lblViewPatient);
		frame.getContentPane().add(rdbtn3);
		frame.getContentPane().add(lblReassignDoctor);
		frame.getContentPane().add(lblViewDoctor);
		frame.getContentPane().add(rdbtn5);
		frame.getContentPane().add(rdbtn4);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnLogout);
	}

}