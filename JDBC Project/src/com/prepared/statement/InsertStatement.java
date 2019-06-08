package com.prepared.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertStatement {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306:/pinku", "root", "root");

			String sql = "insert into employee(name,age)values(?,?)";
			PreparedStatement smt = conn.prepareStatement(sql);

			smt.setString(1, "xyz");
			smt.setInt(2, 353);

			int i = smt.executeUpdate();
			System.out.println(i + "records inserted");
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
