package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;



public class StorePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("StorePage Servlet: doGet");	
			
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		System.out.println("StorePage Servlet: doPost");
		SystemController system = new SystemController();
		Database db = InitDatabase.init();
		String accountNumber = req.getParameter("accountNumber");
		if(accountNumber == null) {
			CustomerAccount account = (CustomerAccount) db.getAccount(accountNumber);
			System.out.println("Work page servlet right before setting account number:"+account.getAccountNumber());
			req.setAttribute("accountNumber", account.getAccountNumber());
			req.setAttribute("notify", db.getNotifications(account.getAccountNumber()).get(0));
		}
		// check which button the user pressed
		if (req.getParameter("checkOut") != null) {
			// call addNumbers JSP
			req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
		}
		else if (req.getParameter("profilePage") != null) {
			// call multiplyNumbers JSP
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		}
		else if(req.getParameter("logOut")!=null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}

		
	}
}
