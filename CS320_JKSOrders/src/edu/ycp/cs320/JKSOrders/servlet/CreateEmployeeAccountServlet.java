package edu.ycp.cs320.JKSOrders.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.controller.CreateEmployeeAccountController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.CreateEmployeeAccount;



public class CreateEmployeeAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Create Employee Account Servlet: doGet");	
		
		System.out.println("Do we get here");
		
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
		
		Database dbase = InitDatabase.init();
		boolean success= false;

		// call JSP to generate empty form
		
		
		if(req.getParameter("loginPage")!=null) {
			
			System.out.println("Do we get here post");
			
			 req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		else if(req.getParameter("createAccount")!=null) {
			
			System.out.println("Do we get here");
			
		try {
			if(dbase.getEmployeeAccount(req.getParameter("username"))!= null) {
				if(dbase.getEmployeeAccount(req.getParameter("username")).getLogin().getUserName()!=null && dbase.getEmployeeAccount(req.getParameter("username")).getLogin().getPassword()=="") {
					controller.setLogin(req.getParameter("password"), req.getParameter("username"));
					controller.setPhoneNumber(req.getParameter("number"));
					controller.setEmail(req.getParameter("email"));
					controller.addAccount(dbase);
					success= true;
				}
				else {
					String error = "Account not found";
				}
			}
			else {
				String error = "Account not found";
			}
		}catch(Exception e) {
			String error = "Account not found";
		}
		finally {
			if(success) {
				req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/_view/createEmployeeAccount.jsp").forward(req, resp);
			}
				
		}
			
			
		}
		 req.setAttribute("model", model);

	}
}

