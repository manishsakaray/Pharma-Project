package com.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.pharma.model.Customer;

public class CustomerDao {

	public static boolean insertCustomer(Customer c) {
		
		try {
			Connection con = CreateConnection.fnCreateConnection();
			
			boolean flag = fnUsernameUniqueness(c,con);
			
			if(flag) {
				String query = "INSERT INTO customer(phone_no,name,email,username,password,area) VALUES(?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				
				stmt.setString(1, c.getPhone_no());
				stmt.setString(2, c.getName());
				stmt.setString(3, c.getEmail());
				stmt.setString(4, c.getUsername());
				stmt.setString(5, c.getPassword());
				stmt.setString(6, c.getArea());
				
				stmt.executeUpdate();
				return true;
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static boolean fnUsernameUniqueness(Customer c, Connection con) {
		
		try {
			String query = "SELECT username FROM customer WHERE username=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, c.getUsername());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() == false)
				return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
