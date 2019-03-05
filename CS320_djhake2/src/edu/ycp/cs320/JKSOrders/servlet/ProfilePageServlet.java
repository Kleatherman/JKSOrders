package edu.ycp.cs320.JKSOrders.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProfilePageServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("ProfilePage Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("ProfilePage Servlet: doPost");
		
		// check which button the user pressed
		if (req.getParameter("StorePage") != null) {
			// call addNumbers JSP
			req.getRequestDispatcher("/_view/StorePage.jsp").forward(req, resp);
		}
		else if (req.getParameter("WorkPage") != null) {
			// call addNumbers JSP
			req.getRequestDispatcher("/_view/WorkPage.jsp").forward(req, resp);
		}
		
		else {
			throw new ServletException("Unknown command");
		}
		
	}
	
}
