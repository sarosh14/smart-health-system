package oopd.project.code;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class DoctorView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorView window = new DoctorView();
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
	public DoctorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
