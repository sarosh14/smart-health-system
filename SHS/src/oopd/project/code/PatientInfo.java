package oopd.project.code;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import com.mysql.jdbc.Statement;

import oopd.project.database.DatabaseConnection;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;

public class PatientInfo
{

	private JFrame frame;
	private Connection con;	
	private Statement st, st1;
	private PreparedStatement pst;
	private String ids;
	private String[] columnNames = {"Pid", "Name", "DOB", "Gender", "Address", "ContactNo", "Password"};
	private String from;
	
	/**
	 * Launch the application.
	 */
	
	
	public void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientInfo window = new PatientInfo();
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
	public PatientInfo() {
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPatientName = new JLabel("Patient Id");
		
		JLabel lblPatientName_1 = new JLabel("Patient Name");
		
		JLabel lblDob = new JLabel("D.O.B");
		
		JLabel lblGender = new JLabel("Gender");
		
		JLabel lblNewLabel = new JLabel("Address");
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		
		JLabel l_PId = new JLabel("1");
		
		JLabel l_Pname = new JLabel("2");
		
		JLabel l_Pdob = new JLabel("3");
		
		JLabel l_Pgender = new JLabel("4");
		
		JLabel l_Paddress = new JLabel("5");
		
		JLabel l_Pcontact = new JLabel("6");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPatientName, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPatientName_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(lblDob, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
							.addGap(42))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(lblContactNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(lblGender, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
							.addGap(42)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(l_PId, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
							.addGap(88))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(l_Pname, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(l_Pdob, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(l_Pgender, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(l_Pcontact, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(l_Paddress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblPatientName, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPatientName_1, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
								.addComponent(l_Pname, GroupLayout.PREFERRED_SIZE, 9, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(l_PId, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(18)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDob)
							.addGap(16)
							.addComponent(lblGender)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblContactNumber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(l_Pdob)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(l_Pgender, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(l_Paddress)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(l_Pcontact, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
					.addGap(98))
		);
		frame.getContentPane().setLayout(groupLayout);
		DatabaseConnection connection = new DatabaseConnection();
	}
}
