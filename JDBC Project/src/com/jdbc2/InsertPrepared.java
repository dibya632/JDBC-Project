package com.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertPrepared {
	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:/pinku","root","root");
			
			String sql="insert into employee(name,age)values(?,?)";
			PreparedStatement smt=conn.prepareStatement(sql);
			
			smt.setString(1, "xyz");
			smt.setInt(3, 34);
			
			int i=smt.executeUpdate();
			System.out.println(i+"records delete");
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
