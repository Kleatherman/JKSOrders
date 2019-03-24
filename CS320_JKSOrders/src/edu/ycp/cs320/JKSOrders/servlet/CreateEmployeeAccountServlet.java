package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.controller.CreateEmployeeAccountController;
import edu.ycp.cs320.JKSOrders.model.CreateEmployeeAccount;


public class CreateEmployeeAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Create Employee Account Servlet: doGet");	
		
		
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/createEmployeeAccount.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Create Employee Account Servlet: doPost");
		

		// create model - model does not persist between requests
		// must recreate it each time a Post comes in
		CreateEmployeeAccount model = new CreateEmployeeAccount();

		// create controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		CreateEmployeeAccountController controller = new CreateEmployeeAccountController();

		// assign model reference to controller so that controller can access model
		controller.setModel(model);

		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/createCustomerAccount.jsp").forward(req, resp);
		
		if(req.getParameter("loginPage")!=null) {
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		req.setAttribute("model", model);

	}
}

