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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;

public class PatientWork {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static PatientWork window = new PatientWork();
	
	public void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					PatientWork window = new PatientWork();
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
	public PatientWork() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Patient");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtn1 = new JRadioButton("");
		
		JRadioButton rdbtn2 = new JRadioButton("");

		ButtonGroup G = new ButtonGroup();
		G.add(rdbtn1);
		G.add(rdbtn2);
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtn2.isSelected())
				{  
					// Open screen, appointment manually or automatically
					BookAppointment bookappointment=new BookAppointment();
					window.frame.dispose();
					bookappointment.invoke();
					
				}
				if(rdbtn1.isSelected())
				{
					//edit Profile
					PatientEditProfile patienteditprofile = new PatientEditProfile();
					window.frame.dispose();
					patienteditprofile.invoke();
				}
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("                       Welcome Patient");
		
		JLabel lblNewLabel_1 = new JLabel("You can perform following task");
		
		JLabel lblAddDoctor = new JLabel("1- Book Appointment");
		
		JLabel lblRemoveDoctor = new JLabel("2- Edit Profile");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
							.addGap(54))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
							.addGap(73))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAddDoctor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(21))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRemoveDoctor, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
									.addGap(10)))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtn2, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addComponent(rdbtn1, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(225)))
					.addGap(47))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAddDoctor, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(lblRemoveDoctor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtn2, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(17))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(rdbtn1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(49)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(79))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		
		
		
		
	}

}
