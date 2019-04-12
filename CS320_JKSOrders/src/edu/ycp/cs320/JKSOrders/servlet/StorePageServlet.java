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

		
		if(accountNumber != null) {
			Account account =  db.getAccount(accountNumber);
			req.setAttribute("accountNumber", account.getAccountNumber());
			accountNumber = req.getParameter("accountNumber");
		}
		if (req.getParameter("checkOut") != null) {
			req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
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
		else {
			throw new ServletException("Unknown command");
		}

		
	}
}
