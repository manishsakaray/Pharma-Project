package com.pharma.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharma.dao.StoreDao;
import com.pharma.model.Store;

@WebServlet("/registerstore")
public class StoreServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String phone_no = req.getParameter("phone");
		String name = req.getParameter("storename");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String latitude = req.getParameter("latitude");
		String longitude = req.getParameter("longitude");
		String area = req.getParameter("area");
		
		if(phone_no == "" || name == "" || email == "" || address == "" || latitude == "" || longitude == "" || area == "") {
			res.sendRedirect("register.html");
		}
		else {
			Store store = new Store(name,email,phone_no,address,latitude,longitude,area);
			int store_id = StoreDao.insertStore(store);
			
			if(store_id > 0) {
				ServletContext sc = req.getServletContext();
				sc.setAttribute("store_id", store_id);
				int owner_id = (int)sc.getAttribute("owner_id");
				boolean flag = StoreDao.insertIntoOwnsRelation(owner_id, store_id);
				if(flag) {
					res.sendRedirect("login_owner.html");
				}else {
					res.getWriter().print("database error!! we are currently working on it");
				}
			}
			else
				res.getWriter().print("database error!! we are currently working on it");
		}
	}
}
