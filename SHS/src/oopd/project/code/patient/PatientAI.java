package oopd.project.code.patient;

import java.awt.EventQueue;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import oopd.project.logging.LogExceptionsToFile;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientAI {

	LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
	private JFrame frame;
	private Connection con;
	private ResultSet rs;
	private Statement st;
	private String ids,idss;
	int ids1,ids11;
	private int from;
	//static int id;
	private int pid;

	
	public PatientAI(int pid) {
		this.pid=pid;
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
	
	
	public void Dept_did(String s2,String s1)
	{
		 try {
	        	
	            Class.forName("com.mysql.jdbc.Driver");
	           
	            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
	           
	            st = (Statement) con.createStatement();
	           
	           // System.out.println("From DeptId= "+from);
	            String fro="'"+s2+"'";
	            rs = st.executeQuery("select Did from Doctor where DeptId in (select Deptid from Department where DeptName = "+fro+" )");
	     
	            while (rs.next()) {

	                ids11 = rs.getInt("Did");
	                System.out.println("Doctor id 1= "+ids11);
	                break;

	           }
	            Ai( pid,ids11,s1);
	            
	            //System.out.println("Doctor id 2= "+ids11);
		 }
		 catch(Exception e)
		 {
			 logs.LOGGER.info("Error in PatientAI");
			 System.out.println(e);
		 }
	}
	
	public void Ai(int pid1, int did, String s1)
	{
	try {
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
        
        String sql = "INSERT INTO Record(Pid,Patient_Desc, Did,Admit_Date) values (?,?, ?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        Date date=new Date(System.currentTimeMillis());
        statement.setInt(1, pid1);
        statement.setString(2, s1);
        statement.setInt(3, did);
        statement.setDate(4, date);
        
        int row = statement.executeUpdate();
        if (row > 0) {
            System.out.println("Appointment Added.");
            JOptionPane.showMessageDialog(frame, "Appointment Added !");
            //AdminWork adminWork = new AdminWork();
			frame.dispose();
			new PatientWork(pid1);
			//adminWork.invoke();
        }
        conn.close();
    } catch (SQLException ex) {
    	logs.LOGGER.info("Error in PatientAI");
        ex.printStackTrace();
    } 
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterText = new JLabel("Enter Disease");
		lblEnterText.setBounds(74, 105, 209, 61);
		frame.getContentPane().add(lblEnterText);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(301, 114, 256, 62);
		frame.getContentPane().add(textArea);
				JButton btnAppointment = new JButton("Appointment");
				btnAppointment.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String s1;
						s1 = textArea.getText();
						if(s1.length()==0)
						{
							JOptionPane.showMessageDialog(frame, "Description must be Filled!");
						}
						else
						{
						System.out.println(pid);
						
						HashMap<String,ArrayList<String>> map=new HashMap<>();
						ArrayList<String> ent = new ArrayList<>();
						ent.add("ear");ent.add("foreign body");
						ent.add("nose");ent.add("swallowing");
						ent.add("throat");
						map.put("ENT", ent);
						ArrayList<String> ortho = new ArrayList<>();
						ortho.add("ligaments");ortho.add("fratures");
						ortho.add("joint");ortho.add("fratures");
						ortho.add("joints");ortho.add("bone");
						ortho.add("knees");ortho.add("back pain");
						ortho.add("knee");ortho.add("muscles");
						map.put("Orthopedics",ortho);
						ArrayList<String> neuro = new ArrayList<>();
						neuro.add("migraine");
						neuro.add("brain");neuro.add("brain tumor");
						neuro.add("head trauma");
						map.put("Neurology",neuro);
						ArrayList<String> cardio = new ArrayList<>();
						cardio.add("heart");cardio.add("chest pain");
						cardio.add("chest");cardio.add("shortness of breath");
						cardio.add("sweating");
						map.put("Cardiology",cardio);
						ArrayList<String> psych = new ArrayList<>();
						psych.add("mood disorder");psych.add("dementia");
						psych.add("anxiety");psych.add("depression");
						psych.add("eating disorder");
						psych.add("mental illness");
						map.put("Psychitary",psych);
						
						int ENT_FLAG=0,ORTHOPEDIC_FLAG=0,NEUROLOGY_FLAG=0,CARDIOLOGY_FLAG=0,PSYCHITRARY_FLAG=0;
						//System.out.println(map.get("ENT").get(0));
						
						
						for (int i=0;i<ent.size();i++)
						{
						if ( s1.toLowerCase().indexOf(map.get("ENT").get(i).toLowerCase()) == 0 ) {
							   //System.out.println("Refer ENT");
							   ENT_FLAG = 1;
							} 
						}
						for (int i=0;i<ortho.size();i++)
						{
						if ( s1.toLowerCase().indexOf(map.get("Orthopedics").get(i).toLowerCase()) == 0 ) {
							   //System.out.println("Refer ENT");
							   ORTHOPEDIC_FLAG = 1;
							} 
						}
						for (int i=0;i<neuro.size();i++)
						{
						if ( s1.toLowerCase().indexOf(map.get("Neurology").get(i).toLowerCase()) == 0 ) {
							   //System.out.println("Refer ENT");
							   NEUROLOGY_FLAG = 1;
							} 
						}
						for (int i=0;i<cardio.size();i++)
						{
						if ( s1.toLowerCase().indexOf(map.get("Cardiology").get(i).toLowerCase()) == 0 ) {
							   //System.out.println("Refer ENT");
							   CARDIOLOGY_FLAG = 1;
							} 
						}
						for (int i=0;i<psych.size();i++)
						{
						if ( s1.toLowerCase().indexOf(map.get("Psychitary").get(i).toLowerCase()) == 0 ) {
							   //System.out.println("Refer ENT");
							  PSYCHITRARY_FLAG = 1;
							} 
						}
						
						if(ENT_FLAG == 1)
						{
							String s111="ENT";
							Dept_did(s111,s1);
							System.out.println("GO TO ENT");
							 
						}
						else if(ORTHOPEDIC_FLAG == 1)
						{
						    String s112="Orthopedics";
						    Dept_did(s112,s1);
						    System.out.println("GO TO Orthopedics");
						}
						else if(NEUROLOGY_FLAG == 1)
						{
							String s113="Neurology";
						    Dept_did(s113,s1);
						    System.out.println("GO TO Neurology");
						}						
						else if(CARDIOLOGY_FLAG == 1)
						{
							String s114="Cardiology";
							Dept_did(s114,s1);
							System.out.println("GO TO Cardiology");
						}
						else if(PSYCHITRARY_FLAG == 1)
						{
							String s115="Psychitary";
							Dept_did(s115,s1);
							System.out.println("GO TO PSYCHITRARY");
						}
						else
						{
							String s116="Medicine";
							Dept_did(s116,s1);
							System.out.println("GO TO MEDICINE");
						}
						}
					}
				});
		btnAppointment.setBounds(74, 251, 124, 25);
		frame.getContentPane().add(btnAppointment);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookAppointment appointment = new BookAppointment(pid);
				frame.dispose();
				
			}
		});
		btnBack.setBounds(539, 12, 114, 25);
		frame.getContentPane().add(btnBack);
		
	}
}