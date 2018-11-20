package oopd.project.code.doctor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DoctorViewProfile extends JFrame {

	private JFrame frame;
	private JTable table;
	private int docId;
	Connection con;
	 Statement st;
    ResultSet rs;

    PreparedStatement pst = null;
    String[] columnNames = {"DoctorName", "DOB","Gender", "Address", "ContactNo","Rank","Surgeon","Opd Fees"};

	
	/**
	 * Create the frame.
	 */
	public DoctorViewProfile(int docId) {
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
	
	private void initialize() {

        frame = new JFrame("Database Search Result");

        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(HEIGHT, 500);
        frame.setSize(WIDTH, 500);

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

        String uname = "";

        String gender  = "";
        
        String dob="";

        String address = "";

        String rank = "";
        String contact = "";
        
        String surgeon="";
        String opdFees="";
        
        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "");
            st = con.createStatement();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }

 

        try {

            pst = con.prepareStatement("select * from Doctor where Did="+ docId );

            ResultSet rs = pst.executeQuery();

            int i = 0;
            if (rs.next()) {

                uname = rs.getString("Name");

                address = rs.getString("Address");

                rank = rs.getString("Rank");

                contact = rs.getString("ContactNo");
                gender=rs.getString("Gender");
                dob=rs.getDate("DOB").toString();
                surgeon=rs.getString("Surgeon");
                opdFees=rs.getString("OpdFees");
                
                model.addRow(new Object[]{uname, dob,gender, address, contact,rank,surgeon,opdFees});

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

        frame.getContentPane().add(scroll);

        frame.setVisible(true);

        frame.setSize(400, 300);
	}
	

}
