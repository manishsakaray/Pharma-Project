package com.pharma.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharma.dao.ComputeStoresDao;

@WebServlet("/compute")
public class ComputeStores  extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		ServletContext sc = req.getServletContext();
		String area = (String)sc.getAttribute("area");
		int customer_id = (int)sc.getAttribute("customer_id");
		String message = req.getParameter("homesearchbox");
		
		boolean status = ComputeStoresDao.fnSendRequestToStores(area,customer_id,message);
		if(status) {
			res.sendRedirect("stores.jsp");
		}else {
			res.getWriter().print("error on database server! please try again");
		}
	}
	
}
