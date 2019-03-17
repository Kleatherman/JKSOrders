package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Index Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Index Servlet: doPost");
		
		// Forward to view to render the result HTML document
		if(req.getParameter("customer")!=null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		else if(req.getParameter("employee")!=null) {
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
	}
}
