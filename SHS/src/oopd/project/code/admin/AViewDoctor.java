package oopd.project.code.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import oopd.project.logging.LogExceptionsToFile;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AViewDoctor {

	private JFrame frame;
	private Connection con;
    private ResultSet rs;
    private Statement st;
    private String ids;
    int ids1;
    private int from;
    JTable table;
    JComboBox doctorid_combobox = new JComboBox();
    String[] columnNames = {"Did", "Name", "DOB", "Gender","Address","ContactNo","Password","Deptid","Rank","Surgeon","OpdFees"};
	
    /**
	 * Launch the application.
	 */
	static AViewDoctor window = new AViewDoctor();
	LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
	
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
	public AViewDoctor() {
		initialize();
	}
	 public void showTableData() 
	 {

	        JFrame frame1 = new JFrame("Database Search Result");
	        frame1.getContentPane().setLayout(new BorderLayout());
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columnNames);
	        table = new JTable();
	        table.setModel(model);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        table.setFillsViewportHeight(true);
	        JScrollPane scroll = new JScrollPane(table);
	        scroll.setHorizontalScrollBarPolicy(

	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	        scroll.setVerticalScrollBarPolicy(

	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        String str = (String)doctorid_combobox.getSelectedItem();
	        if(str=="None")
	        {
	        	System.out.println("Please select a doctor");
	        	JOptionPane.showMessageDialog(frame, "Please select a doctor");
	        }
	        else
	        {
			//System.out.println(str);
			str = str.replaceAll("[^-?0-9]+","");
			
			//System.out.println("Selected0 = "+Arrays.asList(str.trim().split(" ")));
			//System.out.println("Selected1 = "+str);
			int gend = Integer.parseInt(str);

	        from = gend;

	//String textvalue = textbox.getText();
//"Did", "Name", "DOB", "Gender","Address","ContactNo","Password","Deptid","Rank","Surgeon","OpdFees"
	        int Did;
	        String Name  = "";
	        String DOB = "";
	        String Gender = "";
	        String Address = "";
	        String ContactNo = "";
	        String Password = "";
	        String Deptid = "";
	        String Rank = "";
	        String Surgeon = "";
	        String OpdFees = "";
	       
	        try {

	            PreparedStatement pst = con.prepareStatement("select * from Doctor where Did="+from);

	            ResultSet rs = pst.executeQuery();

	            int i = 0;
	            if (rs.next()) {

	                Did = rs.getInt("Did");
	                Name = rs.getString("Name");
	                DOB = rs.getString("DOB");
	                Gender = rs.getString("Gender");
	                Address=rs.getString("Address");
	                ContactNo=rs.getString("ContactNo");
	                Password=rs.getString("Password");
	                Deptid=rs.getString("Deptid");
	                Rank=rs.getString("Rank");
	                Surgeon=rs.getString("Surgeon");
	                OpdFees=rs.getString("OpdFees");

	                model.addRow(new Object[]{Did, Name, DOB, Gender,Address,ContactNo,Password,Deptid,Rank,Surgeon,OpdFees});

	                i++;

	            }

	            if (i < 1) {

	                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

	            }

	            if (i == 1) {

	                System.out.println(i + " Record Found");

	            } else {

	                System.out.println(i + " Records Found");

	            }

	        } catch (Exception ex) {

	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

	        }

	        frame1.getContentPane().add(scroll);

	        frame1.setVisible(true);

	        frame1.setSize(400, 300);
	        }
	    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("View Doctor");
		frame.setBounds(100, 100, 656, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblEnterDoctorid = new JLabel("Enter DoctorID");
		lblEnterDoctorid.setBounds(40, 144, 238, 23);
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
           doctorid_combobox = new JComboBox(v);
           
           st.close();
           rs.close();
            
		 }
         catch(Exception e)
         {
            System.out.println("Database Error!");
            logs.LOGGER.info("Database Error in ARemoveDoctor class");
         }
		
				 
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTableData();
			}
		});
		btnSearch.setBounds(196, 224, 120, 24);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(530, 27, 102, 24);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminWork adminWork = new AdminWork();
				window.frame.dispose();
				adminWork.invoke();
				
			}
		});
		frame.getContentPane().setLayout(null);
		
		
		doctorid_combobox.setBounds(270, 143, 362, 24);
		frame.getContentPane().add(doctorid_combobox);
		frame.getContentPane().add(btnBack);
		frame.getContentPane().add(btnSearch);
		frame.getContentPane().add(lblEnterDoctorid);
	}
}
