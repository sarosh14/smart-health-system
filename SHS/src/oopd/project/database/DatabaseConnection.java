package oopd.project.database;
import java.sql.*;


public class DatabaseConnection 
{
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public DatabaseConnection() {
		
		try{  
		//Class.forName("com.mysql.cj.jdbc.Driver");  
				Class.forName("com.mysql.jdbc.Driver");
				//connection setup
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");  
				//here shs_db is database name, root is username and password  is empty
				 stmt=con.createStatement();  
		}catch(Exception e){ System.out.println(e);}  
	}

	public void readDb(String tableName)
	{
			try {
				rs = stmt.executeQuery("select * from "+tableName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	
	}
	
	public void closeDb()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
