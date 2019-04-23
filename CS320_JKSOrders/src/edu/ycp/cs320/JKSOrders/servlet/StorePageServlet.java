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
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.controller.StorePageController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.StorePage;



public class StorePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("StorePage Servlet: doGet");	
		if(req.getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		System.out.println("StorePage Servlet: doPost");
		Database db = InitDatabase.init();
		String accountNumber = req.getParameter("accountNumber");
		StorePageController controller= new StorePageController();
		StorePage model= new StorePage();
		controller.setModel(model);
		boolean isCustomer= false;
		boolean isEmployee= false;
		ArrayList<Item> items = db.getVisibleItems();
		Order order = new Order();
		boolean addedItemToCart = false;
		for(Item item : items) {
			if(req.getParameter(item.getItemName())!=null){
				addedItemToCart = true;
				System.out.println(item.getItemName()+"We made it in!!!");
				String itemQuantity = req.getParameter(item.getItemName()+"Quantity");
				System.out.println(itemQuantity);
				
				order.addItem(item, Integer.parseInt(itemQuantity));
				order.setAccountNum(accountNumber);
				//I need to find a way to determine if this order is a new order or one that is being worked on. I'm thinking this might be able to be done in sessionInfo. What
				//could work is that the order number is loaded into sessionInfo and then unloaded once checkOut is completed. Up above I can use an if statement to determine 
				//if the order is complete.
			}
		}
		if(accountNumber != null) {
			Account account =  db.getAccount(accountNumber);
			req.setAttribute("accountNumber", account.getAccountNumber());
			accountNumber = req.getParameter("accountNumber");
		}
		if (req.getParameter("checkOut") != null) {
			req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
		}
		else if(addedItemToCart) {
			CustomerAccount account = (CustomerAccount) db.getAccount(accountNumber);
			ArrayList<Item> item = db.getVisibleItems();
			req.setAttribute("accountNumber", account.getAccountNumber());
			req.setAttribute("items", item);
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}
		else if (req.getParameter("profilePage") != null) {
			if(accountNumber!=null) {
				controller.loadUpCustomerAccount(db, accountNumber);
				if(model.getCustomerAccount()!=null) {
					isCustomer= true;
					req.setAttribute("Anumber", model.getCustomerAccount().getAccountNumber());
					req.setAttribute("Username", model.getCustomerAccount().getLogin().getUserName());
					req.setAttribute("password", model.getCustomerAccount().getLogin().getPassword());
					req.setAttribute("Name", model.getCustomerAccount().getFirstName());
					req.setAttribute("isCustomer", isCustomer);
					req.setAttribute("isEmployee", isEmployee);
					}
			}
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		}
		else if(req.getParameter("logOut")!=null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		else if(req.getParameter("cart")!=null) {
			req.setAttribute("accountNumber", accountNumber);
			req.getRequestDispatcher("/_view/cart.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}

		
	}
}
