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

public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("CheckOut Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/checkOut.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("CheckOut Servlet: doPost");
		Database db = InitDatabase.init();
		// Forward to view to render the result HTML document
		if(req.getParameter("thankYou")!=null) {
			req.getRequestDispatcher("/_view/thankYou.jsp").forward(req, resp);
		}
		else if(req.getParameter("cancel")!=null) {
			ArrayList<Item> items = db.getVisibleItems();
			System.out.println("StorePage: "+ items.get(0).getDescription());
			for(int i =0; i<items.size(); i++) {
				req.setAttribute("item"+i, items.get(i));
			}
			req.getRequestDispatcher("/_view/storePage.jsp").forward(req, resp);
		}
	}
}
