package com.pharma.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharma.dao.CustomerDao;
import com.pharma.model.Customer;

@WebServlet("/registercustomer")
public class CustomerServlet extends HttpServlet{

		public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
			
			String phone_no = req.getParameter("phone");
			String name = req.getParameter("firstname") + req.getParameter("lastname");
			String email = req.getParameter("email");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String reenterpassword = req.getParameter("reenterpassword");
			String area = req.getParameter("area");
			
			if(phone_no == "" || name == "" || email == "" || username == "" || password == "" || reenterpassword == "" || area == "") {
				res.sendRedirect("register.html");
				
			}else if(password.equals(reenterpassword)) {
				
				Customer cust = new Customer(phone_no,name,email,username,password,area);
				boolean status = CustomerDao.insertCustomer(cust);
				
				if(status)
					res.sendRedirect("login.html");
				else
					res.sendRedirect("register.html");
			}else {
				res.sendRedirect("register.html");
			}
		}
	
}
