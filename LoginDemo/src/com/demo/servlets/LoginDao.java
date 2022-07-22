package com.demo.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	public boolean userCheck(String uname, String pword) {
		String url = "jdbc:mysql://localhost:3306/logins";
		String username = "root";
		String password = "Revs@1996";
		String query = "select * from login_data where uname=? and pword=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, uname);
			st.setString(2, pword);
			ResultSet rs = st.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return false;
	}

}
