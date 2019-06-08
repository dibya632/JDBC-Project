package com.prepared.calable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Callable;

public class SelectByIdCalable  {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dibya", "root", "root");

			String selectsqlQuery = "call getemployee(?)";
			CallableStatement smt = conn.prepareCall(selectsqlQuery);
            smt.setInt(1, 3);
			

			ResultSet rs = smt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println("id=" + id);
				System.out.println("name=" + name);
				System.out.println("age=" + age);
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