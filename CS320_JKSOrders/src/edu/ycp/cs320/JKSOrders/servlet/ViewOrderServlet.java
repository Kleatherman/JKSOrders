package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.controller.StorePageController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.ProfilePage;
import edu.ycp.cs320.JKSOrders.model.StorePage;

public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("View Order Servlet: doGet");
		if (req.getSession().getAttribute("accountNumber") == null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else {
			req.getRequestDispatcher("/_view/viewOrder.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("View Order Servlet: doPost");
		StorePageController controller = new StorePageController();
		StorePage model = new StorePage();
		controller.setModel(model);
		Database db = InitDatabase.init();
		String accountNumber = (String) req.getSession().getAttribute("accountNumber");

		if (accountNumber != null) {

			if (req.getParameter("cancelOrder") != null) {

				db.cancelOrder((String) req.getSession().getAttribute("orderNumberToView"));
			}

			ProfilePage profilePageModel = new ProfilePage();
			profilePageModel.setCustomer(true);
			profilePageModel.setEmployee(false);
			CustomerAccount account = db.getCustomerAccount(accountNumber);
			account.setOrders(db.getSourceOrders(accountNumber));
			profilePageModel.setCustomerAccount(account);
			req.setAttribute("model", profilePageModel);
			
			req.getSession().removeAttribute("orderNumberToView");
			
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		}
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		
	}
}
