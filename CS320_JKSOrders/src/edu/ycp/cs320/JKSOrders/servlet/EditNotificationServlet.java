package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.controller.WorkPageController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.WorkPage;



public class EditNotificationServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Edit Notification Servlet: doGet");	
		if(req.getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/editNotification.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Database db = InitDatabase.init();
		System.out.println("Edit Notification Servlet: doPost");
		String accountNumber = req.getParameter("accountNumber");
		req.setAttribute("accountNumber", accountNumber);
		boolean isManager = false;
		if(accountNumber != null) {
			Account account = db.getAccount(accountNumber);
			req.setAttribute("accountNumber", account.getAccountNumber());
			accountNumber = req.getParameter("accountNumber");
			if(db.getNotifications(accountNumber).size()!=0) {
				req.setAttribute("notify", db.getNotifications(accountNumber).get(0));
			}
			if(db.getEmployeeAccount(accountNumber)!=null) {
				isManager = db.getEmployeeAccount(accountNumber).isManager();
			}
			req.setAttribute("isManager", isManager);
			req.setAttribute("employeeNames", db.AllEmployeeNames());
		}
		if(req.getParameter("workPage")!=null) {
			String name = db.getAccount(accountNumber).getName();
			if(db.getNotifications(accountNumber).size()!=0) {
				req.setAttribute("notification", db.getNotifications(accountNumber));
			}
			req.setAttribute("sourceNotifications", db.getSourceNotifications(accountNumber));
			req.setAttribute("isManager", isManager);
			req.setAttribute("employeeNames", db.AllEmployeeNames());
			req.setAttribute("name", name);
			req.setAttribute("accountNumber", accountNumber);
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
		else if(req.getAttribute("update")!=null) {
			req.getRequestDispatcher("/_view/editNotification.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}
		
	}

}
