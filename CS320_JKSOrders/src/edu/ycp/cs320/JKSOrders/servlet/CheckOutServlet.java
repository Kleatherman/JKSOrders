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
import edu.ycp.cs320.JKSOrders.controller.CheckOutController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.CartModel;
import edu.ycp.cs320.JKSOrders.model.CheckOut;
import edu.ycp.cs320.JKSOrders.model.StorePage;

public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("CheckOut Servlet: doGet");
		if(req.getSession().getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("CheckOut Servlet: doPost");
		Database db = InitDatabase.init();

		String accountNumber = (String) req.getSession().getAttribute("accountNumber");
		if(accountNumber != null) {
			Account account = db.getAccount(accountNumber);
			System.out.println("Work page servlet right before setting account number:"+account.getAccountNumber());
			
		}

		// create model - model does not persist between requests
		// must recreate it each time a Post comes in
		CheckOut model = new CheckOut();

		// create controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		CheckOutController controller = new CheckOutController();

		// assign model reference to controller so that controller can access model
		controller.setModel(model);

		// Forward to view to render the result HTML document
		if (req.getParameter("thankYou") != null) {
			req.getRequestDispatcher("/_view/thankYou.jsp").forward(req, resp);
		
		} else if (req.getParameter("cancel") != null) {
			StorePage storeModel = new StorePage();
			ArrayList<Item> items = db.getVisibleItems();
			storeModel.setCustomerAccount(db.getCustomerAccount(accountNumber));
			storeModel.setItems(items);
			req.setAttribute("model", storeModel);
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}
		else if (req.getParameter("cart") != null) {
			Order cartOrder = db.getOrder((String)req.getSession().getAttribute("orderNumber"));
			//Order cartOrder = db.getOrder("P0");
			boolean itemsAreHere = false;
			CartModel cartModel = new CartModel();
			cartModel.setAccount(db.getCustomerAccount(accountNumber));
			if(cartOrder!=null) {
				itemsAreHere = true;
				cartOrder.setItemQuantities();
			}
			cartModel.setOrder(cartOrder);
			req.setAttribute("cartModel", cartModel);
			if(itemsAreHere) {
				req.getRequestDispatcher("/_view/cart.jsp").forward(req, resp);
			}
			else if(!itemsAreHere) {
				req.setAttribute("errorMessage", "You have not Items in your cart!");
				req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
			}
		}
	}
}
