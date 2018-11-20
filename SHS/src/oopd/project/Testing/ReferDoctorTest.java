package oopd.project.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import oopd.project.code.doctor.DoctorRefer;

class ReferDoctorTest {

	DoctorRefer doctorRefer = new DoctorRefer();
	Connection con;
	Statement st;

	
	public ReferDoctorTest() 
		 {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "");
			st = (Statement) con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * checking rank of doctor
	 */
	@Test
	void testCheckRank() {
		//on docId with rank ="Specialist or SEnior Specialist it will return true else false"
		//doc Id =104 is a Specialist so return true
		int docId=104;
		
		Boolean status = doctorRefer.checkDoctorRank(docId,st);
		//System.out.println(status);
		assertNotNull(status);
		assertEquals(true, status);
		
	}
	
	@Test
	void testFindingDeptId()
	{
		int docId=104;
		int expectedId=1;
		int deptId=doctorRefer.findingDeptId(docId, st);
		
		assertNotNull(deptId);
		assertEquals(expectedId, deptId);
		
	}
	

	@After
	void close() {
		try {
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
