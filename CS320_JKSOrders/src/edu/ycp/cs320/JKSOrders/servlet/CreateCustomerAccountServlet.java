package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.controller.CreateCustomerAccountController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.CreateCustomerAccount;

public class CreateCustomerAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Create Customer Account Servlet: doGet");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Create Customer Account Servlet: doPost");

		// create model - model does not persist between requests
		// must recreate it each time a Post comes in
		CreateCustomerAccount model = new CreateCustomerAccount();

		// create controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		CreateCustomerAccountController controller = new CreateCustomerAccountController();

		// assign model reference to controller so that controller can access model
		controller.setModel(model);

		// call JSP to generate form
		Database dbase = InitDatabase.init();

		
		if (req.getParameter("loginPage") != null) {
			req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/_view/createCustomerAccount.jsp").forward(req, resp);
			
			controller.setLogin(req.getParameter("password"), req.getParameter("username"));
			controller.setAccountNumber(dbase);
			controller.setNullValues();
			controller.addAccount(dbase);
		}
		req.setAttribute("model", model);

	}
}
