package com.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pharma.model.CustomerOffers;
import com.pharma.model.RetrieveOffers;

public class OfferCustomerDao {

public static ArrayList<CustomerOffers> fnRetreveOffers(String area) {
		
		ArrayList<CustomerOffers> list = new ArrayList<>();
		try {
			Connection conn = CreateConnection.fnCreateConnection();
			String query = "select store.name,offer.name,latitude,longitude,cost,discount from contains,offer,store where offer.prod_id = contains.prod_id AND contains.str_id = store.str_id AND area=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, area);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String prodname = rs.getString("offer.name");
				String strname = rs.getString("store.name");
				String latitude = rs.getString("latitude");
				String longitude = rs.getString("longitude");
				int cost = rs.getInt("cost");
				int discount = rs.getInt("discount");
				CustomerOffers offer = new CustomerOffers(prodname,cost,discount,strname,latitude,longitude);
				list.add(offer);
			}
			
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
