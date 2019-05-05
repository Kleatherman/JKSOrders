package edu.ycp.cs320.JKSOrders.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.controller.ProfilePageController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.ProfilePage;
import edu.ycp.cs320.JKSOrders.model.ViewOrder;
import edu.ycp.cs320.JKSOrders.model.StorePage;
import edu.ycp.cs320.JKSOrders.model.WorkPage;


public class ProfilePageServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("ProfilePage Servlet: doGet");	

		if(req.getSession().getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		}
		
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
		String accountNumber = (String) req.getSession().getAttribute("accountNumber");
		Account account = null;
		if(accountNumber != null) {
			account =  db.getAccount(accountNumber);
			System.out.println("Work page servlet right before setting account number:"+account.getAccountNumber());
			req.setAttribute("accountNumber", account.getAccountNumber());
			ArrayList<Notification> notify = db.getNotifications(accountNumber);
			if(notify.size()!=0) {
				isManager = db.getEmployeeAccount(accountNumber).isManager();
			}	
		}
		// check which button the user pressed
		if (req.getParameter("storePage") != null) {
			// call addNumbers JSP
			StorePage storeModel = new StorePage();
			ArrayList<Item> items = db.getVisibleItems();
			storeModel.setCustomerAccount(db.getCustomerAccount(account.getAccountNumber()));
			storeModel.setItems(items);
			req.setAttribute("model", storeModel);
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}
		else if (req.getParameter("workPage") != null) {

			WorkPage workModel = new WorkPage();
			workModel.setReceivedNotifications(db.getNotifications(accountNumber));
			workModel.setManager(isManager);
			workModel.setOrders(db.getAllPickUpOrders());
			workModel.setAccountNumber(accountNumber);
			workModel.setEmployeeNames(db.AllEmployeeNames());
			workModel.setOrders(db.getAllPickUpOrders());
			workModel.setSourceNotifications( db.getSourceNotifications(accountNumber));
			req.setAttribute("model", workModel);
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
		else if(req.getParameter("viewOrder") !=null) {
			ViewOrder viewOrderModel = new ViewOrder(); 
			viewOrderModel.setOrder(db.getOrder(req.getParameter("sourceOrders")));
			viewOrderModel.setAccount(db.getCustomerAccount(accountNumber));
			req.setAttribute("viewOrderModel", viewOrderModel);
			req.getRequestDispatcher("/_view/viewOrder.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}
		
	}
	
}
