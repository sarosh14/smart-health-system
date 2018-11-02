package oopd.project.code;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Date;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddDoctor {
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField textField_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	static AddDoctor window = new AddDoctor();
	private JLabel lblYyyymmdd;
	private JLabel lblDoctorName;
	private JLabel lblDob;
	private JLabel lblGender;
	private JLabel lblAddress;
	private JLabel lblNewLabel;
	private JLabel lblRank;
	private JLabel lblOpdFees;
	private JLabel lblSurgeon;
	private JLabel label;
	private JButton button;
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
	public AddDoctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Doctor");
		frame.setBounds(150, 150, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //frame.setContentPane(pane);

		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		//int deptid = Integer.parseInt(dept_id);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		//int fee = Integer.parseInt(fe);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
				
	
		String gender[]={"Male","Female"};  
		comboBox = new JComboBox(gender);
		
		String sergeon[]= {"Yes","No"};
		comboBox_1 = new JComboBox(sergeon);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String gend = (String)comboBox.getEditor().getItem();
				String serg = (String)comboBox_1.getEditor().getItem();
				
				String doctname = textField.getText();
				String dob = textField_1.getText();
				
				String deptid = textField_3.getText();
				String rank = textField_4.getText();
				String fe = textField_5.getText();
				int fee = Integer.parseInt(fe);
				
				String address = textField_6.getText();
				
				System.out.println(doctname+" "+dob+" "+gend+" "+address+" "+deptid+" "+rank+" "+serg+" "+fee);
				try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","");
		            
		            String sql = "INSERT INTO Doctor(Name, DOB, Gender, Address, DeptId, Rank, Surgeon, OpdFees) values (?, ?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement statement = conn.prepareStatement(sql);
		            statement.setString(1, doctname);
		            statement.setString(2, dob);
		            statement.setString(3, gend);
		            statement.setString(4, address);
		            statement.setString(5, deptid);
		            statement.setString(6, rank);
		            statement.setString(7, serg);
		            statement.setInt(8, fee);
		            
		            int row = statement.executeUpdate();
		            if (row > 0) {
		                System.out.println("Insert in Database successfully done.");
		            }
		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        } 
			}
		});
		
		lblYyyymmdd = new JLabel("* yyyy/MM/dd");
		
		lblDoctorName = new JLabel("1- Doctor Name");
		
		lblDob = new JLabel("2- D.O.B");
		
		lblGender = new JLabel("3- Gender");
		
		lblAddress = new JLabel("4- Address");
		
		lblNewLabel = new JLabel("5- Department Id");
		
		lblRank = new JLabel("6- Rank");
		
		lblOpdFees = new JLabel("7- OPD Fees");
		
		lblSurgeon = new JLabel("8- Surgeon");
		
		label = new JLabel("");
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminWork adminWork = new  AdminWork();
				window.frame.dispose();
				adminWork.invoke();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSurgeon, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
									.addGap(31)))
							.addGap(41)
							.addComponent(comboBox_1, 0, 57, Short.MAX_VALUE)
							.addGap(213))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblOpdFees, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
									.addGap(41))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRank, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
									.addGap(52))
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAddress, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
									.addGap(26)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
							.addGap(141))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDoctorName, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblDob, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
											.addGap(41)))
									.addGap(37))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblGender, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
									.addGap(35)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBox, 0, 86, Short.MAX_VALUE)
									.addGap(184))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblYyyymmdd, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
									.addGap(16)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(372)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lblDoctorName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(textField))
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDob)
								.addComponent(textField_1))
							.addGap(1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblYyyymmdd, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblGender))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_6)
							.addGap(6)))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_3))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblRank)
							.addGap(7))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_4)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblOpdFees))
						.addComponent(textField_5))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblSurgeon, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
							.addGap(1)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1)
								.addComponent(label))
							.addGap(22))))
		);
		frame.getContentPane().setLayout(groupLayout);
	
	}
}
