package oopd.project.code.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import oopd.project.logging.LogExceptionsToFile;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AaddDepartment {

	private JFrame frame;
	private JTextField dname;
	private Connection con;
    private ResultSet rs;
    private Statement st;
    private String ids;
    int ids1;
    private int hod_id;

	JComboBox doctlist_combobox = new JComboBox();
	LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
	/**
	 * Launch the application.
	 */
	static AaddDepartment window = new AaddDepartment();
	public  void invoke() 
	{
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
	public AaddDepartment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 712, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDepartmentName = new JLabel("Department Name");
		lblDepartmentName.setBounds(151, 142, 195, 41);
		frame.getContentPane().add(lblDepartmentName);
		
		dname = new JTextField();
		dname.setBounds(364, 153, 309, 30);
		frame.getContentPane().add(dname);
		dname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Department Hod Id");
		lblNewLabel.setBounds(151, 212, 182, 15);
		frame.getContentPane().add(lblNewLabel);
		
		try {

            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
            st = (Statement) con.createStatement();
            String s1 = "'"+"Senior_Specialist"+"'";
            rs = st.executeQuery("select Name, Did from Doctor where Rank = "+s1);

            Vector v = new Vector();
          //  System.out.println(rs);
            v.add("None");
            while (rs.next()) {

                ids = rs.getString("Name");
                ids1 = rs.getInt("Did");
                v.add("Name = "+ids+" ,"+"Did = "+ids1);
            //    System.out.println("ids are : "+ids);

           }
           doctlist_combobox = new JComboBox(v);
           
           st.close();
           rs.close();
            
		 }
         catch(Exception e)
         {
            System.out.println("Database Error!");
            logs.LOGGER.info("Database Error in ARemoveDoctor class");
         }
		
		
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String did = dname.getText();
				//String hod_id = (String)doctlist_combobox.getEditor().getItem();
				String str = (String)doctlist_combobox.getSelectedItem();
				if(str=="None")
				{
					System.out.println("fill all Fields");
					JOptionPane.showMessageDialog(frame, "Please fill all fields");
				}
				else
				{
				//System.out.println(str);
				str = str.replaceAll("[^-?0-9]+","");
				
				//System.out.println("Selected0 = "+Arrays.asList(str.trim().split(" ")));
				//System.out.println("Selected1 = "+str);
				int gend = Integer.parseInt(str);

		        hod_id = gend;
				if(did.length()==0)
				{
					System.out.println("Enter department name");
					JOptionPane.showMessageDialog(frame, "Enter department name");
				}
				else
				{
				//System.out.println(doctname+" "+dob+" "+gend+" "+address+" "+deptid+" "+rank+" "+serg+" "+fee);
				try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
		            
		            String sql = "INSERT INTO Department(DeptName, Did_Of_HOD) values (?, ?)";
		            PreparedStatement statement = conn.prepareStatement(sql);
		            statement.setString(1, did);
		            statement.setInt(2, hod_id);
		            
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
				}
				}
			}
		});
		btnAdd.setBounds(151, 287, 98, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				window.frame.dispose();
				AdminWork adminWork = new AdminWork();
				adminWork.invoke();
			}
		});
		btnBack.setBounds(586, 12, 114, 25);
		frame.getContentPane().add(btnBack);
		
		
		doctlist_combobox.setBounds(364, 207, 309, 24);
		frame.getContentPane().add(doctlist_combobox);
	}
}
