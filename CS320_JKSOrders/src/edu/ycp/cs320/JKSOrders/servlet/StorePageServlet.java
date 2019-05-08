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
import edu.ycp.cs320.JKSOrders.model.ProfilePage;
import edu.ycp.cs320.JKSOrders.model.StorePage;



public class StorePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("StorePage Servlet: doGet");	
		if(req.getSession().getAttribute("accountNumber")==null) {
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
		String accountNumber = (String) req.getSession().getAttribute("accountNumber");
		StorePageController controller= new StorePageController();
		StorePage model= new StorePage();
		controller.setModel(model);
		boolean isCustomer= false;
		boolean isEmployee= false;
		ArrayList<Item> items = db.getVisibleItems();
		Order order = new Order();
		boolean newOrder = false;
		String currentOrderNumber = (String) req.getSession().getAttribute("orderNumber");
		if(currentOrderNumber == null) {
			newOrder = true;
			currentOrderNumber = system.generateNextOrderNumber(db, 'P');
			req.getSession().setAttribute("orderNumber", currentOrderNumber);
			System.out.println("This is in STORE PAGE-------NEW ORDER____ORDER#: "+currentOrderNumber);
			order.setAccountNum(accountNumber);
			order.setOrderType(currentOrderNumber);
		}
		else {
			order = db.getOrder(currentOrderNumber);
		}
		boolean addedItemToCart = false;
		ArrayList<Pair<Item, Integer>> itemsToBeAdded = new ArrayList<Pair<Item,Integer>>();
		for(Item item : items) {
			if(req.getParameter(item.getItemName())!=null){
				System.out.println("------------------------We Are IN THE ADDITEMTOCAR FOR LOOP------------");
				addedItemToCart = true;
				Integer itemQuantity = getIntegerFromParameter(req.getParameter(item.getItemName()+"Quantity"));
				System.out.println("We found this item: "+ item.getItemName() + ". There are "+ itemQuantity+" being added to the order");
				if(itemQuantity!=null)
					itemsToBeAdded.add(new Pair<Item, Integer>(item, itemQuantity));
			}
		}
		if(newOrder&&addedItemToCart) {
			for(Pair<Item, Integer> pair : itemsToBeAdded) {
				System.out.println(pair.getLeft()+" : "+pair.getRight());
				order.addItem(pair.getLeft(), pair.getRight());
			}
			order.setTotalPrice();
			System.out.println("We are adding this order...................................: "+order.getOrderType());
			db.addOrder(order);
		}
		else if(order!=null && addedItemToCart){ 
			for(Pair<Item, Integer> pair : itemsToBeAdded) {
				System.out.println(pair.getLeft()+" : "+pair.getRight());
				order.addItem(pair.getLeft(), pair.getRight());
			}
			order.setTotalPrice();
			db.updateOrder(order);
		}
		
		
		if (req.getParameter("checkOut") != null) {
			req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
		}
		else if(addedItemToCart) {
			CustomerAccount account = (CustomerAccount) db.getAccount(accountNumber);
			StorePage storeModel = new StorePage();
			ArrayList<Item> itemsForStorePage = db.getVisibleItems();
			storeModel.setCustomerAccount(db.getCustomerAccount(accountNumber));
			storeModel.setItems(itemsForStorePage);
			req.setAttribute("model", storeModel);
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
			
		}
		//<COMMENT REDACTED>
		else if (req.getParameter("profilePage") != null) {
			if(accountNumber!=null) {
				controller.loadUpCustomerAccount(db, accountNumber);
				if(db.getOrder(currentOrderNumber)==null) {
					req.getSession().removeAttribute("orderNumber");
				}
				if(model.getCustomerAccount()!=null) {
					ProfilePage profilePageModel = new ProfilePage();
					profilePageModel.setCustomer(true);
					profilePageModel.setEmployee(false);
					CustomerAccount account = db.getCustomerAccount(accountNumber);
					account.setOrders(db.getSourceOrders(accountNumber));
					profilePageModel.setCustomerAccount(account);
					req.setAttribute("model", profilePageModel);
				
				
					
					}
			}
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		}
		else if(req.getParameter("logOut")!=null) {
			if((req.getSession().getAttribute("orderNumber")!=null)) {
				req.getSession().removeAttribute("orderNumber");
			}
			if(addedItemToCart) {
					db.cancelOrder(order.getOrderType());
			}
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		else if(req.getParameter("cart")!=null) {
			boolean itemsAreHere = false;
			Order cartOrder = new Order();
			if(!newOrder) {
				cartOrder = db.getOrder(currentOrderNumber);
			}
			//Order cartOrder = db.getOrder("P0");
			CartModel cartModel = new CartModel();
			cartModel.setAccount(db.getCustomerAccount(accountNumber));
			if(cartOrder!=null) {
				if(cartOrder.getItemList().size()!=0) {
					cartOrder.setItemQuantities();
					itemsAreHere = true;
				}
			}
			cartModel.setOrder(cartOrder);
			req.setAttribute("cartModel", cartModel);
			if(itemsAreHere) {
				req.getRequestDispatcher("/_view/cart.jsp").forward(req, resp);
			}
			else if(!itemsAreHere){
				StorePage storeModel = new StorePage();
				ArrayList<Item> itemsForStore = db.getVisibleItems();
				storeModel.setCustomerAccount(db.getCustomerAccount(accountNumber));
				storeModel.setItems(itemsForStore);
				req.setAttribute("accountNumber", storeModel.getCustomerAccount().getAccountNumber());
				storeModel.setErrorMessage("You have not Items in your cart!");
				req.setAttribute("model", storeModel);
				req.getSession().removeAttribute("orderNumber");
				req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
			}
		}
		else if(req.getParameter("find")!=null) {
			String search = (String)req.getParameter("search");
			System.out.println("----------------------------------"+search);
			ArrayList<Item> itemsFromSearch = db.getSearchItems(search);
			StorePage storeModel = new StorePage();
			storeModel.setCustomerAccount(db.getCustomerAccount(accountNumber));
			storeModel.setItems(itemsFromSearch);
			req.setAttribute("accountNumber", storeModel.getCustomerAccount().getAccountNumber());
			req.setAttribute("model", storeModel);
			req.getSession().removeAttribute("orderNumber");
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}

		
	}
	private Integer getIntegerFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Integer.parseInt(s);
		}
	}
}


