package oopd.project.code.patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PatientDescription2 {

	private JFrame frame;
	private int pid;
	private Connection con;
    private ResultSet rs;
    private Statement st;
    private String ids,idss;
    int ids1,ids11;
    private int from,from1;
    JTable table;
	JComboBox doct_combobox = new JComboBox();
	String[] columnNames = {"Did", "Date", "StartTime","EndTime"};

	Vector v1;
	String s1;
	public PatientDescription2(Vector v1, String s1,int pid) {
		this.v1=v1;
		this.s1=s1;
		this.pid=pid;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	       
	        String str = (String)doct_combobox.getSelectedItem();
	        
	        if(str=="None")
	        {
	        	System.out.println("Please select a doctor");
	        	JOptionPane.showMessageDialog(frame, "Please select a doctor");
	        }
	        else
	        {
				str = str.replaceAll("[^-?0-9]+","");
				int gend = Integer.parseInt(str);
		        from = gend;
		        //System.out.println(gend);
		        int ScheduleId;
		        int Did;
		        String Date = "";
		        String StartTime = "";
		        String EndTime = "";
		        int Count_Of_Patients;	       
		        try {
		        	Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
		            PreparedStatement pst = conn.prepareStatement("select * from Schedule where Did="+gend);
	
		            ResultSet rs = pst.executeQuery();
	
		            int i = 0;
		            if (rs.next()) {
	
		               // ScheduleId = rs.getInt("ScheduleId");
		                Did = rs.getInt("Did");
		                Date = rs.getString("Date");
		                StartTime = rs.getString("StartTime");
		                EndTime=rs.getString("EndTime");
		                //Count_Of_Patients=rs.getInt("Count_Of_Patients");
		                
		                System.out.println(Did+" "+Date+" "+StartTime);
		                model.addRow(new Object[]{Did, Date, StartTime,EndTime});
	
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
		            ex.printStackTrace();
		            System.out.println(ex);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 712, 403);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Select Doctor");
		label.setBounds(131, 164, 209, 32);
		frame.getContentPane().add(label);
		
		String[] s11= {"None","OPD","LOCAL"};
		JComboBox location_combobox = new JComboBox(s11);
		location_combobox.setBounds(331, 215, 107, 32);
		frame.getContentPane().add(location_combobox);
				
           doct_combobox = new JComboBox(v1);
          
           JButton btnAdd = new JButton("Select");
           btnAdd.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent arg0) {

				String str = (String)doct_combobox.getSelectedItem().toString();

				String location = (String)location_combobox.getSelectedItem().toString();
				if(str.equalsIgnoreCase("None") || location.equalsIgnoreCase("None"))
				{
					JOptionPane.showMessageDialog(frame, "Doctor must be selected!");
				}
				else
				{
					str = str.replaceAll("[^-?0-9]+","");
				int gend2 = Integer.parseInt(str);
		        try {
		            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
		            
		            String sql = "INSERT INTO Record(Pid,Patient_Desc, Did,Admit_Date,Location) values (?,?, ?,?,?)";
		            PreparedStatement statement = conn.prepareStatement(sql);
		            
		            Date date=new Date(System.currentTimeMillis());
		            statement.setInt(1, pid);
		            statement.setString(2, s1);
		            statement.setInt(3, gend2);
		            statement.setDate(4, date);
		            statement.setString(5,location);
		            
		            int row = statement.executeUpdate();
		            if (row > 0) {
		                System.out.println("Appointment Added.");
		                JOptionPane.showMessageDialog(frame, "Appointment Added !");
		                //AdminWork adminWork = new AdminWork();
						frame.dispose();
						new PatientWork(pid);
						//adminWork.invoke();
		            }
		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        } 
           		
           	}
				}
           });
        
           doct_combobox.setBounds(332, 164, 335, 32);
   		frame.getContentPane().add(doct_combobox);
   		
		
		btnAdd.setBounds(130, 291, 92, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnViewSchedule = new JButton("View Schedule");
		btnViewSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTableData();
				
			}
			
			
		});
		btnViewSchedule.setBounds(308, 291, 160, 25);
		frame.getContentPane().add(btnViewSchedule);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PatientDescription(pid);
				frame.dispose();				
			}
		});
		btnBack.setBounds(598, 0, 114, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(131, 220, 86, 32);
		frame.getContentPane().add(lblLocation);
		
		
	}
}