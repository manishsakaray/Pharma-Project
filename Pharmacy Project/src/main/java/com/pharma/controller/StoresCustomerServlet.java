package com.pharma.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharma.dao.ComputeStoresDao;
import com.pharma.model.CustomerStore;


@WebServlet("/custstore")
public class StoresCustomerServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String latitude = req.getParameter("latitude");
		String longitude = req.getParameter("longitude");
		
		if(latitude != null || longitude != null)
	    res.sendRedirect("http://www.google.com/maps/place/"+latitude+","+longitude);
	}
	
}
