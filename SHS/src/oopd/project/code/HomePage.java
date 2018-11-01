package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("SHS Home-Page");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton radioButton = new JRadioButton("");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		
		ButtonGroup G = new ButtonGroup();
		G.add(radioButton);
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton.isSelected())
				{
					AdminView adminView = new AdminView();
					window.frame.dispose();
					adminView.invoke();
//					DoctorProfile doctorProfile =new DoctorProfile();
//					window.frame.dispose();
//					doctorProfile.invoke();
					
				}
				else if(rdbtnNewRadioButton.isSelected())
				{   
					PatientView PatientView = new PatientView();
					window.frame.dispose();
					PatientView.invoke();
					//Patient
				}
				else if(rdbtnNewRadioButton_1.isSelected())
				{
					//Doctor
				}
					
				
			}
		});
		
		JLabel lblChooseAnyOne = new JLabel("Choose Any one option");
		
		JLabel lblAdmin = new JLabel("Admin");
		
		JLabel lblPatient = new JLabel("Patient");
		
		JLabel lblDoctor = new JLabel("Doctor");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addComponent(lblChooseAnyOne, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
					.addGap(206))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(286))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblPatient, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
											.addGap(10))
										.addComponent(lblAdmin, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
									.addGap(54))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDoctor, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(102))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(111))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseAnyOne, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAdmin, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
							.addGap(16)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblPatient, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
							.addGap(6)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblDoctor, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(rdbtnNewRadioButton_1, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
					.addGap(25)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
					.addGap(50))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
