package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class StorePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("StorePage Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("StorePage Servlet: doPost");
		
		// check which button the user pressed
		if (req.getParameter("checkOut") != null) {
			// call addNumbers JSP
			req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
		}
		else if (req.getParameter("profilePage") != null) {
			// call multiplyNumbers JSP
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}
		
	}
}
