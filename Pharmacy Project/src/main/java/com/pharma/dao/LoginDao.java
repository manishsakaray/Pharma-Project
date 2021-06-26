package com.pharma.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pharma.model.DetailsClass;
import com.pharma.model.Login;

public class LoginDao {
	
	public static DetailsClass fnLoginValidation(Login l) {
		 
		DetailsClass details = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = CreateConnection.fnCreateConnection();
			String query = "SELECT username,password,area,cust_id FROM customer WHERE username=? AND password=?";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, l.getUsername());
			stmt.setString(2, l.getPassword());
			
			ResultSet rs = stmt.executeQuery();
			if(rs.first()) {
				String area = rs.getString("area");
				int cust_id = rs.getInt("cust_id");
				details = new DetailsClass(area,cust_id);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return details;
	}
}
