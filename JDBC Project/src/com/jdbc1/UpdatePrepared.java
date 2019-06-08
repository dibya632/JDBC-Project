package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdatePrepared {
	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dibya","root","root");
			
			String UpdatesqlQuery = "update employee set name=?,age=? WHERE id=?";
			PreparedStatement smt=conn.prepareStatement(UpdatesqlQuery);
			
			
			//smt.setInt(1,101);
			smt.setString(1,"man");//Thats for name
			smt.setInt(2,32);//Thats for age
			smt.setInt(3,1);//Thats for id
			
			int i=smt.executeUpdate();
			System.out.println(i+"recodes Updates");
			conn.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}

}
