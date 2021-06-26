package com.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import com.pharma.model.Product;
import com.pharma.model.RetrieveOffers;

public class OffersOwnerDao {

	static int prod_id = 0;
	
	public static int insertOffer(Product p) {
		
		try {
			Connection con = CreateConnection.fnCreateConnection();
			String query = "INSERT INTO offer(name,cost,discount) VALUES(?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getCost());
			stmt.setInt(3, p.getDiscount());
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.first()) {
				prod_id = rs.getInt(1);
			}
			
			return prod_id;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return prod_id;
	}
	
	public static boolean insertIntoContainsRelation(int store_id,int prod_id) {
		
		try {
			Connection conn = CreateConnection.fnCreateConnection();
			String query = "INSERT INTO contains(str_id,prod_id) VALUES(?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, store_id);
			stmt.setInt(2, prod_id);
			stmt.executeUpdate();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static ArrayList<RetrieveOffers> fnRetreveStoreOffers(int str_id) {
		
		ArrayList<RetrieveOffers> list = new ArrayList<>();
		try {
			Connection conn = CreateConnection.fnCreateConnection();
			String query = "SELECT * FROM offer WHERE prod_id IN (SELECT prod_id FROM contains WHERE str_id=?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, str_id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int prod_id = rs.getInt("prod_id");
				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				int discount = rs.getInt("discount");
				RetrieveOffers offer = new RetrieveOffers(prod_id,name,cost,discount);
				list.add(offer);
			}
			
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
