package edu.ycp.cs320.JKSOrders.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.controller.EditNotificationController;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.controller.WorkPageController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.EditItemModel;
import edu.ycp.cs320.JKSOrders.model.EditNotificationModel;
import edu.ycp.cs320.JKSOrders.model.WorkPage;



public class EditItemServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Edit Item Servlet: doGet");	
		if(req.getSession().getAttribute("accountNumber")==null) {
			req.getRequestDispatcher("/_view/employeeLogin.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
		else{
			req.getRequestDispatcher("/_view/editItem.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Database db = InitDatabase.init();
		System.out.println("Edit Item Servlet: doPost");
		String accountNumber = (String) req.getSession().getAttribute("accountNumber");
		boolean isManager = true;
		if(req.getParameter("workPage")!=null) {
			WorkPage workModel = new WorkPage();
			workModel.setOrders(db.getAllPickUpOrders());
			req.setAttribute("model", workModel);
			String name = db.getAccount(accountNumber).getFirstName();
			if(db.getNotifications(accountNumber).size()!=0) {
				workModel.setReceivedNotifications(db.getNotifications(accountNumber));
			}
			workModel.setOrders(db.getAllPickUpOrders());
			workModel.setSourceNotifications(db.getSourceNotifications(accountNumber));
			workModel.setManager(isManager);
			workModel.setEmployeeNames(db.AllEmployeeNames());
			workModel.setItems(db.getCatalog().returnItemList());
			workModel.setAccountNumber(accountNumber);
			req.setAttribute("model", workModel);
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
		else if(req.getParameter("addItem")!=null) {
			String upc = req.getParameter("itemUPC");
			Item item = new Item();
			item.setUPC(upc);
			item.setDescription(req.getParameter("description"));
			item.setItemName(req.getParameter("name"));
			item.setLocation(req.getParameter("location"));
			item.setNumInInventory(Integer.parseInt(req.getParameter("numInventory")));
			item.setPhoto(req.getParameter("image"));
			item.setPrice(Double.parseDouble(req.getParameter("price")));
			if(req.getParameter("visible")!=null) {
				item.setVisable(true);
			}
			else
				item.setVisable(false);
			db.addItem(item);
			EditItemModel editModel = new EditItemModel();
			editModel.setItem(item);
			editModel.setNewItem(false);
			req.setAttribute("model", editModel);
			req.getRequestDispatcher("/_view/editItem.jsp").forward(req, resp);
		}
		else if(req.getParameter("update")!=null) {
			String upc = req.getParameter("itemUPC");
			Item item = new Item();
			item.setUPC(upc);
			item.setDescription(req.getParameter("description"));
			item.setItemName(req.getParameter("name"));
			item.setLocation(req.getParameter("location"));
			item.setNumInInventory(Integer.parseInt(req.getParameter("numInventory")));
			item.setPhoto(req.getParameter("image"));
			item.setPrice(Double.parseDouble(req.getParameter("price")));
			if(req.getParameter("visible")!=null) {
				item.setVisable(true);
			}
			else
				item.setVisable(false);
			db.updateItem(item);
			EditItemModel editModel = new EditItemModel();
			editModel.setItem(item);
			editModel.setNewItem(false);
			req.setAttribute("model", editModel);
			req.getRequestDispatcher("/_view/editItem.jsp").forward(req, resp);
		}
		else if(req.getParameter("delete")!=null) {
			String upc = req.getParameter("itemUPC");
			db.deleteItem(upc);
			
			isManager = db.getEmployeeAccount(accountNumber).isManager();
			WorkPage workModel = new WorkPage();
			if(db.getNotifications(accountNumber).size()!=0) {
				workModel.setReceivedNotifications(db.getNotifications(accountNumber));
			}
			workModel.setItems(db.getCatalog().returnItemList());
			workModel.setOrders(db.getAllPickUpOrders());
			workModel.setSourceNotifications(db.getSourceNotifications(accountNumber));
			workModel.setManager(isManager);
			workModel.setEmployeeNames(db.AllEmployeeNames());
			workModel.setAccountNumber(accountNumber);
			req.setAttribute("model", workModel);
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
		else {
			throw new ServletException("Unknown command");
		}
		
	}

}
