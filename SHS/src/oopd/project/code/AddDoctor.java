package oopd.project.code;

import java.awt.EventQueue;

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

public class AddDoctor {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JEditorPane dtrpnAddress;
	private JTextField textField_6;
	private JEditorPane dtrpnS;
	private JComboBox comboBox;
	
	private JComboBox comboBox_1;
	private JTextField textField_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDoctor window = new AddDoctor();
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
	
//	public class Gender {
//	    private String Male;
//	    private String Female;
//
//	    // Getters and setters
//
//	    public String toString() {
//	        return Male + " " + Female;
//	    }
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Doctor");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);   
		
		
		
		JEditorPane dtrpnName = new JEditorPane();
		dtrpnName.setText("Doctor Name");
		dtrpnName.setBounds(32, 37, 107, 21);
		frame.getContentPane().add(dtrpnName);
		
		JEditorPane dtrpnDepartmentId = new JEditorPane();
		dtrpnDepartmentId.setText("Department Id");
		dtrpnDepartmentId.setBounds(32, 144, 107, 21);
		frame.getContentPane().add(dtrpnDepartmentId);
		
		JEditorPane dtrpnRank = new JEditorPane();
		dtrpnRank.setText("Rank");
		dtrpnRank.setBounds(32, 169, 107, 21);
		frame.getContentPane().add(dtrpnRank);
		
		JEditorPane dtrpnOpdFee = new JEditorPane();
		dtrpnOpdFee.setText("OPD Fees");
		dtrpnOpdFee.setBounds(32, 193, 107, 21);
		frame.getContentPane().add(dtrpnOpdFee);
		
		JEditorPane dtrpnDob = new JEditorPane();
		dtrpnDob.setText("D.O.B");
		dtrpnDob.setBounds(32, 53, 107, 21);
		frame.getContentPane().add(dtrpnDob);
		
		JEditorPane dtrpnGender = new JEditorPane();
		dtrpnGender.setText("Gender");
		dtrpnGender.setBounds(32, 86, 107, 21);
		frame.getContentPane().add(dtrpnGender);
		
		dtrpnAddress = new JEditorPane();
		dtrpnAddress.setText("Address");
		dtrpnAddress.setEditable(false);
		dtrpnAddress.setBounds(32, 111, 107, 21);
		frame.getContentPane().add(dtrpnAddress);
		
		textField = new JTextField();
		textField.setBounds(165, 37, 124, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 55, 124, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(165, 146, 124, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		//int deptid = Integer.parseInt(dept_id);
		textField_4 = new JTextField();
		textField_4.setBounds(165, 171, 124, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(165, 195, 124, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		//int fee = Integer.parseInt(fe);

		textField_6 = new JTextField();
		textField_6.setBounds(165, 115, 124, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
				
		dtrpnS = new JEditorPane();
		dtrpnS.setText("Surgeon");
		dtrpnS.setBounds(32, 218, 107, 21);
		frame.getContentPane().add(dtrpnS);
		
		String gender[]={"Male","Female"};  
		comboBox = new JComboBox(gender);
		comboBox.setBounds(165, 83, 124, 24);
		frame.getContentPane().add(comboBox);
		
		String sergeon[]= {"Yes","No"};
		comboBox_1 = new JComboBox(sergeon);
		comboBox_1.setBounds(165, 218, 124, 24);
		frame.getContentPane().add(comboBox_1);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String gend = (String)comboBox.getEditor().getItem();
				String serg = (String)comboBox_1.getEditor().getItem();
				
				String doctname = textField.getText();
				String dob = textField_1.getText();
				String deptid = textField_3.getText();
				String rank = textField_4.getText();
				String fee = textField_5.getText();
				String address = textField_6.getText();
				
				System.out.println(doctname+" "+dob+" "+gend+" "+address+" "+deptid+" "+rank+" "+serg+" "+fee);
				try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","");
		            
		            String sql = "INSERT INTO Doctor(Name, DOB, Gender, Address, DeptId, Rank, Surgeon, OpdFees) values (?, ?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement statement = conn.prepareStatement(sql);
		            statement.setString(1, doctname);
		            statement.setString(2, dob);
		            statement.setString(3, gend);
		            statement.setString(4, address);
		            statement.setString(5, deptid);
		            statement.setString(6, rank);
		            statement.setString(7, serg);
		            statement.setString(8, fee);
		            
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
		btnNewButton.setBounds(32, 239, 81, 25);
		frame.getContentPane().add(btnNewButton);
		
	          
//	    
//	    JComboBox cb=new JComboBox(country);    
//	    cb.setBounds(50, 50,90,20);    
//	    frame.add(cb);        
//	    frame.setLayout(null);    
//	    frame.setSize(400,500);    
//	    frame.setVisible(true);
	
	}
}
