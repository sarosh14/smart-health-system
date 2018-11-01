package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ListPatientAppointment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static ListPatientAppointment window = new ListPatientAppointment();
	private JTextField textField;
	public void invoke() {
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
	public ListPatientAppointment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		
		JLabel lblDateOfAppointment = new JLabel("Date Of Appointment");
		
		JList list = new JList();
		
		JButton btnSortbyid = new JButton("Sort_By_Id");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSelectPid = new JButton("Select P_ID");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSelectPid)
							.addGap(99)
							.addComponent(btnSortbyid, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(65))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPatientId, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
							.addGap(83)
							.addComponent(lblDateOfAppointment, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addGap(94))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfAppointment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPatientId, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelectPid)
						.addComponent(btnSortbyid, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE))
					.addGap(27))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
