package com.pharma.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharma.dao.OwnerLoginDao;
import com.pharma.dao.RequestsOwnerDao;
import com.pharma.model.Login;
import com.pharma.model.RetrieveRequests;

@WebServlet("/loginowner")
public class OwnerLoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		ServletContext sc = req.getServletContext();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username == "" || password == "") {
			 res.sendRedirect("login_owner.html");
		}else {
			Login login = new Login(username,password);
			
			int owner_id = OwnerLoginDao.fnLoginValidation(login);
			int store_id = OwnerLoginDao.fnGetStoreId(owner_id);
			if(owner_id > 0) {
				sc.setAttribute("loginFlag", 1);
				sc.setAttribute("owner_id", owner_id);
				sc.setAttribute("store_id", store_id);
				List<RetrieveRequests> req_list = RequestsOwnerDao.fnGetRequests(owner_id);
				HttpSession session = req.getSession();
				session.setAttribute("req_list",req_list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("requests.jsp");
				dispatcher.forward(req, res);
			}
			else
				res.sendRedirect("login_owner.html");
		}
	}
	
}
