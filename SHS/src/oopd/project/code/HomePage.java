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
		frame.getContentPane().setLayout(null);
		
		JEditorPane dtrpnChooseAnyOf = new JEditorPane();
		dtrpnChooseAnyOf.setText("Choose Any one option");
		dtrpnChooseAnyOf.setEditable(false);
		dtrpnChooseAnyOf.setBounds(63, 43, 183, 21);
		frame.getContentPane().add(dtrpnChooseAnyOf);
		
		JEditorPane dtrpnAdmin = new JEditorPane();
		dtrpnAdmin.setText("Admin");
		dtrpnAdmin.setEditable(false);
		dtrpnAdmin.setBounds(63, 71, 183, 21);
		frame.getContentPane().add(dtrpnAdmin);
		
		JEditorPane dtrpnPatient = new JEditorPane();
		dtrpnPatient.setText("Patient");
		dtrpnPatient.setEditable(false);
		dtrpnPatient.setBounds(63, 100, 183, 21);
		frame.getContentPane().add(dtrpnPatient);
		
		JEditorPane dtrpnDoctor = new JEditorPane();
		dtrpnDoctor.setText("Doctor");
		dtrpnDoctor.setEditable(false);
		dtrpnDoctor.setBounds(63, 128, 183, 21);
		frame.getContentPane().add(dtrpnDoctor);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(254, 69, 144, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(254, 100, 144, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(254, 126, 144, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
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
				}
					
				
			}
		});
		btnNewButton.setBounds(63, 161, 114, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
