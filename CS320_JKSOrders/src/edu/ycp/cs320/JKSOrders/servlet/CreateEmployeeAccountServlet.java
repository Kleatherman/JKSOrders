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
				System.out.println("We made it into the first if before a null pointer exception was thrown");
				
				if(dbase.getEmployeeAccount(req.getParameter("username")).getLogin().getUserName()!=null && dbase.getEmployeeAccount(req.getParameter("username")).getLogin().getPassword().equals(" ")) {
					controller.loadInAccount(dbase.getEmployeeAccount(req.getParameter("username")));
					System.out.println("We are inside the first if statement in createEmployeeAccount");
					controller.setLogin(req.getParameter("password"), req.getParameter("username"));
					System.out.println("We are inside the first if statement in 1");
					controller.setPhoneNumber(req.getParameter("number"));
					System.out.println("We are inside the first if statement in 2");
					controller.setLastName(req.getParameter("lastname"));
					System.out.println("We are inside the first if statement in 3");
					controller.editAccount(dbase);
					System.out.println("We are inside the first if statement in 4");
					success= true;

					System.out.println("We are inside the first if statement in 5");
				}
				else if(dbase.getEmployeeAccount(req.getParameter("username")).getLogin().getPassword().equals(" ")) {
					String error = "Account not found";
					System.out.println("Error account not found but check 1 passed, Username error");
				}
				else if(dbase.getEmployeeAccount(req.getParameter("username")).getLogin().getUserName()!=null) {
					String error = "Account not found";
					System.out.println("Error account not found but check 1 passed, password error");
				}
				else {
					String error = "Account not found";
					System.out.println("Error account not found but check 1 passed, total error");
				}
			}
			else {
				String error = "Account not found";
				System.out.println("Error account not found but try passed");
			}
		}catch(Exception e) {
			String error = "Account not found";
			System.out.println("Error account not found nothing passed");
			System.out.println(e);
		}
		finally {
			if(success==true) {
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

