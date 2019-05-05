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
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.controller.EditNotificationController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.controller.WorkPageController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.EditNotificationModel;
import edu.ycp.cs320.JKSOrders.model.FulfillOrderModel;
import edu.ycp.cs320.JKSOrders.model.ProfilePage;
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
			model.setAccountNumber(account.getAccountNumber());
			accountNumber = req.getParameter("accountNumber");
			req.setAttribute("accountNumber", accountNumber);
			if(db.getNotifications(accountNumber).size()!=0) {
				notify = db.getNotifications(accountNumber).get(0);
				model.setNotification(notify);
				
			}
			if(db.getEmployeeAccount(accountNumber)!=null) {
				isManager = db.getEmployeeAccount(accountNumber).isManager();
			}
			req.setAttribute("isManager", isManager);
			model.setManager(isManager);
			model.setEmployeeNames(db.AllEmployeeNames());
		}
		if(req.getParameter("notify")!=null) {
			model.setOrders(db.getAllPickUpOrders());
			model.setSourceNotifications( db.getSourceNotifications(accountNumber));
			
			notify = new Notification();
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
			model.setMessage(message);
			if(db.getNotifications(accountNumber).size()!=0) {
				model.setReceivedNotifications(db.getNotifications(accountNumber));
			}
			req.setAttribute("model", model);
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
		
		// check which button the user pressed
		else if (req.getParameter("profilePage") != null) {
			if (accountNumber!=null) {
				controller.loadUpEmployeeAccount(db, accountNumber);
				if(model.getEmployeeAccount()!= null) {
					
					ProfilePage profilePage = new ProfilePage();
									
					profilePage.setEmployeeAccount(db.getEmployeeAccount(accountNumber));
					profilePage.setCustomer(false);
					profilePage.setEmployee(true);
					req.setAttribute("model", profilePage );
				
				}
			}
			
			
			
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		}
		else if (req.getParameter("employeeLogin") != null || accountNumber==null) {
			
		req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		else if(req.getParameter("fulfillOrder")!=null) {
			String orderID = req.getParameter("editOrder");
			Order order = db.getOrder(orderID);
			FulfillOrderModel fulfillOrder = new FulfillOrderModel();
			fulfillOrder.setOrder(order);
			fulfillOrder.setCar(db.getCustomerAccount(order.getAccountNum()).getPickUpInfo().getCar());
			fulfillOrder.setCustomer(db.getCustomerAccount(order.getAccountNum()));
			req.setAttribute("model", fulfillOrder);
			req.getRequestDispatcher("/_view/fulfillOrder.jsp").forward(req, resp);
		}
		else if(req.getParameter("createEmployee")!=null) {
			req.setAttribute("accountNumber", accountNumber);
			req.getRequestDispatcher("/_view/createEmployee.jsp").forward(req, resp);
		}
		else if (req.getParameter("editNotification")!= null) {
			EditNotificationController editController = new EditNotificationController();
			EditNotificationModel editModel = new EditNotificationModel();
			editController.setModel(editModel);
			editController.setErrorMessage("No notification Selected for editing");
			String editNotifyID = req.getParameter("editNotification");
			ArrayList<Notification> sourceNotifications = db.getSourceNotifications(accountNumber);
			for(Notification note : sourceNotifications) {
				if(editNotifyID.equals(note.getNotificationID())) {
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
