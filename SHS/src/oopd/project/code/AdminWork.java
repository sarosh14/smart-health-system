package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JEditorPane dtrpnWelcomeAdmin = new JEditorPane();
		dtrpnWelcomeAdmin.setText("                       Welcome Admin");
		dtrpnWelcomeAdmin.setEditable(false);
		dtrpnWelcomeAdmin.setBounds(64, 12, 280, 21);
		frame.getContentPane().add(dtrpnWelcomeAdmin);
		
		JEditorPane dtrpnYouCanPerform = new JEditorPane();
		dtrpnYouCanPerform.setText("You can perform following task");
		dtrpnYouCanPerform.setEditable(false);
		dtrpnYouCanPerform.setBounds(64, 39, 280, 21);
		frame.getContentPane().add(dtrpnYouCanPerform);
		
		JEditorPane dtrpnAddDoctor = new JEditorPane();
		dtrpnAddDoctor.setText("1- Add Doctor");
		dtrpnAddDoctor.setEditable(false);
		dtrpnAddDoctor.setBounds(64, 79, 189, 21);
		frame.getContentPane().add(dtrpnAddDoctor);
		
		JEditorPane dtrpnRemoveDoctor = new JEditorPane();
		dtrpnRemoveDoctor.setText("2- Remove Doctor");
		dtrpnRemoveDoctor.setEditable(false);
		dtrpnRemoveDoctor.setBounds(64, 102, 189, 21);
		frame.getContentPane().add(dtrpnRemoveDoctor);
		
		JEditorPane dtrpnViewPaietent = new JEditorPane();
		dtrpnViewPaietent.setText("3- View Patient Info");
		dtrpnViewPaietent.setBounds(64, 123, 190, 21);
		dtrpnViewPaietent.setEditable(false);
		frame.getContentPane().add(dtrpnViewPaietent);
		
		JEditorPane dtrpnViewDoctor = new JEditorPane();
		dtrpnViewDoctor.setText("4- View Doctor Info");
		dtrpnViewDoctor.setBounds(64, 145, 189, 21);
		dtrpnViewDoctor.setEditable(false);
		frame.getContentPane().add(dtrpnViewDoctor);
		
		JEditorPane dtrpnReassignDoctor = new JEditorPane();
		dtrpnReassignDoctor.setText("5- Reassign Doctor");
		dtrpnReassignDoctor.setBounds(64, 168, 189, 21);
		dtrpnReassignDoctor.setEditable(false);
		frame.getContentPane().add(dtrpnReassignDoctor);
		
		JRadioButton rdbtn1 = new JRadioButton("");
		rdbtn1.setBounds(259, 77, 144, 23);
		frame.getContentPane().add(rdbtn1);
		
		JRadioButton rdbtn2 = new JRadioButton("");
		rdbtn2.setBounds(259, 102, 144, 23);
		frame.getContentPane().add(rdbtn2);
		
		JRadioButton rdbtn3 = new JRadioButton("");
		rdbtn3.setBounds(259, 121, 144, 23);
		frame.getContentPane().add(rdbtn3);
		
		JRadioButton rdbtn4 = new JRadioButton("");
		rdbtn4.setBounds(259, 143, 144, 23);
		frame.getContentPane().add(rdbtn4);
		
		JRadioButton rdbtn5 = new JRadioButton("");
		rdbtn5.setBounds(259, 166, 144, 23);
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
	}

}
