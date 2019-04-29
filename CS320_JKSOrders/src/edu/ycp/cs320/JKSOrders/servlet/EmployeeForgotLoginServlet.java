package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.controller.EmployeeForgotLoginController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.EmployeeForgotLogin;


public class EmployeeForgotLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("ForgotLogin Servlet: doGet");
		
		req.getRequestDispatcher("/_view/employeeForgotLoginInfo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Forgot Login: doPost");
		
		String error= null;
		
		String password= null;
		EmployeeForgotLogin model = new EmployeeForgotLogin();
		Database dbase= InitDatabase.init();
		
		// check which button the user pressed
		if (req.getParameter("LoginPage") != null) {
			// call employeeLogin JSP
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		else if (req.getParameter("submit") != null) {
			
		
		
		try {
			String Username = getStringFromParameter(req.getParameter("Username"));
			String Pnum = getStringFromParameter(req.getParameter("Phone"));
			model.setUsername(Username);
			
			
			if (Username == null || Pnum == null ) {
				error = "Please fill both fields";
				System.out.println(Username);
				System.out.println(Pnum);
			}
			else {
				EmployeeForgotLoginController controller = new EmployeeForgotLoginController();
				controller.setModel(model);
				controller.getPassword(dbase);
				password = model.getPassword();
			}
		} catch (Exception e) {
			error = "Invalid String";
		}
		// Add parameters as request attributes
				// this creates attributes named "first" and "second for the response, and grabs the
				// values that were originally assigned to the request attributes, also named "first" and "second"
				// they don't have to be named the same, but in this case, since we are passing them back
				// and forth, it's a good idea
				req.setAttribute("Username", req.getParameter("Username"));
				req.setAttribute("Phone", req.getParameter("Phone"));
				
				// add result objects as attributes
				// this adds the errorMessage text and the result to the response
				req.setAttribute("errorMessage", error);
				req.setAttribute("result", password);
				
				// Forward to view to render the result HTML document
				req.getRequestDispatcher("/_view/employeeForgotLogin.jsp").forward(req, resp);
	}
		else {
			throw new ServletException("Unknown command");
		}
		
		
		
		
	}
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			System.out.println(s);
			return null;
		} else {
			return s;
		}
	}
}


