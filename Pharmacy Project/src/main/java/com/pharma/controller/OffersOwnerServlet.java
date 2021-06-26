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

import com.pharma.dao.OffersOwnerDao;
import com.pharma.model.Product;
import com.pharma.model.RetrieveOffers;

//@WebServlet("/offersowner")
public class OffersOwnerServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		try {
		String name = req.getParameter("offersproductname");
		int cost = Integer.parseInt(req.getParameter("offersproductcost"));
		int discount = Integer.parseInt(req.getParameter("offersproductdiscount"));
		
		if(discount <= 100) {
			Product product = new Product(name,cost,discount);
			int prod_id = OffersOwnerDao.insertOffer(product);
			
			if(prod_id > 0) {
				ServletContext sc = req.getServletContext();
				int store_id = (int)sc.getAttribute("store_id");
				boolean flag = OffersOwnerDao.insertIntoContainsRelation(store_id, prod_id);
				if(flag) {
					ArrayList<RetrieveOffers> owner_offers = OffersOwnerDao.fnRetreveStoreOffers(store_id);
					HttpSession session = req.getSession();
					if(!owner_offers.isEmpty()) {
						session.setAttribute("owner_offers", owner_offers);
					}else {
						session.setAttribute("owner_offers", null);
					}
					RequestDispatcher dispatcher = req.getRequestDispatcher("offers_owner.jsp");
					dispatcher.forward(req, res);
				}else {
					res.getWriter().print("database error!! we are currently working on it");
				}
			}
		}else {
			res.sendRedirect("offers_owner.jsp");
		}
		
		}catch(Exception e) {
			res.sendRedirect("offers_owner.jsp");
		}
	}
	
}
