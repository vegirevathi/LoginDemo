package com.demo.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpDao {

	public int saveDetails(String uname, String pword) {
		String url = "jdbc:mysql://localhost:3306/logins";
		String username = "root";
		String password = "Revs@1996";
		String query = "insert into login_data(uname, pword) values(?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, uname);
			st.setString(2, pword);
			int count = st.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
