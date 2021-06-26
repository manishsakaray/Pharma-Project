package com.pharma.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {

    static Connection conn = null;
    
    private CreateConnection() {
    	
    }
    
	public static Connection fnCreateConnection() {
	
		try {
			
				if(conn == null) {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma","root","mxnxsh19");
					
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}
}
