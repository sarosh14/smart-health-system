package oopd.project.code.patient;

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
import java.awt.BorderLayout;

public class BookAppointment {

	private JFrame frame;
	private int pid;

	/**
	 * Launch the application.
	 */
	
	
	public  BookAppointment(int pid) {
		this.pid=pid;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					BookAppointment window = new BookAppointment();
					//window.frame.setVisible(true);
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
		frame.setBounds(100, 100, 563, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JRadioButton rdbtn1 = new JRadioButton("");
		rdbtn1.setBounds(325, 208, 78, 21);
		
		JRadioButton rdbtn2 = new JRadioButton("");
		rdbtn2.setBounds(325, 143, 78, 23);

		ButtonGroup G = new ButtonGroup();
		G.add(rdbtn1);
		G.add(rdbtn2);
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(65, 270, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtn2.isSelected())
				{
					
					PatientDescription patientdesc=new PatientDescription(pid);
					frame.dispose();
					//patientdesc.invoke();
					
					
				}
				else if(rdbtn1.isSelected())
				{
					PatientAI patientAI = new PatientAI(pid);
					frame.dispose();
				}
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("                       Welcome Patient");
		lblNewLabel.setBounds(118, 0, 285, 15);
		
		JLabel lblNewLabel_1 = new JLabel("You can perform following task");
		lblNewLabel_1.setBounds(63, 83, 266, 15);
		
		JLabel lblAddDoctor = new JLabel("1- Appointment Manually");
		lblAddDoctor.setBounds(63, 151, 194, 15);
		
		JLabel lblRemoveDoctor = new JLabel("2- Appointment Automatically");
		lblRemoveDoctor.setBounds(65, 208, 205, 15);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblAddDoctor);
		frame.getContentPane().add(lblRemoveDoctor);
		frame.getContentPane().add(rdbtn2);
		frame.getContentPane().add(rdbtn1);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PatientWork(pid);
				frame.dispose();
			}
		});
		btnBack.setBounds(437, 12, 114, 25);
		frame.getContentPane().add(btnBack);
		
		
		
		
		
	}

}
