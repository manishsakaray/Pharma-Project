package com.pharma.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index")
public class SessionCreator extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res){
		ServletContext sc = req.getServletContext();
		if(sc.getAttribute("loginFlag") == null) {
			sc.setAttribute("loginFlag", 0);
		}
	}
	
}
