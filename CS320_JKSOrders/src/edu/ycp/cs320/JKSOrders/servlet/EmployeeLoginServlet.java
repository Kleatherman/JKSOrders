package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.controller.EmployeeLoginController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;


public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("EmployeeLogin Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Database db = InitDatabase.init();
		System.out.println("EmployeeLogin Servlet: doPost");
		
		// create model - model does not persist between requests
		// must recreate it each time a Post comes in
		LoginInfo model = new LoginInfo();

		// create controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		EmployeeLoginController controller = new EmployeeLoginController();

		// assign model reference to controller so that controller can access model
		controller.setModel(model);

		
		SystemController system = new SystemController();

		// holds the error message text, if there is any
		String errorMessage = null;

		// result of calculation goes here
		
		// decode POSTed form parameters and dispatch to controller
		try {
			controller.setUserName(req.getParameter("username"));
			controller.setPassword(req.getParameter("pin"));
			
			
			
			if (req.getParameter("createEmployeeAccount")!=null) {
				System.out.println("We're headed to employee account JSP");
				req.getRequestDispatcher("/_view/createEmployeeAccount.jsp").forward(req, resp);
			}
			else if(req.getParameter("forgot")!=null) {
				req.getRequestDispatcher("/_view/employeeForgotLogin.jsp").forward(req, resp);
			}
			else if(!system.verifyEmployeeLoginInfo(model, db.getEmployeeLoginInfo())) {
				req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
			}
			else if (req.getParameter("submit")!=null) {
				String name = system.getEmployeeAccount(model.getUserName()).getName();
				Notification notify = db.getNotifications(system.getEmployeeAccount(model.getUserName()).getAccountNumber()).get(0);
				req.setAttribute("notify", notify);
				req.setAttribute("name", name);
				req.setAttribute("AccountNumber", system.getEmployeeAccount(model.getUserName()).getAccountNumber());
				req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
			}

		}catch (NumberFormatException e) {
			errorMessage = "Invalid input";
		}
		
		// Add parameters as request attributes
		// this creates attributes named "first" and "second for the response, and grabs the
		// values that were originally assigned to the request attributes, also named "first" and "second"
		// they don't have to be named the same, but in this case, since we are passing them back
		// and forth, it's a good idea
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		
		// Forward to view to render the result HTML document
		



	}
}

