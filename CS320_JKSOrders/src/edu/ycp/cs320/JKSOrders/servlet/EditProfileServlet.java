package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.controller.CreateCustomerAccountController;
import edu.ycp.cs320.JKSOrders.controller.EditProfileController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.CreateCustomerAccount;
import edu.ycp.cs320.JKSOrders.model.EditProfileModel;
import edu.ycp.cs320.JKSOrders.model.ProfilePage;

public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Edit Profile Servlet: doGet");	

		if(req.getSession().getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("/_view/editProfile.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Create Edit Profile Servlet: doPost");

		// create model - model does not persist between requests
		// must recreate it each time a Post comes in
		EditProfileModel model = new EditProfileModel();
		String accountNumber = (String) req.getSession().getAttribute("accountNumber");
		char[] accountArray = accountNumber.toCharArray();
		if(accountArray[0]=='C')	
			model.setCustomer(true);
		else
			model.setCustomer(false);

		// create controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		Database db = InitDatabase.init();
		EditProfileController controller = new EditProfileController();
		
		// assign model reference to controller so that controller can access model
		controller.setModel(model);

		// call JSP to generate form
		Database dbase = InitDatabase.init();

		
		if (req.getParameter("ProfilePage") != null) {
			
			ProfilePage profilePageModel = new ProfilePage();
			profilePageModel.setCustomer(model.isCustomer());
			profilePageModel.setEmployee(!model.isCustomer());
			if(model.isCustomer()) {
				CustomerAccount account = db.getCustomerAccount(accountNumber);
				account.setOrders(db.getSourceOrders(accountNumber));
				profilePageModel.setCustomerAccount(account);
			}
			else {
				profilePageModel.setEmployeeAccount(db.getEmployeeAccount(accountNumber));
			}
			req.setAttribute("model", profilePageModel);
			req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
		} 
		else if(req.getParameter("EditPage") != null){
			if(model.isCustomer()) {
				controller.setLogin(req.getParameter("password"), req.getParameter("Username"),model.isCustomer());
				controller.setID(accountNumber, model.isCustomer());
				controller.setCarColor(req.getParameter("carcolor"));
				controller.setCarMake(req.getParameter("carmake"));
				controller.setCarModel(req.getParameter("carmodel"));
				controller.setCarYear(Integer.parseInt(req.getParameter("caryear")));
				controller.setName(req.getParameter("name"),model.isCustomer());
			}
			else{
				
				controller.setLogin(req.getParameter("password"), db.getEmployeeAccount(accountNumber).getLogin().getUserName(),model.isCustomer());
				controller.setID(accountNumber, model.isCustomer());
				controller.setName(db.getAccount(accountNumber).getFirstName(),model.isCustomer());
				controller.setLastName(db.getAccount(accountNumber).getLastName(),model.isCustomer());
			}
			
			
			controller.setEmail(req.getParameter("email"), model.isCustomer());
			controller.setPhoneNumber(req.getParameter("number"),model.isCustomer());
			controller.editAccount(dbase,model.isCustomer());
			
			req.setAttribute("model", model);
			req.getRequestDispatcher("/_view/editProfile.jsp").forward(req, resp);
		}
		
		else {
			
		}
		req.setAttribute("model", model);

	}
}
