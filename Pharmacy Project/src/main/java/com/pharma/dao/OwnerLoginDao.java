package com.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pharma.model.Login;

public class OwnerLoginDao {

	public static int fnLoginValidation(Login l) {
		
		int owner_id = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = CreateConnection.fnCreateConnection();
			String query = "SELECT username, password, owner_id FROM owner WHERE username=? AND password=?";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, l.getUsername());
			stmt.setString(2, l.getPassword());
			
			ResultSet rs = stmt.executeQuery();
			if(rs.first())
				owner_id = rs.getInt("owner_id");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return owner_id;
	}
	
	public static int fnGetStoreId(int owner_id) {
		
		int store_id = 0;
		try {
			Connection con = CreateConnection.fnCreateConnection();
			String query = "SELECT str_id FROM owns WHERE owner_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, owner_id);
		
			ResultSet rs = stmt.executeQuery();
			if(rs.first()) {
				store_id = rs.getInt("str_id");
				return store_id;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return store_id;
		
	}
}

