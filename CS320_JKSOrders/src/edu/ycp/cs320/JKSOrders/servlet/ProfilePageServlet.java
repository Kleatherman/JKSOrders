package edu.ycp.cs320.JKSOrders.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.controller.ProfilePageController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.ProfilePage;


public class ProfilePageServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("ProfilePage Servlet: doGet");	

		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean isManager = false;
		System.out.println("ProfilePage Servlet: doPost");
		Database db = InitDatabase.init();
		ProfilePageController controller= new ProfilePageController();
		ProfilePage model= new ProfilePage();
		controller.setModel(model);
		String accountNumber = req.getParameter("accountNumber");
		if(accountNumber != null) {
			Account account =  db.getAccount(accountNumber);
			System.out.println("Work page servlet right before setting account number:"+account.getAccountNumber());
			req.setAttribute("accountNumber", account.getAccountNumber());
			ArrayList<Notification> notify = db.getNotifications(accountNumber);
			if(notify.size()!=0) {
				req.setAttribute("notification", notify);
				isManager = db.getEmployeeAccount(accountNumber).isManager();
				req.setAttribute("isManager", isManager);
				req.setAttribute("employeeNames",db.AllEmployeeNames());
			}	
		}
		// check which button the user pressed
		if (req.getParameter("storePage") != null) {
			// call addNumbers JSP
			ArrayList<Item> items = new ArrayList<Item>();
			items = db.getVisibleItems();
			System.out.println("StorePage: "+ items.get(0).getDescription());
			req.setAttribute("items", items);
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}
		else if (req.getParameter("workPage") != null) {
			// call addNumbers JSP
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
		
		else {
			throw new ServletException("Unknown command");
		}
		
	}
	
}
