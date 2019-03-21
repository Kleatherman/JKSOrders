package edu.ycp.cs320.JKSOrders.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.controller.SystemController;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;


public class ProfilePageServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("ProfilePage Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/profilePage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("ProfilePage Servlet: doPost");
		Database db = InitDatabase.init();
		// check which button the user pressed
		if (req.getParameter("storePage") != null) {
			// call addNumbers JSP
			ArrayList<Item> items = db.getVisibleItems();
			System.out.println("StorePage: "+ items.get(0).getDescription());
			for(int i =0; i<items.size(); i++) {
				req.setAttribute("item"+i, items.get(i));
			}
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}
		else if (req.getParameter("workPage") != null) {
			// call addNumbers JSP
			req.getRequestDispatcher("/_view/workPage.jsp").forward(req, resp);
		}
		
		else {
			throw new ServletException("Unknown command");
		}
		
	}
	
}
