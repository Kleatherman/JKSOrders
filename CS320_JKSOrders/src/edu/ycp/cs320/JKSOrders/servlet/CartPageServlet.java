package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.StorePage;



public class CartPageServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Cart Servlet: doGet");	
		if(req.getSession().getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/cart.jsp").forward(req, resp);
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Database db = InitDatabase.init();
		String accountNumber = (String)req.getSession().getAttribute("accountNumber");
		String orderNumber = (String) req.getSession().getAttribute("orderNumber");
		if(req.getParameter("store")!=null) {
			StorePage storeModel = new StorePage();
			ArrayList<Item> items = db.getVisibleItems();
			storeModel.setCustomerAccount(db.getCustomerAccount(accountNumber));
			storeModel.setItems(items);
			req.setAttribute("model", storeModel);
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}else if(req.getParameter("checkOut")!=null) {
			req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
		}else if(req.getParameter("cancelOrder")!=null) {
			db.cancelOrder(orderNumber);
			req.getSession().removeAttribute("orderNumber");
			StorePage storeModel = new StorePage();
			ArrayList<Item> items = db.getVisibleItems();
			storeModel.setCustomerAccount(db.getCustomerAccount(accountNumber));
			storeModel.setItems(items);
			req.setAttribute("model", storeModel);
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}else {
			throw new ServletException("Unknown command");
		}
	}
}
