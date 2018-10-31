package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

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
					AdminWork window = new AdminWork();
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtn1 = new JRadioButton("");
		rdbtn1.setBounds(259, 96, 144, 21);
		frame.getContentPane().add(rdbtn1);
		
		JRadioButton rdbtn2 = new JRadioButton("");
		rdbtn2.setBounds(259, 77, 144, 23);
		frame.getContentPane().add(rdbtn2);
		
		JRadioButton rdbtn3 = new JRadioButton("");
		rdbtn3.setBounds(259, 116, 144, 23);
		frame.getContentPane().add(rdbtn3);
		
		JRadioButton rdbtn4 = new JRadioButton("");
		rdbtn4.setBounds(259, 141, 144, 25);
		frame.getContentPane().add(rdbtn4);
		
		JRadioButton rdbtn5 = new JRadioButton("");
		rdbtn5.setBounds(259, 158, 144, 31);
		frame.getContentPane().add(rdbtn5);
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtn1);
		G.add(rdbtn2);
		G.add(rdbtn3);
		G.add(rdbtn4);
		G.add(rdbtn5);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtn1.isSelected())
				{
					AddDoctor addDoctor = new AddDoctor();
					window.frame.dispose();
					addDoctor.invoke();
					
				}
				if(rdbtn2.isSelected())
				{
					//REmove doctor
				}
				if(rdbtn3.isSelected())
				{
					//view patient info
				}
				if(rdbtn4.isSelected())
				{
					//view doctor info
				}
				if(rdbtn5.isSelected())
				{
					//ReassignDoctor
				}
			}
		});
		btnNewButton.setBounds(64, 201, 114, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("                       Welcome Admin");
		lblNewLabel.setBounds(64, 12, 285, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("You can perform following task");
		lblNewLabel_1.setBounds(64, 38, 266, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblAddDoctor = new JLabel("1- Add Doctor");
		lblAddDoctor.setBounds(64, 77, 128, 15);
		frame.getContentPane().add(lblAddDoctor);
		
		JLabel lblRemoveDoctor = new JLabel("2- Remove Doctor");
		lblRemoveDoctor.setBounds(64, 96, 139, 15);
		frame.getContentPane().add(lblRemoveDoctor);
		
		JLabel lblViewPatient = new JLabel("3- View Patient Info");
		lblViewPatient.setBounds(64, 121, 149, 15);
		frame.getContentPane().add(lblViewPatient);
		
		JLabel lblViewDoctor = new JLabel("4- View Doctor Info");
		lblViewDoctor.setBounds(64, 141, 139, 15);
		frame.getContentPane().add(lblViewDoctor);
		
		JLabel lblReassignDoctor = new JLabel("5- Reassign Doctor");
		lblReassignDoctor.setBounds(64, 161, 149, 15);
		frame.getContentPane().add(lblReassignDoctor);
	}

}
