package oopd.project.code.doctor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DoctorView {
	
	private int docId;
	private JFrame frame;
	
	
	/**
	 * Create the application.
	 *
	 */
	public DoctorView(int docId) {
		// TODO Auto-generated constructor stub
		this.docId=docId;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println(docId);

		frame = new JFrame();
		frame.setBounds(100, 100, 685, 502);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Doctor HomePage");
	
	
		
		JRadioButton viewAppointments = new JRadioButton("View Appointments");
		viewAppointments.setBounds(179, 105, 158, 23);
		JRadioButton viewProfile = new JRadioButton("View Profile");
		viewProfile.setBounds(179, 134, 105, 23);
		JRadioButton editProfile = new JRadioButton("Edit Profile");
		editProfile.setBounds(179, 161, 100, 23);
		JRadioButton logout = new JRadioButton("Logout");
		logout.setBounds(179, 215, 73, 23);
		
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(viewAppointments);
		buttonGroup.add(viewProfile);
		buttonGroup.add(editProfile);
		buttonGroup.add(logout);
	
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		JButton btnSelect = new JButton("Select");
		btnSelect.setBounds(179, 266, 149, 61);
		frame.getContentPane().add(btnSelect);
		frame.getContentPane().add(viewAppointments);
		frame.getContentPane().add(viewProfile);
		frame.getContentPane().add(editProfile);
		frame.getContentPane().add(logout);
		
		JLabel label = new JLabel("Welcome Doctor");
		label.setForeground(Color.red);

        label.setFont(new Font("Serif", Font.BOLD,30));
		label.setBounds(201, 12, 295, 61);
		frame.getContentPane().add(label);
		
		JRadioButton scheduleRadio = new JRadioButton("Add Schedule");
		scheduleRadio.setBounds(179, 188, 144, 23);
		buttonGroup.add(scheduleRadio);
		frame.getContentPane().add(scheduleRadio);
		
		btnSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(viewAppointments.isSelected())
				{
					new DoctorSortPatient(docId);
					frame.dispose();
				}
				else if(viewProfile.isSelected())
				{
					
					//without frame dispose will work best
					new DoctorViewProfile(docId);
					
					
					
				}
				else if(editProfile.isSelected())
				{
					new DoctorEditProfile(docId);
					frame.dispose();
				}
				else if(scheduleRadio.isSelected())
				{
					new DoctorSchedule(docId);
					frame.dispose();
				}
				else if(logout.isSelected())
				{
					new DoctorSignIn();
					frame.dispose();
				}
				
			}
		});
		
	}
}
