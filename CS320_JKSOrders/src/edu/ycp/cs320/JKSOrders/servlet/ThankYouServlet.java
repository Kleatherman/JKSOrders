package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;


public class ThankYouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Thank You Servlet: doGet");	
		if(req.getAttribute("accountNumber")==null) {
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
		System.out.println("ThankYou Servlet: doPost");
		String accountNumber = req.getParameter("accountNumber");
		if(accountNumber != null) {
			Account account =  db.getAccount(accountNumber);
			req.setAttribute("accountNumber", account.getAccountNumber());
		}
		if(req.getParameter("storePage")!= null) {
			ArrayList<Item> items = db.getVisibleItems();
			System.out.println("StorePage: "+ items.get(0).getDescription());
			req.setAttribute("items", items);
			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}
	}
}
