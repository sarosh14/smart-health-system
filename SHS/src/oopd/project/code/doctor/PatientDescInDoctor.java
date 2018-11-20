package oopd.project.code.doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class PatientDescInDoctor extends JFrame {

	private int docId,pId,recId;
	private JFrame frame;
	Connection con;
	 Statement st;
   ResultSet rs;

   PreparedStatement pst = null;
	
	public PatientDescInDoctor(int docId,int pId,int recId) {
		this.recId=recId;
		this.docId=docId;
		this.pId=pId;
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
	
	void initialize() {
		//System.out.println(docId);
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 502);
		frame.setTitle("Patient Appointment List");
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("            Patient Description");
		
		titleLabel.setBounds(83, 37, 543, 61);
		titleLabel.setForeground(Color.red);

		titleLabel.setFont(new Font("Serif", Font.BOLD,30));
		frame.getContentPane().add(titleLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(96, 130, 523, 249);
		frame.getContentPane().add(textPane);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(291, 412, 114, 25);
		frame.getContentPane().add(backButton);
		
		
		 try {

	            Class.forName("com.mysql.jdbc.Driver");

	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "");
	            st = con.createStatement();
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
		 
		 String description;
		 try {

	            pst = con.prepareStatement("select Patient_Desc from Record where RecID="+ recId );

	            ResultSet rs = pst.executeQuery();

	           
	            if (rs.next()) {

	                 description= rs.getString("Patient_Desc");
	                 //textPane.setEditable(true);
	                 textPane.setText(description);
	                 textPane.setForeground(Color.red);

	         		textPane.setFont(new Font("Serif", Font.BOLD,15));

	            }
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DoctorPatientOptions(docId, pId, recId);
				frame.dispose();
				
			}
		});
		
		
		
		
		
		
	}	
}
