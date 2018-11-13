package oopd.project.code;
import oopd.project.database.DatabaseConnection;
import oopd.project.logging.LogExceptionsToFile;




public class SmartHealthCareSystem {
	
	

	// DatabaseConnection db=new DatabaseConnection();

	 static DatabaseConnection db=new DatabaseConnection();

	public static void main(String[] args) {

		 LogExceptionsToFile logs=new LogExceptionsToFile(SmartHealthCareSystem.class.getName());
		// db.readDb("help_keyword");
		 db.closeDb();
		
		logs.LOGGER.info("Hello");
	

		HomePage homePage=new HomePage();
		homePage.invoke();
	
	}
	
	

}
