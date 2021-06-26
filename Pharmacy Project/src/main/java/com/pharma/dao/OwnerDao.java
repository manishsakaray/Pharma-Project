package com.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pharma.model.Owner;

public class OwnerDao {
	
	static int owner_id = 0;
	
	public static int insertOwner(Owner o) {
		
		try {
			Connection con = CreateConnection.fnCreateConnection();
			
			boolean flag = fnUsernameUniqueness(o,con);
			
			if(flag) {
				
				String query = "INSERT INTO owner(phone_no,name,email,username,password) VALUES(?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				
				stmt.setString(1, o.getPhone_no());
				stmt.setString(2, o.getName());
				stmt.setString(3, o.getEmail());
				stmt.setString(4, o.getUsername());
				stmt.setString(5, o.getPassword());
				stmt.executeUpdate();
				
				String retrevalQuery = "SELECT owner_id FROM owner WHERE username=?";
				PreparedStatement pstmt = con.prepareStatement(retrevalQuery);
				pstmt.setString(1, o.getUsername());
				
				ResultSet rs = pstmt.executeQuery();
				if(rs.first()) {
					owner_id = rs.getInt("owner_id");
				}
				return owner_id;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return owner_id;
	}
	
	private static boolean fnUsernameUniqueness(Owner o, Connection con) {
		
		try {
			String query = "SELECT username FROM owner WHERE username=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, o.getUsername());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() == false)
				return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
