package com.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.pharma.model.RetrieveRequests;

public class RequestsOwnerDao {

	public static List<RetrieveRequests> fnGetRequests(int owner_id){
		
		ArrayList<RetrieveRequests> req_list = new ArrayList<>();
		try {
			Connection conn = CreateConnection.fnCreateConnection();
			String query = "SELECT req_id,message,time_stamp,availability FROM requests WHERE owner_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, owner_id);
			
			ResultSet rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	int req_id = rs.getInt("req_id");
		    	String time_stamp = rs.getString("time_stamp");
		    	String message = rs.getString("message");
		    	int availability = rs.getInt("availability");
		    	if(rs.wasNull()) {
		    	RetrieveRequests obj = new RetrieveRequests(req_id,message,time_stamp);
		    	req_list.add(obj);}
		    }
		    
		    return req_list;
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return req_list;
	}
	
	public static void fnUpdateAvailability(int req_id, int availability) {
		
		try {
			Connection conn = CreateConnection.fnCreateConnection();
			String query = "UPDATE requests SET availability=? WHERE req_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, availability);
			pstmt.setInt(2, req_id);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
