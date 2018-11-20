package oopd.project.code;

import oopd.project.database.DatabaseConnection;
import oopd.project.logging.LogExceptionsToFile;

/**
PROJECT TEAM-->

Sarosh Hasan (MT18084)
Shubham Gupta (Mt18055)
Vikash Kumar Pandey (Mt18086)

*/


public class SmartHealthCareSystem {
	
	static DatabaseConnection con=new DatabaseConnection();
	public static void main(String[] args) {

		HomePage homePage=new HomePage();
		homePage.invoke();
	
	}
	
	

}
