package com.pharma.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharma.dao.ComputeStoresDao;
import com.pharma.dao.LoginDao;
import com.pharma.model.CustomerStore;
import com.pharma.model.DetailsClass;
import com.pharma.model.Login;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
//		ServletContext sc = req.getServletContext();
//		if(sc.getAttribute("loginFlag")!=null) {
//			sc.removeAttribute("loginFlag");
//			res.sendRedirect("index.html");
//		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username == "" || password == "") {
			 res.sendRedirect("login.html");
		}else {
			
			Login login = new Login(username,password);
			HttpSession session = req.getSession();
			DetailsClass details = LoginDao.fnLoginValidation(login);
			
			if(details != null) {
				ServletContext sc = req.getServletContext();
				sc.setAttribute("loginFlag", 1);
				sc.setAttribute("area", details.area);
				sc.setAttribute("customer_id", details.cust_id);
				ArrayList<CustomerStore> cust_store = ComputeStoresDao.fnGetCustomerStore(details.cust_id);
				if(cust_store != null)
					session.setAttribute("cust_store", cust_store);
				else
					session.setAttribute("cust_store", null);
				res.sendRedirect("index.html");
			}else {
				res.sendRedirect("login.html");
			}
		}
		
//		Login login = new Login(username,password);
//		
//		boolean status = LoginDao.fnLoginValidation(login);
//		
//		if(status)
//			res.getWriter().print("logged in successfully");
//		else
//			res.getWriter().print("invalid credentials");
	}
	
}
