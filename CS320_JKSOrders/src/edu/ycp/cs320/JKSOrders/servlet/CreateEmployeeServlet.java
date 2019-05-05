package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.controller.CreateEmployeeAccountController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.CreateEmployeeAccount;
import edu.ycp.cs320.JKSOrders.model.WorkPage;

public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("CreateEmployee Servlet: doGet");	
		if(req.getSession().getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/createEmployee.jsp").forward(req, resp);
		}
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
					WorkPage workModel = new WorkPage();
					String accountNumber = (String) req.getSession().getAttribute("accountNumber");
					EmployeeAccount account = dbase.getEmployeeAccount(accountNumber);
					String name = account.getFirstName();
					
					if(dbase.getNotifications(accountNumber).size()!=0) {
						workModel.setReceivedNotifications(dbase.getNotifications(accountNumber));
					}
					boolean isManager = dbase.getEmployeeAccount(accountNumber).isManager();
					workModel.setOrders(dbase.getAllPickUpOrders());
					workModel.setSourceNotifications(dbase.getSourceNotifications(accountNumber));
					workModel.setManager(isManager);
					workModel.setEmployeeNames(dbase.AllEmployeeNames());
					req.setAttribute("name", name);
					workModel.setAccountNumber(accountNumber);
					req.setAttribute("model", workModel);
					
					 req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
				}
				else if(req.getParameter("createAccount")!= null) {
					
					controller.setLogin (" ", req.getParameter("username"));
					controller.setName(req.getParameter("name"));
					controller.setNullValues();
					if(req.getParameter("manager") != null) {
						controller.setManager(true);
					}
					else {
						controller.setManager(false);
					}
					controller.addAccount(dbase);
					
					
					req.getRequestDispatcher("/_view/createEmployee.jsp").forward(req, resp);
				}
	
	
	
	
	
	
	
	
	
	
	}
}
