package oopd.project.code;

import oopd.project.database.DatabaseConnection;



public class SmartHealthCareSystem {
	public static DatabaseConnection db=new DatabaseConnection();
	public static void main(String[] args) {
	

		HomePage homePage=new HomePage();
		homePage.invoke();
	
	}

}
