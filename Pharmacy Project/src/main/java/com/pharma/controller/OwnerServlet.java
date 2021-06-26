package com.pharma.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharma.dao.OwnerDao;
import com.pharma.model.Owner;

@WebServlet("/registerowner")
public class OwnerServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String phone_no = req.getParameter("phone");
		String name = req.getParameter("firstname") + req.getParameter("lastname");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String reenterpassword = req.getParameter("reenterpassword");
		
		if(phone_no == "" || name == "" || email == "" || username == "" || password == "" || reenterpassword == "") {
			res.sendRedirect("register_owner.html");
		
		}else if(password.equals(reenterpassword)) {
			
			Owner owner = new Owner(phone_no,name,email,username,password);
			int owner_id = OwnerDao.insertOwner(owner);
			
			if(owner_id > 0) {
				ServletContext sc = req.getServletContext();
				sc.setAttribute("owner_id", owner_id);
				res.sendRedirect("register_store.html");
			}else {
				res.sendRedirect("register_owner.html");
			}
			
		}else {
			res.sendRedirect("register_owner.html");
		}
			
	}
	
}
