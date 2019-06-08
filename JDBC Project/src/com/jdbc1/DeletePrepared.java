package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeletePrepared {
	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dibya","root","root");
			
			String DeletesqlQuery = "DELETE FROM employee WHERE id=?";
			PreparedStatement smt=conn.prepareStatement(DeletesqlQuery);
			
			
			smt.setInt(1,2);
			
			int i=smt.executeUpdate();
			System.out.println(i+"recodes delete");
			conn.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}

}
