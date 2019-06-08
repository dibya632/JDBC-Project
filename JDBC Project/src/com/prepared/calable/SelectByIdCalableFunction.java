package com.prepared.calable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Callable;

public class SelectByIdCalableFunction  {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dibya", "root", "root");

			String selectsqlQuery = "select getEmployeeName(?)";
			CallableStatement smt = conn.prepareCall(selectsqlQuery);
            smt.setInt(1, 4);
			

			ResultSet rs = smt.executeQuery();
			while (rs.next()) {
				
				String name = rs.getString(1);
				System.out.println("name=" + name);
			    System.out.println("==============================");
			}
			rs.close();
			smt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}