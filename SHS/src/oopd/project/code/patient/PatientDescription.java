package oopd.project.code.patient;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import oopd.project.code.admin.AdminWork;
import oopd.project.logging.LogExceptionsToFile;

import javax.swing.JComboBox;

public class PatientDescription {
	
	private JFrame frame;
	private int pid;
	private Connection con;
    private ResultSet rs;
    private Statement st;
    private String ids,idss;
    int ids1,ids11;
    private int from,from1;
	/**
	 * Launch the application.
	 */
    LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
    JComboBox dept_combobox = new JComboBox();
	public PatientDescription(int pid) {
		this.pid=pid;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//  				PatientDescription window = new PatientDescription();
					//window.frame.setVisible(true);
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Patient");
		frame.setBounds(100, 100, 720, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	//	ButtonGroup G = new ButtonGroup();
		
		JTextArea health_des = new JTextArea();
		health_des.setBounds(104, 122, 516, 75);
		
		
		try {

            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select DeptId,DeptName from Department");

            Vector v = new Vector();
          //  System.out.println(rs);
            v.add("None");
            while (rs.next()) {

                ids = rs.getString("DeptName");
                ids1 = rs.getInt("DeptId");
                v.add("DeptId = "+ids1+" ,"+"DeptName = "+ids);
            //    System.out.println("ids are : "+ids);

           }
           dept_combobox = new JComboBox(v);
           
           st.close();
           rs.close();
            
		 }
         catch(Exception e)
         {
            System.out.println("Database Error!");
            logs.LOGGER.info("Database Error in PatientDescription class");
         }
		
		JLabel lblNewLabel = new JLabel("                       Welcome Patient");
		lblNewLabel.setBounds(216, 12, 326, 46);
		//JLabel lblNewLabel1 = new JLabel("Enter your Health Description");
		
		
		
		JLabel lblEnterYourHealth = new JLabel("Enter Your Health Description");
		lblEnterYourHealth.setBounds(109, 70, 204, 39);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(health_des);
		frame.getContentPane().add(lblEnterYourHealth);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSelectDepartment = new JLabel("Select Department");
		lblSelectDepartment.setBounds(104, 216, 209, 43);
		frame.getContentPane().add(lblSelectDepartment);
		
		dept_combobox.setBounds(319, 227, 335, 32);
		frame.getContentPane().add(dept_combobox);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				String str = (String)dept_combobox.getSelectedItem().toString();
				System.out.println("string :"+str);
				if(str.equalsIgnoreCase("None"))
				{
					JOptionPane.showMessageDialog(frame, "Department Must be selected !");
				}
				else
				{
					//System.out.println(str);
					str = str.replaceAll("[^-?0-9]+","");
					
					//System.out.println("Selected0 = "+Arrays.asList(str.trim().split(" ")));
					//System.out.println("Selected1 = "+str);
					int gend = Integer.parseInt(str);
					from = gend;
			        
					System.out.println("******deptId******* = "+from);
			        
			        try {
			        	
			            Class.forName("com.mysql.jdbc.Driver");
			           
			            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
			           
			            st = (Statement) con.createStatement();
			           
			            System.out.println("From DeptId= "+from);
			            rs = st.executeQuery("select Did,Name from Doctor where DeptId="+from);
			     
			            Vector v1 = new Vector();
			            
			            v1.add("None");
			            while (rs.next()) {

			                ids11 = rs.getInt("Did");
			                idss = rs.getString("Name");
			                v1.add("Name = "+idss+" ,"+"Did = "+ids11);
			                //System.out.println("idss are : "+idss +"ids11 are "+ids11);

			           }
			          // System.out.println("Value V = "+v1);
			          // doctor_combobox = new JComboBox(v1);
			          
			           st.close();
			           rs.close();
			           
					   String desc = health_des.getText();
					   if(desc.length()==0)
					   {
						JOptionPane.showMessageDialog(frame, "All field must be filled");   
					   }
					   else
					   {
			           PatientDescription2 patientDescription2 = new PatientDescription2(v1,desc,pid);
					   frame.dispose();
					   }
			           
			            
					 }
			         catch(Exception e)
			         {
			            System.out.println("Database Error!");
			            logs.LOGGER.info("Database Error in PatientDescription class");
			         }
				}	
			}	        
		});
		
		btnSelect.setBounds(104, 278, 92, 25);
		frame.getContentPane().add(btnSelect);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new BookAppointment(pid);
				frame.dispose();
			}
		});
		btnBack.setBounds(628, 0, 92, 25);
		frame.getContentPane().add(btnBack);
		
		
		
		
		
		
	}
}
