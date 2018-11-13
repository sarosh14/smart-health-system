package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ARemoveDoctor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static ARemoveDoctor window = new ARemoveDoctor();
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
	public ARemoveDoctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Remove Doctor");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDoctorId = new JLabel("Doctor Id");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(289)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(lblDoctorId, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
					.addGap(73))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(369)
					.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(lblDoctorId, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
					.addGap(29)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(87))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
