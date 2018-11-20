package oopd.project.code.doctor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import oopd.project.logging.LogExceptionsToFile;

import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.SwingConstants;

public class DoctorEditProfile {

	private JFrame frame;
	private JTextField nameTextField;
	private JTextField dobTextField;
	private JTextField addressTextField;
	private JTextField contactTextField;
	Connection con;

    ResultSet rs;

    Statement st;
    PreparedStatement pstmt = null;
    
	LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblnumber;
	private int docId;
	
	String name,address,contact,password;
	Date dob;
	private JLabel lblNewLabel_passwrd;
	private JTextField passwordTextField;
	
	/**
	 * Create the application.
	 */
	public DoctorEditProfile(int docId) {
		this.docId=docId;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//System.out.println(docId);
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 502);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDoctorSchedule = new JLabel("Name");
		lblDoctorSchedule.setBounds(172, 119, 114, 19);
		
		JLabel lblDoctorName = new JLabel("D.O.B");
		lblDoctorName.setBounds(172, 144, 114, 15);
		
		JLabel lblDoctorAddress_1 = new JLabel("Address");
		lblDoctorAddress_1.setBounds(172, 175, 114, 15);
		
		JLabel lblDoctorContactNumber = new JLabel("Contact Number");
		lblDoctorContactNumber.setBounds(172, 204, 114, 15);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(337, 119, 152, 19);
		nameTextField.setColumns(10);
		
		dobTextField = new JTextField();
		dobTextField.setBounds(337, 144, 152, 19);
		dobTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(337, 173, 152, 19);
		addressTextField.setColumns(10);
		
		contactTextField = new JTextField();
		contactTextField.setBounds(337, 204, 152, 19);
		contactTextField.setColumns(10);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblDoctorSchedule);
		frame.getContentPane().add(lblDoctorName);
		frame.getContentPane().add(lblDoctorAddress_1);
		frame.getContentPane().add(lblDoctorContactNumber);
		frame.getContentPane().add(contactTextField);
		frame.getContentPane().add(addressTextField);
		frame.getContentPane().add(dobTextField);
		frame.getContentPane().add(nameTextField);
		
		lblNewLabel = new JLabel("Edit Profile");
		lblNewLabel.setBounds(201, 12, 212, 61);
		lblNewLabel.setForeground(Color.red);

		lblNewLabel.setFont(new Font("Serif", Font.BOLD,30));
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("*yyyy-MM-dd");
		lblNewLabel_1.setBounds(519, 144, 112, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblnumber = new JLabel("*number");
		lblnumber.setBounds(519, 204, 112, 15);
		frame.getContentPane().add(lblnumber);
		
		 passwordTextField = new JTextField();
         passwordTextField.setColumns(10);
         passwordTextField.setBounds(337, 235, 152, 19);
         
         lblNewLabel_passwrd = new JLabel("Password");
         lblNewLabel_passwrd.setBounds(172, 238, 114, 15);
         frame.getContentPane().add(lblNewLabel_passwrd);
         
        
         frame.getContentPane().add(passwordTextField);
		
		JButton editButton = new JButton("Edit Profile");
		editButton.setBounds(172, 306, 114, 25);
		frame.getContentPane().add(editButton);
		
		JButton backbutton = new JButton("BackToDoctorHome");
		backbutton.setBounds(337, 306, 198, 25);
		frame.getContentPane().add(backbutton);
		
		//database conn
		try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "");
            st = con.createStatement();
           
            rs = st.executeQuery("select Name,DOB,Address,ContactNo,Password from Doctor WHERE Did="+docId);
        
            rs.next();
            name=rs.getString("Name");
         
            address=rs.getString("Address");
            contact=rs.getString("ContactNo");
           dob=rs.getDate("DOB");
           password=rs.getString("Password");
            
        
            nameTextField.setText(name);
            contactTextField.setText(contact);
            addressTextField.setText(address);
            dobTextField.setText(""+dob);
            passwordTextField.setText(password);
           
           
		}catch (Exception e) {
			System.out.println(e);
			logs.LOGGER.severe("Database exception "+e);
        }finally {
        	
        	 try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }	
		//to edit doctor data
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(name.equals(nameTextField.getText()) && contact.equals(contactTextField.getText()) && address.equals(addressTextField.getText()) && dob.toString().equals(dobTextField.getText()) && password.equals(passwordTextField.getText()))
						{
					JOptionPane.showMessageDialog(frame,"You have not edited anything !!Edit Again OR Press backButton to go back");
						}
				else
				{	
					 String SQL = "Update Doctor SET Name =?, ContactNo=?, Address=?, DOB=?,Password=? WHERE Did = ?";
					name=nameTextField.getText();
					contact=contactTextField.getText();
				
					address=addressTextField.getText();
					String date=dobTextField.getText().toString();
					password=passwordTextField.getText();
					try {
						pstmt=con.prepareStatement(SQL);
						pstmt.setString(1,name);
						pstmt.setString(2,contact);
						pstmt.setString(3,address);
						pstmt.setString(4,date);
						pstmt.setString(5,password);
						pstmt.setInt(6, docId);
						int status=pstmt.executeUpdate();
						
						if(status==1)
						{
							JOptionPane.showMessageDialog(frame,"Update Successfully!!");
							frame.dispose();
							new DoctorView(docId);
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						logs.LOGGER.severe(""+e);
						e.printStackTrace();
					}
					finally {
						try {
						pstmt.close();
						con.close();
						}catch(Exception e)
						{
							logs.LOGGER.info("connection close :"+e);
						}
					}
					//st.executeUpdate("Update Doctor ")
					
				}
			}
		});
		
		//back button to doctor view page
		backbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new DoctorView(docId);
				frame.dispose();
				
			}
		});
		
		
	}
}
