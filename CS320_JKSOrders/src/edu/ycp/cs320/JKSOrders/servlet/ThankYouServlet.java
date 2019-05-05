package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.ProfilePage;
import edu.ycp.cs320.JKSOrders.model.StorePage;


public class ThankYouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Thank You Servlet: doGet");	
		if(req.getSession().getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/thankYou.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Database db = InitDatabase.init();
		req.getSession().removeAttribute("orderNumber");
		System.out.println("ThankYou Servlet: doPost");
		String accountNumber = (String) req.getSession().getAttribute("accountNumber");
		if(accountNumber != null) {
			Account account =  db.getAccount(accountNumber);
		}
		if(req.getParameter("storePage")!= null) {
			
			// Forward to view to render the result HTML document
			
			
				StorePage storeModel = new StorePage();
				ArrayList<Item> itemsForStorePage = db.getVisibleItems();
				storeModel.setCustomerAccount(db.getCustomerAccount(accountNumber));
				storeModel.setItems(itemsForStorePage);
				req.setAttribute("model", storeModel);
				req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
				
			
			
		}
	}
}
