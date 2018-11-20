package oopd.project.code.doctor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import oopd.project.logging.LogExceptionsToFile;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



	public class DoctorSchedule {

		private JFrame frame;
		private int docId;
		private JTextField ddate;
		private JTextField dstarttime;
		private JTextField dendtime;
		LogExceptionsToFile logs=new LogExceptionsToFile(this.getClass().getName());
		/**
		 * Launch the application.
		 */
		
		public DoctorSchedule(int docId) {
			this.docId=docId;
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								
								initialize();
							} catch (Exception e) {
								e.printStackTrace();
								logs.LOGGER.info(""+e);
							}
						}
					});
		
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame("Doctor");
			frame.setBounds(100, 100, 712, 480);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.getContentPane().setLayout(null);
			
			JLabel lblDate = new JLabel("Date");
			lblDate.setBounds(169, 164, 189, 33);
			frame.getContentPane().add(lblDate);
			
			ddate = new JTextField();
			ddate.setBounds(366, 164, 189, 30);
			frame.getContentPane().add(ddate);
			ddate.setColumns(10);
			
			JLabel lblStartTime = new JLabel("Start Time");
			lblStartTime.setBounds(169, 219, 197, 30);
			frame.getContentPane().add(lblStartTime);
			
			dstarttime = new JTextField();
			dstarttime.setBounds(366, 216, 189, 33);
			frame.getContentPane().add(dstarttime);
			dstarttime.setColumns(10);
			
			JLabel lblYyyymmdd = new JLabel("*YYYY/MM/DD");
			lblYyyymmdd.setBounds(573, 170, 127, 27);
			frame.getContentPane().add(lblYyyymmdd);
			
			JLabel lblhhmmss = new JLabel("*HH/MM/SS");
			lblhhmmss.setBounds(575, 227, 87, 15);
			frame.getContentPane().add(lblhhmmss);
			
			JLabel lblEndTime = new JLabel("End Time");
			lblEndTime.setBounds(169, 271, 197, 30);
			frame.getContentPane().add(lblEndTime);
			
			dendtime = new JTextField();
			dendtime.setBounds(366, 270, 189, 33);
			dendtime.setColumns(10);
			frame.getContentPane().add(dendtime);
			
			JLabel label = new JLabel("*HH/MM/SS");
			label.setBounds(575, 274, 87, 15);
			frame.getContentPane().add(label);
			
			JButton btnAddSchedule = new JButton("Add Schedule");
			btnAddSchedule.setBounds(169, 346, 132, 25);
			btnAddSchedule.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String date =  ddate.getText();
					
					String starttime = dstarttime.getText();
					String endtime = dendtime.getText();
					if(date.length()==0 || starttime.length()==0 || endtime.length()==0)
					{
						JOptionPane.showMessageDialog(frame, "You have not entered Field Value!");
					}
					else
					{	
					try {
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2","root","");
			            
			            String sql = "INSERT INTO Schedule(Date, StartTime, EndTime,Did) values (?, ?, ?,?)";
			            PreparedStatement statement = conn.prepareStatement(sql);
			            statement.setString(1, date);
			            statement.setString(2, starttime);
			            statement.setString(3, endtime);
			            statement.setInt(4, docId);
			            int row = statement.executeUpdate();
			            if (row > 0) {
			                System.out.println("Insert in Database successfully done.");
			                JOptionPane.showMessageDialog(frame, "Successfully Added !");
			               new DoctorView(docId);
							frame.dispose();
							
			            }
			            conn.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            logs.LOGGER.info(""+ex);
			        } 
				}   
				}

				});
			frame.getContentPane().add(btnAddSchedule);
			
			JButton backButton = new JButton("BackToDoctorHome");
			backButton.setBounds(366, 346, 189, 25);
			
			backButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new DoctorView(docId);
					frame.dispose();
				}
			});
			frame.getContentPane().add(backButton);
			
			JLabel titleLabel = new JLabel("Add Schedule");
			titleLabel.setBounds(245, 33, 269, 61);
			titleLabel.setForeground(Color.red);

			titleLabel.setFont(new Font("Serif", Font.BOLD,30));
			frame.getContentPane().add(titleLabel);
		}
	}
