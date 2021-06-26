package com.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.pharma.model.CustomerStore;

public class ComputeStoresDao {
	
	static boolean status = false;

	
	public static boolean fnSendRequestToStores(String area, int customer_id, String message) {
		
		ArrayList<Integer> list = new ArrayList<>(); 
		try {
			
			Connection conn = CreateConnection.fnCreateConnection();
			String query = "SELECT owner_id FROM owns WHERE str_id IN (SELECT str_id FROM store WHERE area=?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, area);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("owner_id"));
			}
			
			for(Integer i : list) {
				fnExecute(customer_id,message,i);
			}
			
			list = null;
			
			status = true;
			return status;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	private static void fnExecute(int cust_id, String message, int i) {
		
		try {
			
			Connection conn = CreateConnection.fnCreateConnection();
			String query = "INSERT INTO requests(cust_id,owner_id,time_stamp,message,availability) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			Calendar calendar = Calendar.getInstance();
			Date now = calendar.getTime();
			Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
			
			pstmt.setInt(1, cust_id);
			pstmt.setInt(2, i);
			pstmt.setTimestamp(3, currentTimestamp);
			pstmt.setString(4, message);
			pstmt.setNull(5, Types.NULL);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<CustomerStore> fnGetCustomerStore(int cust_id){
		
		ArrayList<CustomerStore> list = new ArrayList<>();
		try {
			Connection conn = CreateConnection.fnCreateConnection();
			String query = "select R.req_id, R.message, R.time_stamp, R.availability, S.latitude, S.longitude, S.name from requests R, store S, owns O where R.owner_id=O.owner_id AND O.str_id=S.str_id AND cust_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cust_id);
			
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String availabilityVal;
				String message = rs.getString("message");
				String time_stamp = rs.getString("time_stamp");
				int req_id = rs.getInt("req_id");
				String latitude = rs.getString("latitude");
				String longitude = rs.getString("longitude");
				String store_name = rs.getString("name");
				int availability = rs.getInt("availability");
				
				if(!rs.wasNull()) {
					if(availability == 1) {
						availabilityVal = "In Stock";
					}else {
						availabilityVal = "Out Of Stock";
					}
				CustomerStore store = new CustomerStore(message,availabilityVal,time_stamp,req_id,latitude,longitude,store_name);
				list.add(store);
				}
			}
			
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
