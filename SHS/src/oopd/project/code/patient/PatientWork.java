package oopd.project.code.patient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import oopd.project.code.HomePage;

import java.awt.BorderLayout;

public class PatientWork {

	private JFrame frame,frame1;
	private int pid;
	private Connection con;
    private ResultSet rs, rs1;
    private Statement st, st1;
    private PreparedStatement pst;
    private String ids;
    static JTable table;
    private String[] columnNames = {"Did","Test_Adviced","Test_Report", "Medicine_Prescribed", 
    									"Date","Patient_Status","Fees_Per_Day","WardId","Location"};

	public PatientWork(int pid) {
		this.pid=pid;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					PatientWork window = new PatientWork();
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	 public void showTableData() 
	 {
	        frame1 = new JFrame("Database Search Result");
	        frame1.setVisible(true);
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
	//String textvalue = textbox.getText();

	        String Did = "";
	        String Test_Adviced="";
	        String Test_Report  = "";
	        String Medicine_Prescribed="";
	        String Date = "";
	        String Patient_Status = "";
	        String Fees_Per_Day= "";
	        String WardId= "";
	        String Location= "";
	        try {
	        	System.out.println("pid =="+pid);
	        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "");
	            pst = con.prepareStatement("select Did,Test_Adviced,Test_Report,Medicine_Prescribed,"
	            		+ "Date,Patient_Status,Fees_Per_Day,WardId,Location"
	            		+ " from Patient_History where RecId in (select RecId from Record where Pid = "+pid+")");

	            ResultSet rs = pst.executeQuery();

	            int i = 0;
	            while (rs.next()) {
	            	
	                Did = rs.getString("Did");
	                System.out.println("Did = "+Did);
	                Test_Adviced= rs.getString("Test_Adviced");
	                System.out.println("Test_Adviced = "+Test_Adviced);
	                Test_Report=rs.getString("Test_Report");
	                Medicine_Prescribed = rs.getString("Medicine_Prescribed");
	                Date = rs.getString("Date");
	                Patient_Status=rs.getString("Patient_Status");
	                Fees_Per_Day=rs.getString("Fees_Per_Day");
	                WardId = rs.getString("WardId");
	                Location = rs.getString("Location");
	                model.addRow(new Object[]{Did,Test_Adviced,Test_Report, Medicine_Prescribed, 
							Date,Patient_Status,Fees_Per_Day,WardId,Location});

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
	
	private void initialize() {
		frame = new JFrame("Patient");
		frame.setBounds(100, 100, 714, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JRadioButton rdbtn_editprofile = new JRadioButton("");
		rdbtn_editprofile.setBounds(364, 171, 125, 21);
		
		JRadioButton rdbtn_appointment = new JRadioButton("");
		rdbtn_appointment.setBounds(364, 128, 125, 23);

		JRadioButton rdbtn_history = new JRadioButton("");
		rdbtn_history.setBounds(364, 214, 144, 36);
		
		JLabel lblViewProfile = new JLabel("4- View Profile");
		lblViewProfile.setBounds(95, 266, 158, 23);
		frame.getContentPane().add(lblViewProfile);
		
		JRadioButton rdbtn_viewprofile = new JRadioButton("");
		rdbtn_viewprofile.setBounds(364, 266, 144, 23);
		frame.getContentPane().add(rdbtn_viewprofile);
		
		JLabel lblLogout = new JLabel("5- Logout");
		lblLogout.setBounds(95, 311, 114, 15);
		frame.getContentPane().add(lblLogout);
		
		JRadioButton rdbtn_logout = new JRadioButton("");
		rdbtn_logout.setBounds(364, 303, 144, 36);
		frame.getContentPane().add(rdbtn_logout);
		
		
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtn_editprofile);
		G.add(rdbtn_appointment);
		G.add(rdbtn_history);
		G.add(rdbtn_logout);
		G.add(rdbtn_viewprofile);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(95, 379, 76, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtn_appointment.isSelected())
				{  
					// Open screen, appointment manually or automatically
					BookAppointment bookappointment=new BookAppointment(pid);
					frame.dispose();
					//bookappointment.invoke();
					
				}
				if(rdbtn_editprofile.isSelected())
				{
					//edit Profile
					PatientEditProfile patienteditprofile = new PatientEditProfile(pid);
					frame.dispose();
					//patienteditprofile.invoke();
				}
				if(rdbtn_history.isSelected())
				{
					showTableData();
				}
				
				if(rdbtn_viewprofile.isSelected())
				{
					PatientViewProfile patientViewProfile = new PatientViewProfile(pid);
					//frame.dispose();
				}
				if(rdbtn_logout.isSelected())
				{
					new PatientView();
					frame.dispose();
				}
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("                       Welcome Patient");
		lblNewLabel.setBounds(64, 12, 285, 15);
		
		JLabel lblNewLabel_1 = new JLabel("You can perform following task");
		lblNewLabel_1.setBounds(64, 38, 266, 15);
		
		JLabel lblAddDoctor = new JLabel("1- Book Appointment");
		lblAddDoctor.setBounds(95, 136, 147, 15);
		
		JLabel lblRemoveDoctor = new JLabel("2- Edit Profile");
		lblRemoveDoctor.setBounds(98, 177, 158, 15);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("3- Record History");
		lblNewLabel_2.setBounds(95, 225, 171, 15);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblAddDoctor);
		frame.getContentPane().add(lblRemoveDoctor);
		frame.getContentPane().add(rdbtn_appointment);
		frame.getContentPane().add(rdbtn_editprofile);
		frame.getContentPane().add(btnNewButton);
		
		frame.getContentPane().add(rdbtn_history);
		
		
		
		
		
	}
}
