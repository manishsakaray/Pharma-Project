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

import com.pharma.dao.OfferCustomerDao;
import com.pharma.model.CustomerOffers;

//@WebServlet("/offerscustomer")
public class OffersCustomerServlet extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ServletContext sc = req.getServletContext();
		String area = (String)sc.getAttribute("area");
		ArrayList<CustomerOffers> cust_offers = (ArrayList<CustomerOffers>)OfferCustomerDao.fnRetreveOffers(area);
		HttpSession session = req.getSession();
		if(cust_offers != null) {
			session.setAttribute("cust_offers", cust_offers);
		}else {
			session.setAttribute("cust_offers", null);
			res.getWriter().print("failed");
		}
		res.sendRedirect("./offers.jsp");
//		RequestDispatcher rd = req.getRequestDispatcher("./offers.jsp");
//		rd.forward(req, res);
	}
	
}
