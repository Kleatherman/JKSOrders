package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;

import edu.ycp.cs320.JKSOrders.controller.CustomerLoginController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;


public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("CustomerLogin Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Database db = InitDatabase.init();
		System.out.println("CustomerLogin Servlet: doPost");
		

		// create model - model does not persist between requests
		// must recreate it each time a Post comes in
		LoginInfo model = new LoginInfo();

		// create controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		CustomerLoginController controller = new CustomerLoginController();

		// assign model reference to controller so that controller can access model
		controller.setModel(model);

		
		
		SystemController system = new SystemController();
		String errorMessage = null;
		System.out.println("We are going to try to get the password and email address out of the webpage");
		try {
			controller.setUserName(req.getParameter("emailAddress"));
			controller.setPassword(req.getParameter("password"));
			System.out.println("We got the password and email address out of the webpage");
			System.out.println("Password = "+ model.getPassword());
			System.out.println("UserName = " + model.getUserName());
			
			
			// check for errors in the form data before using is in a calculation
			/*if (email_address == null || password == null) {
				errorMessage = "Please enter your email address and password";
			}*/
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			
			if (req.getParameter("createCustomerAccount")!=null) {
				System.out.println("We're headed to customer account JSP");
				req.getRequestDispatcher("/_view/createCustomerAccount.jsp").forward(req, resp);
			}
			else if(req.getParameter("forgot")!=null) {
			 	req.getRequestDispatcher("/_view/customerForgotLogin.jsp").forward(req, resp);
			}
			else if(!system.verifyCustomerLoginInfo(model, db.getCustomerLoginInfo())) {
				req.getRequestDispatcher("/_view/customerLogin.jsp").forward(req, resp);
			}
			else if (req.getParameter("submit")!=null) {
				ArrayList<Item> items = system.getVisibleItems();
				System.out.println("StorePage: "+ items.get(0).getDescription());
				for(int i =0; i<items.size(); i++) {
					req.setAttribute("item"+i, items.get(i));
				}
				req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
			}
			
		} catch (NumberFormatException e) {
			errorMessage = "Invalid input";
		}
		
		// Add parameters as request attributes
		// this creates attributes named "first" and "second for the response, and grabs the
		// values that were originally assigned to the request attributes, also named "first" and "second"
		// they don't have to be named the same, but in this case, since we are passing them back
		// and forth, it's a good idea
	
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		
		// Forward to view to render the result HTML document
		


}
	
}
