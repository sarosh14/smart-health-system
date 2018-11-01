package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;



	public class DoctorSchedule {

		private JFrame frame;

		/**
		 * Launch the application.
		 */
		static DoctorSchedule window = new DoctorSchedule();
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
		public DoctorSchedule() {
			// TO
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame("Doctor");
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel lblDoctorId = new JLabel("Doctor Id");
			
			JLabel lblDoctorSchedule = new JLabel("Doctor Schedule");
			
			JList list = new JList();
			
			JButton button = new JButton("New button");
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(35)
								.addComponent(lblDoctorId, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
								.addGap(151)
								.addComponent(lblDoctorSchedule, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(26)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(button)
									.addComponent(list, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))))
						.addGap(80))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDoctorId, GroupLayout.PREFERRED_SIZE, 9, Short.MAX_VALUE)
							.addComponent(lblDoctorSchedule, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(button)
						.addGap(30))
			);
			frame.getContentPane().setLayout(groupLayout);
		}
	}

