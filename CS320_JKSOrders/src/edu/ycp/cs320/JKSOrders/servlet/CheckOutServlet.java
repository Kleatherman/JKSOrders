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
import edu.ycp.cs320.JKSOrders.controller.CheckOutController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.CheckOut;

public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("CheckOut Servlet: doGet");

		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("CheckOut Servlet: doPost");
		Database db = InitDatabase.init();
		String accountNumber = req.getParameter("accountNumber");
		if(accountNumber != null) {
			Account account = db.getAccount(accountNumber);
			System.out.println("Work page servlet right before setting account number:"+account.getAccountNumber());
			req.setAttribute("accountNumber", account.getAccountNumber());
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
			ArrayList<Item> items = db.getVisibleItems();
			System.out.println("StorePage: " + items.get(0).getDescription());
			for (int i = 0; i < items.size(); i++) {
				req.setAttribute("item" + i, items.get(i));
			}
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
			req.setAttribute("model", model);
		}
	}
}
