package com.prepared.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeletePrepared {
	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:/pinku","root","root");
			
			String sql="delete FROM employee WHERE id=?";
			PreparedStatement smt=conn.prepareStatement(sql);
			
			smt.setInt(1, 34);
			int i=smt.executeUpdate();
			System.out.println(i+"records DELETED");
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
