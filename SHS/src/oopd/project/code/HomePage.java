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

import oopd.project.code.admin.AdminView;
import oopd.project.code.doctor.DoctorSignIn;
import oopd.project.code.patient.PatientView;

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
		frame.setBounds(100, 100, 675, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(414, 122, 138, 23);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(414, 161, 35, 23);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(414, 205, 44, 23);
		
		ButtonGroup G = new ButtonGroup();
		G.add(radioButton);
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(173, 253, 101, 23);
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
					//PatientView.invoke();
					
				}
				else if(rdbtnNewRadioButton_1.isSelected())
				{
					new DoctorSignIn();
					window.frame.dispose();
				}
					
				
			}
		});
		
		JLabel lblChooseAnyOne = new JLabel("Choose Any one option");
		lblChooseAnyOne.setBounds(146, 44, 183, 28);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(173, 122, 187, 27);
		
		JLabel lblPatient = new JLabel("Patient");
		lblPatient.setBounds(173, 166, 177, 23);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(173, 208, 233, 15);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblChooseAnyOne);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(lblPatient);
		frame.getContentPane().add(lblAdmin);
		frame.getContentPane().add(lblDoctor);
		frame.getContentPane().add(radioButton);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		frame.getContentPane().add(rdbtnNewRadioButton);
	}
}
