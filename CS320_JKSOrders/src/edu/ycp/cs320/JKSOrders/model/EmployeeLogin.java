package edu.ycp.cs320.JKSOrders.model;

import edu.ycp.cs320.JKSOrders.classes.LoginInfo;

// model class for GuessingGame
// only the controller should be allowed to call the set methods
// the JSP will call the "get" and "is" methods implicitly
// when the JSP specifies game.min, that gets converted to
//    a call to model.getMin()
// when the JSP specifies if(game.done), that gets converted to
//    a call to model.isDone()
public class EmployeeLogin {
	
LoginInfo login = new LoginInfo();
	
	public EmployeeLogin() {
		
	}
	
	}
	
	