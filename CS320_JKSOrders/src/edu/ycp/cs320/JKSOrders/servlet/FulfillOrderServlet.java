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
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.FulfillOrderModel;
import edu.ycp.cs320.JKSOrders.model.WorkPage;



public class FulfillOrderServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Fulfill Order Servlet: doGet");	
		if(req.getSession().getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/fulfillOrder.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Fulfill Order Servlet: doPost");
		Database db = InitDatabase.init();
		String accountNumber = (String)req.getSession().getAttribute("accountNumber");
		if(req.getParameter("fulfilledOrder")!=null) {
			String orderNumber = req.getParameter("orderNumber");
			String customerAccountNumber = req.getParameter("customerAccountNumber");
			Order order = db.getOrder(orderNumber);
			CustomerAccount customer = db.getCustomerAccount(customerAccountNumber);
			order.setComplete(true);
			db.updateOrder(order);
			order = db.getOrder(order.getOrderType());			
			FulfillOrderModel fulfillModel = new FulfillOrderModel();
			fulfillModel.setCar(customer.getPickUpInfo().getCar());
			fulfillModel.setCustomer(customer);
			fulfillModel.setOrder(order);
			
			req.setAttribute("model", fulfillModel);
			req.getRequestDispatcher("/_view/fulfillOrder.jsp").forward(req, resp);
		}
		else if(req.getParameter("workPage")!=null) {
			WorkPage workModel = new WorkPage();
			workModel.setOrders(db.getAllPickUpOrders());
			req.setAttribute("model", workModel);
			String name = db.getAccount(accountNumber).getFirstName();
			if(db.getNotifications(accountNumber).size()!=0) {
				workModel.setReceivedNotifications(db.getNotifications(accountNumber));
			}
			boolean isManager = db.getEmployeeAccount(accountNumber).isManager();
			workModel.setOrders(db.getAllPickUpOrders());
			workModel.setSourceNotifications(db.getSourceNotifications(accountNumber));
			workModel.setManager(isManager);
			workModel.setEmployeeNames(db.AllEmployeeNames());
			workModel.setItems(db.getCatalog().returnItemList());
			req.setAttribute("name", name);
			workModel.setAccountNumber(accountNumber);
			req.setAttribute("model", workModel);
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}else {
			throw new ServletException("Unknown command");
		}
	}
}
