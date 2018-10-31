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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtn1 = new JRadioButton("");
		
		JRadioButton rdbtn2 = new JRadioButton("");
		
		JRadioButton rdbtn3 = new JRadioButton("");
		
		JRadioButton rdbtn4 = new JRadioButton("");
		
		JRadioButton rdbtn5 = new JRadioButton("");
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtn1);
		G.add(rdbtn2);
		G.add(rdbtn3);
		G.add(rdbtn4);
		G.add(rdbtn5);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtn2.isSelected())
				{
					AddDoctor addDoctor = new AddDoctor();
					window.frame.dispose();
					addDoctor.invoke();
					
				}
				if(rdbtn1.isSelected())
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
		
		JLabel lblNewLabel = new JLabel("                       Welcome Admin");
		
		JLabel lblNewLabel_1 = new JLabel("You can perform following task");
		
		JLabel lblAddDoctor = new JLabel("1- Add Doctor");
		
		JLabel lblRemoveDoctor = new JLabel("2- Remove Doctor");
		
		JLabel lblViewPatient = new JLabel("3- View Patient Info");
		
		JLabel lblViewDoctor = new JLabel("4- View Doctor Info");
		
		JLabel lblReassignDoctor = new JLabel("5- Reassign Doctor");
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
									.addComponent(lblAddDoctor, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
									.addGap(21))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRemoveDoctor, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
									.addGap(10))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblViewPatient, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
									.addGap(10)))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtn3, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
								.addComponent(rdbtn2, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
								.addComponent(rdbtn1, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblViewDoctor, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
									.addGap(10))
								.addComponent(lblReassignDoctor, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtn5, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
								.addComponent(rdbtn4, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(225)))
					.addGap(47))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel)
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAddDoctor)
							.addGap(4)
							.addComponent(lblRemoveDoctor)
							.addGap(10)
							.addComponent(lblViewPatient))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(rdbtn3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbtn2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(rdbtn1)))
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblViewDoctor)
							.addGap(5)
							.addComponent(lblReassignDoctor))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(rdbtn5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbtn4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(btnNewButton))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
