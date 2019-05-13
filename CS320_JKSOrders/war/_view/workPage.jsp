
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">




<div class="container"  style="text-align:center;">
	<div class="row">
  		<div class="card border-0 shadow w-100 my-5"  style="background-color:#cccccc;display:inline-block;"  >
    		<div class="card-body p-5">
  				<div class="centered text-center" >
					<div>
						<form action="${pageContext.servletContext.contextPath}/workPage" method="post">
							<ul class="pagination justify-content-center">
							<h1 align="center">Welcome To Work</h1><br/><br />
					</div>
				</div>
			</div>
		</div>
	</div>
	
<ul class="pagination justify-content-center">
 
	<p><br /><br /><br /></p>
			
        
            	<button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="profilePage"> Profile Page </button>
            	&nbsp;&nbsp;&nbsp;&nbsp;
                <button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="employeeLogin"> Log Out </button>
                &nbsp;&nbsp;&nbsp;&nbsp;
           <c:if test="${model.manager}">
								<button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="createEmployee"> Add Employee </button>
			</c:if>
    </ul>	<br><br>
		
		

    
<div class="row">
  		<div class="card border-0 shadow w-100 my-5"  style="background-color:#cccccc;display:inline-block;"  >
    		<div class="card-body p-5">
  				<div class="centered text-center" >
						<div  class="text-center"  class = "col-xs-8 text-center">
								<c:if test="${model.manager}">
									<h1>Your Notifications</h1>
									
									<ul class="pagination justify-content-center">
         							
         							<select name="notifications">	
										<c:forEach items="${model.sourceNotifications}" var = "sourceNotify">
											<option value="${sourceNotify.notificationID}">${sourceNotify.notificationID}</option>
										</c:forEach>
									</select>
									<button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="editNotification"> Edit Notification </button>
            
    								</ul>
    
									
																
								<h1>Inventory Items</h1>
								
									<ul class="pagination justify-content-center">
         							
         							<select name="items">	
										<c:forEach items="${model.items}" var = "item">
											<option value="${item.UPC}">${item.itemName}</option>
										</c:forEach>
											<option value="addItem">Add New Item</option>
									</select>
									

								
								<button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="editItem"> Edit Item </button>
            						</c:if>
    								</ul>
								
									
								
							
							
								<h1>All Orders:</h1>
								
								
									<ul class="pagination justify-content-center">
         							
         				<select name="editOrder">	
									<c:forEach items="${model.orders}" var = "order">
										<option value="${order.orderType}">${order.orderType}: <c:choose><c:when test="${order.complete}">Complete</c:when><c:otherwise>Pending</c:otherwise></c:choose></option>
									</c:forEach>
								</select>
								
								<button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="fulfillOrder"> Fulfill Order </button>
								
								
    								</ul>
							
						</div>
					
					<table align="center" class = "table">
						<tr>
							<th>Message</th>
							<th>Urgent?</th>
						</tr>
						<c:forEach items="${model.receivedNotifications}" var="notify">
							<tr>
								<td>${notify.message}</td>
								<c:choose>
									<c:when test = "${notify.urgency}">
										<td>Yes!</td>
									</c:when>
									<c:otherwise>
										<td>No</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
						
					</table>
					
					
					<ul class="pagination justify-content-center">
         							
         		<c:if test="${model.manager}">					
					<input name="message" type="text" value="${model.message}" length=300 />
					<button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="notify"> Submit Notification </button>
								
								
    				</ul>
				
					
									<input name="urgency" type="checkbox" value="Urgent" />Urgency<br>
									<c:forEach items="${model.employeeNames}" var="name">
										<input name="${name}" type="checkbox" value="${name}" />${name}<br>
									</c:forEach> 
				</c:if>
					</form>		
					</div>
				</div>
			</div>
		</div>
	</div>
	
			
					
 </body>
</html>

		