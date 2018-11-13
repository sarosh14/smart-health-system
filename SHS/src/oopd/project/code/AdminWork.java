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
					AReassignDocId aReassignDocId = new AReassignDocId();
					window.frame.dispose();
					aReassignDocId.invoke();
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
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage homePage =new HomePage();
				window.frame.dispose();
				homePage.invoke();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
							.addGap(74))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
							.addGap(93))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAddDoctor, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
									.addGap(11))
								.addComponent(lblRemoveDoctor, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtn2, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
								.addComponent(rdbtn1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
							.addGap(20))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblViewPatient, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
							.addGap(56)
							.addComponent(rdbtn3, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblReassignDoctor, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
								.addComponent(lblViewDoctor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtn5, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtn4, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
									.addGap(10))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
							.addGap(252)))
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(358)
					.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAddDoctor, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(lblRemoveDoctor)
							.addGap(9))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtn2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(23))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(rdbtn1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblViewPatient, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtn3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblViewDoctor)
							.addGap(5)
							.addComponent(lblReassignDoctor))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(rdbtn5, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtn4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(26)))
					.addGap(27)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}