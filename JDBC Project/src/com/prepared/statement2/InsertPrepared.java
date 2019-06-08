package com.prepared.statement2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertPrepared {
	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:/sanu","root","root");
			
			String sql="insert into Employee(name,age)values(?,?)";
			PreparedStatement smt=conn.prepareStatement(sql);
			
			smt.setString(1, "xyz");
			smt.setInt(2,23);
			
			int i=smt.executeUpdate();
			System.out.println(i+"recodes inserted");
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
