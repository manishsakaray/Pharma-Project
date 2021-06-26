package com.pharma.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharma.dao.RequestsOwnerDao;
import com.pharma.model.RetrieveRequests;

@WebServlet("/getRequests")
public class UpdateAvailability extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int req_id = Integer.parseInt(req.getParameter("hiddenBool"));
		String str1 = req.getParameter("AvailabilityYes");
		String str2 = req.getParameter("AvailabilityNo");
		int filterIndex = Integer.parseInt(req.getParameter("filterindex"));
		int availability = 2;
		
		if(str2 != null || str1 != null) {
			if(str1 != null && str1.equals("yes"))
				availability = 1;
			else if(str2 != null && str2.equals("no"))
				availability = 0;
		}
		
		RequestsOwnerDao.fnUpdateAvailability(req_id, availability);
		HttpSession session = req.getSession();
		List<RetrieveRequests> req_list = (ArrayList<RetrieveRequests>)session.getAttribute("req_list");
		req_list.remove(filterIndex);
		session.setAttribute("req_list", req_list);
		res.sendRedirect("requests.jsp");
	}
	
}
