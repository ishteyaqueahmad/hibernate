package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connection to database");

			Connection myConn = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println("Successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
