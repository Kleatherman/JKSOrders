package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.WorkPage;



public class FulfillOrderServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Fulfill Order Servlet: doGet");	
		if(req.getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/cart.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Fulfill Order Servlet: doPost");
		Database db = InitDatabase.init();
		String accountNumber = (String)req.getParameter("accountNumber");
		req.setAttribute("accountNumber", accountNumber);
		
		if(req.getParameter("workPage")!=null) {
			WorkPage workModel = new WorkPage();
			EmployeeAccount account = db.getEmployeeAccount(accountNumber);
			String name = account.getFirstName();
			
			if(db.getNotifications(accountNumber).size()!=0) {
				req.setAttribute("notification", db.getNotifications(accountNumber));
			}
			boolean isManager = db.getEmployeeAccount(accountNumber).isManager();
			workModel.setOrders(db.getOrders());
			req.setAttribute("sourceNotifications", db.getSourceNotifications(accountNumber));
			req.setAttribute("isManager", isManager);
			req.setAttribute("employeeNames", db.AllEmployeeNames());
			req.setAttribute("name", name);
			req.setAttribute("accountNumber", accountNumber);
			req.setAttribute("model", workModel);
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}else {
			throw new ServletException("Unknown command");
		}
	}
}
