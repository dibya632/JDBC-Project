package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertPrepared {
	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dibya","root","root");
			String sql = "insert into employee(name,age) values(?,?)";
			PreparedStatement smt=conn.prepareStatement(sql);
			//smt.setInt(1,101);
			smt.setString(1,"sdfgh");
			smt.setInt(2,33);
			
			int i=smt.executeUpdate();
			System.out.println(i+"recodes Inserted");
			conn.close();
		}
		catch(Exception e)
		{ 
			System.out.println(e);} 
	}

}
