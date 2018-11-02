package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AViewPatient {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	static AViewPatient window = new AViewPatient();
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
	public AViewPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("View Patient");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblEnterPatientId = new JLabel("Enter Patient ID");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdminWork adminWork = new AdminWork();
				window.frame.dispose();
				adminWork.invoke();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(307))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEnterPatientId, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addGap(55)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
							.addGap(50))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(374)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPatientId, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
					.addGap(33)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
					.addGap(81))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
