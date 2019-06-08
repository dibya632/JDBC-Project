package com.prepared.statement2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeletePrepared {
	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:/pinku","root","root");
			
			String deleteQuery="delete FROM employee WHERE id=?";
			PreparedStatement smt=conn.prepareStatement(deleteQuery);
			
			smt.setInt(1, 45);
			int i=smt.executeUpdate();
		    System.out.println(i+"records delete");
		    conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
