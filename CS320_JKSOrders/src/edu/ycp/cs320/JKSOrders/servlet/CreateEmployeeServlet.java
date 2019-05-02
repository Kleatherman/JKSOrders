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

public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Create Employee Account Servlet: doGet");	
		
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/createEmployee.jsp").forward(req, resp);
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
	
				
				if(req.getParameter("workPage")!= null) {
					 req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
				}
				else if(req.getParameter("createAccount")!= null) {
					
					controller.setLogin(null, req.getParameter("username"));
					controller.setName(req.getParameter("name"));
					controller.setNullValues();
					controller.addAccount(dbase);
					if(req.getParameter("manager") != null) {
						controller.setManager(true);
					}
					else {
						controller.setManager(false);
					}
					
					
					req.getRequestDispatcher("/_view/createEmployee.jsp").forward(req, resp);
				}
	
	
	
	
	
	
	
	
	
	
	}
}
