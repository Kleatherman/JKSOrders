package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.controller.CustomerForgotLoginController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.model.CustomerForgotLogin;


public class CustomerForgotLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("CustomerForgotLogin Servlet: doGet");
		
		req.getRequestDispatcher("/_view/customerForgotLogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("CustomerForgotLogin Servlet: doPost");
		// check button the user pressed
		
		String error= null;
		
		String password= null;
		SystemController scontrol = new SystemController();
		CustomerForgotLoginController controller= new CustomerForgotLoginController(); 
		CustomerForgotLogin model = new CustomerForgotLogin();
		
		
		if (req.getParameter("LoginPage") != null) {
			// call customerLogin JSP
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		else if(req.getParameter("submit") !=null) {
			
			try {
				String username= getStringFromParameter(req.getParameter("Username"));
				String phone= getStringFromParameter(req.getParameter("Phone"));
				model.setUsername(username);
				
				if(username==null || phone== null) {
					error= "Please fill in both fields";
				}
				
				controller.setModel(model);
				controller.getPassword(scontrol);
				password= model.getPassword();
				
			}catch(Exception e){
				error= "Something went wrong";
			}
			
			req.setAttribute("Username", req.getParameter("Username"));
			req.setAttribute("Phone", req.getParameter("Phone"));
			req.setAttribute("errorMessage", error);
			req.setAttribute("result", password);
			
			req.getRequestDispatcher("/_view/customerForgotLogin.jsp").forward(req, resp);
			
		}
		else {
			throw new ServletException("Unknown command");
		}
	}

	private String getStringFromParameter(String s) {
		if(s== null || s == "") {
			return null;
			
		}
		return s;
	}
}
