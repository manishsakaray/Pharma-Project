package com.pharma.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		ServletContext sc = req.getServletContext();
		String searchValue = req.getParameter("homesearchbox");
		
		if(searchValue == "") {
			res.sendRedirect("index.html");
		}else {
			if(sc.getAttribute("loginFlag") == null || sc.getAttribute("loginFlag") == (Object)0) {
				res.sendRedirect("login.html");
			}else {
				RequestDispatcher rs = req.getRequestDispatcher("/compute"); 
				rs.forward(req, res);
			}
		}
	}
}
