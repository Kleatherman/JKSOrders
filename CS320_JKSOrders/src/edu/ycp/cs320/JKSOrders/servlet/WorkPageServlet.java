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
import edu.ycp.cs320.JKSOrders.controller.EditNotificationController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.controller.WorkPageController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.EditNotificationModel;
import edu.ycp.cs320.JKSOrders.model.WorkPage;



public class WorkPageServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("WorkPage Servlet: doGet");	
		if(req.getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean isManager = false;
		boolean isEmployee = false;
		boolean isCustomer= false;
		Notification notify = new Notification();
		WorkPage model = new WorkPage();
		WorkPageController controller= new WorkPageController();
		controller.setModel(model);
		Database db = InitDatabase.init();
		System.out.println("WorkPage Servlet: doPost");
		String accountNumber = req.getParameter("accountNumber");
		
		if(accountNumber != null) {
			Account account = db.getAccount(accountNumber);
			req.setAttribute("accountNumber", account.getAccountNumber());
			accountNumber = req.getParameter("accountNumber");
			if(db.getNotifications(accountNumber).size()!=0) {
				notify = db.getNotifications(accountNumber).get(0);
				req.setAttribute("notify", notify);
			}
			if(db.getEmployeeAccount(accountNumber)!=null) {
				isManager = db.getEmployeeAccount(accountNumber).isManager();
			}
			req.setAttribute("isManager", isManager);
			req.setAttribute("employeeNames", db.AllEmployeeNames());
		}
		if(req.getParameter("notify")!=null) {
			WorkPage workModel = new WorkPage();
			workModel.setOrders(db.getOrders());
			req.setAttribute("model", workModel);
			notify = new Notification();
			req.setAttribute("sourceNotifications", db.getSourceNotifications(accountNumber));
			notify.setSourceAccountNumber(accountNumber);
			String message = req.getParameter("message");
			ArrayList<String> destNames = new ArrayList<String>();
			for(EmployeeAccount account : db.getEmployeeAccounts()) {
				if(req.getParameter(account.getFirstName()+' '+account.getLastName())!=null) {
					destNames.add(account.getAccountNumber());
				}
			}
			if(destNames.size()!=0) {
				notify.setDestination(destNames);
			}
			if(req.getParameter("urgency")!=null) {
				notify.setUrgency(true);
			}
			else {
				notify.setUrgency(false);
			}
			if(message!=null) {
				notify.setMessage(message);
			}
			db.addNotification(notify);
			req.setAttribute("message", message);
			if(db.getNotifications(accountNumber).size()!=0) {
				req.setAttribute("notification", db.getNotifications(accountNumber));
			}
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
		
		// check which button the user pressed
		else if (req.getParameter("profilePage") != null) {
			if (accountNumber!=null) {
				controller.loadUpEmployeeAccount(db, accountNumber);
				if(model.getEmployeeAccount()!= null) {
					isEmployee= true; 
					req.setAttribute("Anumber", model.getEmployeeAccount().getAccountNumber());
					req.setAttribute("Username", model.getEmployeeAccount().getLogin().getUserName());
					req.setAttribute("password", model.getEmployeeAccount().getLogin().getPassword());
					req.setAttribute("Name", model.getEmployeeAccount().getFirstName());
					req.setAttribute("isEmployee", isEmployee);
					req.setAttribute("isCustomer", isCustomer);
				}
			}
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		}
		else if (req.getParameter("employeeLogin") != null || accountNumber==null) {
			// call addNumbers JSP
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		else if(req.getParameter("fulfillOrder")!=null) {
			req.getRequestDispatcher("/_view/fulfillOrder.jsp").forward(req, resp);
		}
		else if (req.getParameter("editNotification")!= null) {
			EditNotificationController editController = new EditNotificationController();
			EditNotificationModel editModel = new EditNotificationModel();
			editController.setModel(editModel);
			editController.setErrorMessage("No notification Selected for editing");
			String editNotifyID = req.getParameter("editNotification");
			System.out.println("Source Notification ID: "+ editNotifyID);
			ArrayList<Notification> sourceNotifications = db.getSourceNotifications(accountNumber);
			for(Notification note : sourceNotifications) {
				System.out.println("We are looking for the notification!!");
				if(editNotifyID.equals(note.getNotificationID())) {
					System.out.println("We found the notification! it has ID#:" + note.getNotificationID());
					editController.setModelNotification(note);
					editController.setErrorMessage(null);
				}
			}
			editController.setModelAllNames(db.AllEmployeeNames());
			editController.setDestinationNames(db);
			req.setAttribute("model", editModel);
			req.getRequestDispatcher("/_view/editNotification.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command from work page");
		}
		
	}

}
