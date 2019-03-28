package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;



public class WorkPageServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("WorkPage Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Notification notify = new Notification();
		SystemController system = new SystemController();
		Database db = InitDatabase.init();
		System.out.println("WorkPage Servlet: doPost");
		EmployeeAccount account = (EmployeeAccount) system.getEmployeeAccount(req.getParameter("accountNumber"));
		req.setAttribute("accountNumber", account.getAccountNumber());
		if(req.getParameter("notify")!=null) {
			String message = req.getParameter("message");
			if(req.getAttribute("urgent")!=null) {
				notify.setUrgency(true);
			}
			else {
				notify.setUrgency(false);
			}
			notify.setMessage(message);
			db.addNotification(notify);
			System.out.println("We are about to go back to workPage");
			req.setAttribute("message", message);
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
			System.out.println("We went back to workPage");
		}
		
		// check which button the user pressed
		else if (req.getParameter("profilePage") != null) {
			// call addNumbers JSP
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		}
		else if (req.getParameter("employeeLogin") != null) {
			// call addNumbers JSP
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}
		
	}

}
