package com.prepared.statement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertePrepared {
	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:/dibya","root","root");
			
			String sql="insert into Employee(name,age)values(?,?)";
			PreparedStatement smt=conn.prepareStatement(sql);
			
			smt.setString(1, "xyz");
		    smt.setInt(1, 23);
		    
		    int i=smt.executeUpdate();
		    System.out.println(i+"recored inserted");
		    
		    conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
		
	

}
