package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateCustomerAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Create Customer Account Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/createCustomerAccount.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Create Customer Account Servlet: doPost");
		if(req.getParameter("loginPage")!=null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}

	}
}

