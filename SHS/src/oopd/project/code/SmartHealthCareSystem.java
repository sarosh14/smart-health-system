package oopd.project.code;

import oopd.project.database.DatabaseConnection;



public class SmartHealthCareSystem {
	public static DatabaseConnection db=new DatabaseConnection();
	public static void main(String[] args) {
	
	//adminview object
//		AdminView adminView=new AdminView();
//		adminView.invoke();
		HomePage homePage=new HomePage();
		homePage.invoke();
	//db.readDb("help_category");
	
	

	}

}
