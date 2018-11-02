package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AViewDoctor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static AViewDoctor window = new AViewDoctor();
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
	public AViewDoctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("View Doctor");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblEnterDoctorid = new JLabel("Enter DoctorID");
		
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
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(362)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(319))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEnterDoctorid, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addGap(37)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addGap(57))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterDoctorid, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
					.addGap(105))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
