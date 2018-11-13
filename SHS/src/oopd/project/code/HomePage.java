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
					
				}
				else if(rdbtnNewRadioButton.isSelected())
				{
					//Patient
				}
				else if(rdbtnNewRadioButton_1.isSelected())
				{
					//Doctor
					DoctorView doctorView=new DoctorView();
					window.frame.dispose();
					doctorView.invoke();
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
					.addComponent(lblChooseAnyOne, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addComponent(lblAdmin, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(82)
					.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPatient)
						.addComponent(lblDoctor, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(125)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblChooseAnyOne)
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdmin)
						.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblPatient)
							.addGap(10)
							.addComponent(lblDoctor))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(btnNewButton))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
