package com.jdbc1;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlExample {
public static void main(String[]args) {
	Connection conn=null;
	java.sql.Statement smt=null;

	try
	{
		Class.forName("com.mysql.jdbc.Driver"); 
				 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dibya","root","root");
				 smt=conn.createStatement();
				ResultSet rs=smt.executeQuery("select * from new_table");
				while(rs.next())
				{
					System.out.println("id="+rs.getInt(1)+"name="+rs.getString(2)+"age="+rs.getInt(3));
				}
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch(SQLException e) {
		e.getStackTrace();
	}
	finally {
		try
		{
			smt.close();
			conn.close();
			
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
}
