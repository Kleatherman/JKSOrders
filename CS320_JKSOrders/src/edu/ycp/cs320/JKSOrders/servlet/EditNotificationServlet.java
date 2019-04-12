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
		if(req.getParameter("workPage")!=null) {
			String name = db.getAccount(accountNumber).getFirstName();
			if(db.getNotifications(accountNumber).size()!=0) {
				req.setAttribute("notification", db.getNotifications(accountNumber));
			}
			isManager = db.getEmployeeAccount(accountNumber).isManager();
			req.setAttribute("sourceNotifications", db.getSourceNotifications(accountNumber));
			req.setAttribute("isManager", isManager);
			req.setAttribute("employeeNames", db.AllEmployeeNames());
			req.setAttribute("name", name);
			req.setAttribute("accountNumber", accountNumber);
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
		else if(req.getParameter("update")!=null) {
			Notification notify = new Notification();
			notify.setSourceAccountNumber(accountNumber);
			String message = req.getParameter("message");
			ArrayList<String> destNames = new ArrayList<String>();
			for(EmployeeAccount account : db.getEmployeeAccounts()) {
				if(req.getParameter(account.getFirstName())!=null) {
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
			String editNotifyID = req.getParameter("editNotification");
			notify.setNotificationID(editNotifyID);
			db.updateNotification(notify);
			EditNotificationController editController = new EditNotificationController();
			EditNotificationModel editModel = new EditNotificationModel();
			editController.setModel(editModel);
			editController.setErrorMessage("No notification Selected for editing");
			
			for(Notification note : db.getSourceNotifications(accountNumber)) {
				if(editNotifyID.equals(note.getNotificationID())) {
					editController.setModelNotification(note);
					editController.setErrorMessage(null);
				}
			}
			editController.setModelAllNames(db.AllEmployeeNames());
			editController.setDestinationNames();
			req.setAttribute("model", editModel);
			req.getRequestDispatcher("/_view/editNotification.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}
		
	}

}
