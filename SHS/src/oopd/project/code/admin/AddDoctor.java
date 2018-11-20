package oopd.project.code.admin;

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
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;

public class AddDoctor {
	
	private JFrame frame;
	private JTextField dnametxt;
	private JTextField dcontacttxt;
	private JTextField dpasswordtxt;
	private JTextField daddresstxt;
	private JComboBox dgender_combobox;
	private JComboBox surgen_combobox;
	private JTextField ddobtxt;

	/**
	 * Launch the application.
	 */
	static AddDoctor window = new AddDoctor();
	private JLabel lblYyyymmdd;
	private JLabel lblDoctorName;
	private JLabel lblDob;
	private JLabel lblGender;
	private JLabel lblAddress;
	private JLabel lblPassword;
	private JLabel lblDeptId;
	private JLabel lbldeptid;
	private JLabel lblSurgeon;
	private JLabel label;
	private JButton button;
	private JTextField ddeptidtxt;
	private JLabel lblOopdFee;
	private JTextField doopdfeetxt;
	private JLabel lblRank;
	private JComboBox dranktxt;
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
		frame.setBackground(SystemColor.desktop);
		frame.setBounds(150, 150, 693, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //frame.setContentPane(pane);

		
		
		dnametxt = new JTextField();
		dnametxt.setBounds(341, 33, 180, 19);
		dnametxt.setColumns(10);
		
		ddobtxt = new JTextField();
		ddobtxt.setBounds(341, 78, 180, 20);
		ddobtxt.setColumns(10);
		
		dcontacttxt = new JTextField();
		dcontacttxt.setBounds(341, 192, 180, 19);
		dcontacttxt.setColumns(10);
		
		//int deptid = Integer.parseInt(dept_id);
		dpasswordtxt = new JTextField();
		dpasswordtxt.setBounds(341, 229, 180, 19);
		dpasswordtxt.setColumns(10);
		//int fee = Integer.parseInt(fe);

		daddresstxt = new JTextField();
		daddresstxt.setBounds(341, 154, 180, 19);
		daddresstxt.setColumns(10);
				
	
		String gender[]={"None","M","F"};  
		dgender_combobox = new JComboBox(gender);
		dgender_combobox.setBounds(341, 117, 94, 25);
		
		String sergeon[]= {"None","Yes","No"};
		surgen_combobox = new JComboBox(sergeon);
		surgen_combobox.setBounds(341, 328, 114, 24);
		
		lblYyyymmdd = new JLabel("* yyyy/MM/dd");
		lblYyyymmdd.setBounds(561, 76, 120, 23);
		
		lblDoctorName = new JLabel("1- Doctor Name");
		lblDoctorName.setBounds(32, 29, 297, 27);
		
		lblDob = new JLabel("2- D.O.B");
		lblDob.setBounds(32, 68, 297, 31);
		
		lblGender = new JLabel("3- Gender");
		lblGender.setBounds(32, 117, 196, 25);
		
		lblAddress = new JLabel("4- Address");
		lblAddress.setBounds(32, 154, 174, 19);
		
		lblPassword = new JLabel("6- Password");
		lblPassword.setBounds(32, 231, 131, 15);
		
		lblDeptId = new JLabel("7- Dept Id");
		
		lbldeptid = new JLabel("7- Dept Id");
		lbldeptid.setBounds(32, 266, 115, 19);
		
		lblSurgeon = new JLabel("9- Surgeon");
		lblSurgeon.setBounds(32, 333, 240, 15);
		
		label = new JLabel("");
		label.setBounds(693, 414, 0, 0);
		
		button = new JButton("Back");
		button.setBounds(587, 0, 94, 25);
		
		
		JLabel lblcontactnumber = new JLabel("5- Contact Number");
		lblcontactnumber.setBounds(32, 191, 174, 20);
		
		ddeptidtxt = new JTextField();
		ddeptidtxt.setBounds(341, 266, 180, 19);
		ddeptidtxt.setColumns(10);
		
		lblOopdFee = new JLabel("10- Oopd Fee");
		lblOopdFee.setBounds(32, 364, 103, 19);
		
		doopdfeetxt = new JTextField();
		doopdfeetxt.setBounds(341, 364, 180, 19);
		doopdfeetxt.setColumns(10);
		
		String[] s1= {"None","Junior_Resident","Specialist","Senior_Resident","Senior_Resident","Senior_Specialist"};
		dranktxt = new JComboBox(s1);
		dranktxt.setBounds(341, 297, 151, 24);
		frame.getContentPane().add(dranktxt);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(32, 389, 73, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gend = (String)dgender_combobox.getSelectedItem();
				String serg = (String)surgen_combobox.getSelectedItem();
				
				String doctname = dnametxt.getText();
				String dob = ddobtxt.getText();
				String password = dpasswordtxt.getText();
				String contactno = dcontacttxt.getText();
				//int contactno=Integer.parseInt(contact);
				String rank = (String)dranktxt.getSelectedItem();
				String deptid1 = ddeptidtxt.getText();
				int deptid=0;
				if(deptid1.length()!=0)
				{
					deptid = Integer.parseInt(deptid1);
				}
				//String rank = dranktxt.getText();
				String fe = doopdfeetxt.getText();
				int fee=0;
				if(fe.length()!=0)
				{
					fee = Integer.parseInt(fe);
				}
				String address = daddresstxt.getText();
				
				
				if(doctname.length()==0 || dob.length()==0 || gend.length()==0 || address.length()==0
						|| contactno.length()==0 || password.length()==0 ||
						deptid1.length()==0 || rank.length()==0 || serg.length()==0 || fe.length()==0)
				{
					JOptionPane.showMessageDialog(frame, "All Field should be Filled");
					System.out.println("All Field Should be Filled");
				
					System.out.println("IF");
				}
				else
				{
					System.out.println("Else");
				//System.out.println(doctname+" "+dob+" "+gend+" "+address+" "+deptid+" "+rank+" "+serg+" "+fee);
				try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
		            
		            String sql = "INSERT INTO Doctor(Name, DOB, Gender, Address, ContactNo, Password, DeptId, Rank, Surgeon, OpdFees) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement statement = conn.prepareStatement(sql);
		            statement.setString(1, doctname);
		            statement.setString(2, dob);
		            statement.setString(3, gend);
		            statement.setString(4, address);
		            statement.setString(5, contactno);
		            statement.setString(6, password);
		            statement.setInt(7, deptid);
		            statement.setString(8, rank);
		            statement.setString(9, serg);
		            statement.setInt(10, fee);
		            
		            int row = statement.executeUpdate();
		            if (row > 0) {
		                System.out.println("Insert in Database successfully done.");
		                JOptionPane.showMessageDialog(frame, "Successfully Added !");
		                AdminWork adminWork = new AdminWork();
						window.frame.dispose();
						adminWork.invoke();
		            }
		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
				dnametxt.setText("");
				ddobtxt.setText("");
				daddresstxt.setText("");
				dcontacttxt.setText("");
				dpasswordtxt.setText("");
				ddeptidtxt.setText("");
				doopdfeetxt.setText("");
				} 
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				window.frame.dispose();
				AdminWork adminWork = new  AdminWork();
				adminWork.invoke();
				dnametxt.setText("");
				ddobtxt.setText("");
				daddresstxt.setText("");
				dcontacttxt.setText("");
				dpasswordtxt.setText("");
				ddeptidtxt.setText("");
				doopdfeetxt.setText("");
			}
		});
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button);
		frame.getContentPane().add(lbldeptid);
		frame.getContentPane().add(lblPassword);
		frame.getContentPane().add(label);
		frame.getContentPane().add(lblGender);
		frame.getContentPane().add(lblcontactnumber);
		frame.getContentPane().add(lblAddress);
		frame.getContentPane().add(lblDob);
		frame.getContentPane().add(lblDoctorName);
		frame.getContentPane().add(dgender_combobox);
		frame.getContentPane().add(surgen_combobox);
		frame.getContentPane().add(doopdfeetxt);
		frame.getContentPane().add(dpasswordtxt);
		frame.getContentPane().add(dcontacttxt);
		frame.getContentPane().add(ddobtxt);
		frame.getContentPane().add(dnametxt);
		frame.getContentPane().add(daddresstxt);
		frame.getContentPane().add(ddeptidtxt);
		frame.getContentPane().add(lblYyyymmdd);
		frame.getContentPane().add(lblOopdFee);
		frame.getContentPane().add(lblSurgeon);
		frame.getContentPane().add(btnAdd);
		
		lblRank = new JLabel("8- Rank");
		lblRank.setBounds(32, 299, 103, 17);
		frame.getContentPane().add(lblRank);
		
		
	}
}
