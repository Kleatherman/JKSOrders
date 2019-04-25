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
import edu.ycp.cs320.JKSOrders.classes.Pair;
import edu.ycp.cs320.JKSOrders.controller.CartController;
import edu.ycp.cs320.JKSOrders.controller.StorePageController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.CartModel;
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
		SystemController system = new SystemController();
		String accountNumber = req.getParameter("accountNumber");
		StorePageController controller= new StorePageController();
		StorePage model= new StorePage();
		controller.setModel(model);
		boolean isCustomer= false;
		boolean isEmployee= false;
		ArrayList<Item> items = db.getVisibleItems();
		Order order = new Order();
		String currentOrderNumber = (String) req.getSession().getAttribute("orderNumber");
		boolean addedItemToCart = false;
		//If there is no orderNumber for this session, this is a brand new order being created so we need to
			//1: Get a new order number for the order
			//2: set the account number
			//3: add the item to the order
			//4: calculate the total price
			//5: submit the order to be added
		ArrayList<Pair<Item, String>> itemsToBeAdded = new ArrayList<Pair<Item,String>>();
		for(Item item : items) {
			if(req.getParameter(item.getItemName())!=null){
				addedItemToCart = true;
				String itemQuantity = req.getParameter(item.getItemName()+"Quantity");
				itemsToBeAdded.add(new Pair<Item, String>(item, itemQuantity));
			}
		}
		if(currentOrderNumber==null&& addedItemToCart==true) {
			currentOrderNumber = system.generateNextOrderNumber(db, 'P');
			req.getSession().setAttribute("orderNumber", currentOrderNumber);
			order.setAccountNum(accountNumber);
			order.setOrderType(currentOrderNumber);
			for(Pair<Item, String> pair : itemsToBeAdded) {
				order.addItem(pair.getLeft(), Integer.parseInt(pair.getRight()));
			}
			order.setTotalPrice();
			db.addOrder(order);
		}
		
		//Else it is an order that has already been created so we need to
			//1: pull that order from db
			//2: add the item to that order
			//3: Calculate total price
			//4: submit that order to be updated
		else if(currentOrderNumber!=null && addedItemToCart==true){ 
			order = db.getOrder(currentOrderNumber);
			for(Pair<Item, String> pair : itemsToBeAdded) {
				order.addItem(pair.getLeft(), Integer.parseInt(pair.getRight()));
			}
			order.setTotalPrice();
			db.updateOrder(order);
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
			req.getSession().setAttribute("orderNumber", null);
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		else if(req.getParameter("cart")!=null) {
			//Order cartOrder = db.getOrder(currentOrderNumber);
			Order cartOrder = db.getOrder("P0");
			CartModel cartModel = new CartModel();
			cartModel.setAccount(db.getCustomerAccount(accountNumber));
			cartOrder.setItemQuantities();
			cartModel.setOrder(cartOrder);
			req.setAttribute("cartModel", cartModel);
			req.setAttribute("accountNumber", accountNumber);
			req.getRequestDispatcher("/_view/cart.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}

		
	}
}
