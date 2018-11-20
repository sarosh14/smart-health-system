package oopd.project.code.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
//import com.sun.tools.javac.code.Attribute.Array;

import oopd.project.logging.LogExceptionsToFile;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ARemoveDoctor {

	private JFrame frame;
	private Connection con;
    private ResultSet rs;
    private Statement st;
    private String ids;
    int ids1;
    LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
    JComboBox doctor_id_combobox = null;

	/**
	 * Launch the application.
	 */
	static ARemoveDoctor window = new ARemoveDoctor();
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
		frame.setBounds(100, 100, 570, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDoctorId = new JLabel("Doctor Id");
		JButton btnDelete = new JButton("Delete");
		
		try {

            Class.forName("com.mysql.jdbc.Driver");

            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");

            st = (Statement) con.createStatement();

            rs = st.executeQuery("select Name, Did from Doctor");

            Vector v = new Vector();
          //  System.out.println(rs);
            v.add("None");
            while (rs.next()) {

                ids = rs.getString("Name");
                ids1 = rs.getInt("Did");
                v.add("Name = "+ids+" ,"+"Did = "+ids1);
            //    System.out.println("ids are : "+ids);

           }
           doctor_id_combobox = new JComboBox(v);
           
           st.close();
           rs.close();
            
		 }
         catch(Exception e)
         {
            System.out.println("Database Error!");
            logs.LOGGER.info("Database Error in ARemoveDoctor class");
         }
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = (String)doctor_id_combobox.getSelectedItem();
				if(str=="None")
				{
					System.out.println("Please select a doctor to delete");
					JOptionPane.showMessageDialog(frame, "Please select a doctor to delete");
				}
				else
				{
				//System.out.println(str);
				str = str.replaceAll("[^-?0-9]+","");
				
				//System.out.println("Selected0 = "+Arrays.asList(str.trim().split(" ")));
				//System.out.println("Selected1 = "+str);
				int gend = Integer.parseInt(str);
				//System.out.println("Selected2 = "+gend);
				
				try {

		            Class.forName("com.mysql.jdbc.Driver");

		            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");

		            st = (Statement) con.createStatement();

		          //  rs = st.executeQuery("DELETE FROM `Doctor` WHERE `Doctor`.`Did` = "+gend);
		         
		            st.executeUpdate("DELETE FROM `Doctor` WHERE `Doctor`.`Did` ="+gend);
		            
		            JOptionPane.showMessageDialog(frame, "Successfully Deleted !");
		            AdminWork adminWork = new AdminWork();
		            window.frame.dispose();
		            adminWork.invoke();

		          //  System.out.println(rs);
			}
				catch(Exception e)
				{
					System.out.println("Database error while deleting Doctor");
					logs.LOGGER.info("Database error while deleting Doctor"+e);
				}
				}
				}
		});
		
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
					.addGap(456)
					.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(436)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addComponent(lblDoctorId, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(42)
							.addComponent(doctor_id_combobox, 0, 326, Short.MAX_VALUE)))
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(111)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(doctor_id_combobox))
						.addComponent(lblDoctorId, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addGap(68)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(97))
		);
		frame.getContentPane().setLayout(groupLayout);
	
		
            }        
	}	


