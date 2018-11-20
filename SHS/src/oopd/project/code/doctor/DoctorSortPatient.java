package oopd.project.code.doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class DoctorSortPatient extends JFrame {

	private JFrame frame;
	private int docId;
	

	/**
	 * Create the frame.
	 */
	public DoctorSortPatient(int docId) {
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
		frame = new JFrame("Doctor");
		frame.setBounds(100, 100, 712, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		ButtonGroup buttonGroup=new ButtonGroup();
		JLabel titleLabel = new JLabel("Sort Patient - ");
		titleLabel.setBounds(237, 32, 269, 61);
		titleLabel.setForeground(Color.red);

		titleLabel.setFont(new Font("Serif", Font.BOLD,30));
		frame.getContentPane().add(titleLabel);
		
		JRadioButton byPidRadioButton = new JRadioButton("By Patient Id");
		byPidRadioButton.setBounds(240, 134, 144, 23);
		frame.getContentPane().add(byPidRadioButton);
		
		JRadioButton byNameRadioButton = new JRadioButton("By Patient Name");
		byNameRadioButton.setBounds(240, 181, 144, 23);
		frame.getContentPane().add(byNameRadioButton);
		buttonGroup.add(byNameRadioButton);
		buttonGroup.add(byPidRadioButton);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(216, 250, 114, 25);
		frame.getContentPane().add(submitButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(374, 250, 114, 25);
		frame.getContentPane().add(backButton);
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(byPidRadioButton.isSelected())
				{
				new DocViewPatients(docId,1);
				frame.dispose();
				}
				else if(byNameRadioButton.isSelected())
				{
					new DocViewPatients(docId,2);
					frame.dispose();
				}
				else
				{
					System.out.println("You have not selected Parameter!");
					JOptionPane.showMessageDialog(frame, "You have not selected Parameter!");
				}
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new DoctorView(docId);
				frame.dispose();
				
			}
		});
	}
}
