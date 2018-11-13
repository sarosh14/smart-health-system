package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class DoctorWork {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static DoctorWork window = new DoctorWork();
	public void main() {
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
	public DoctorWork() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtnSeePatientRecord = new JRadioButton("See Patient History");
		
		JRadioButton rdbtnSeePatientDescription = new JRadioButton("See Patient Description");
		
		JRadioButton rdbtnChangeDoctor = new JRadioButton("Change Doctor");
		
		JRadioButton rdbtnAdviceTest = new JRadioButton("Advice Test");
		
		JRadioButton rdbtnLocationUpdate = new JRadioButton("Location Update");
		
		JButton btnSelect = new JButton("Select");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnSeePatientRecord)
								.addComponent(rdbtnLocationUpdate)
								.addComponent(rdbtnAdviceTest)
								.addComponent(rdbtnChangeDoctor)
								.addComponent(rdbtnSeePatientDescription)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(btnSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(101)))
					.addGap(234))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(rdbtnSeePatientDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnChangeDoctor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnAdviceTest)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnLocationUpdate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnSeePatientRecord)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(85))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
