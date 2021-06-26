package com.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pharma.model.Store;

public class StoreDao {

	static int store_id = 0;
	
	public static int insertStore(Store s) {
		
		try {
			Connection con = CreateConnection.fnCreateConnection();
			String query = "INSERT INTO store(phone_no,name,email,address,latitude,longitude,area) VALUES(?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, s.getPhone_no());
			stmt.setString(2, s.getName());
			stmt.setString(3, s.getEmail());
			stmt.setString(4, s.getAddress());
			stmt.setString(5, s.getLatitude());
			stmt.setString(6, s.getLongitude());
			stmt.setString(7, s.getArea());
			stmt.executeUpdate();
			
			String retrevalQuery = "SELECT str_id FROM store WHERE latitude=? AND longitude=?";
			PreparedStatement pstmt = con.prepareStatement(retrevalQuery);
			pstmt.setString(1, s.getLatitude());
			pstmt.setString(2, s.getLongitude());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.first()) {
				store_id = rs.getInt("str_id");
			}
			
			return store_id;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return store_id;
	}
	
	public static boolean insertIntoOwnsRelation(int owner_id, int store_id) {
		
		try {
			Connection con = CreateConnection.fnCreateConnection();
			String query = "INSERT INTO owns(owner_id,str_id) VALUES(?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, owner_id);
			stmt.setInt(2, store_id);
			stmt.executeUpdate();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
