package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectAllPrepared  {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dibya", "root", "root");

			String selectsqlQuery = "SELECT * FROM employee";
			PreparedStatement smt = conn.prepareStatement(selectsqlQuery);

			

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