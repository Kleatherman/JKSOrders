<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<html lag= "en">
	<head>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<head>
	
		<meta charset ="utf-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
		<title>Work Page</title>
		<style type="text/css">
		.TitleText2 {
						font-size: 300%;
                        font-weight: bold; 
                        text-align: center;
		}
		</style>
	</head>

	<body>
	<div class = "container-fluid">
			<div class="row">
				<div class="col-sm-4" style="background-color:lavender;">space</div>
				<div class="col-sm-4" style="background-color:white;">

				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
	</body>
</html>




<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html lag= "en">
	<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<head>


  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
     					<div class= "TitleText2">Welcome to work! </div>
					<form action="${pageContext.servletContext.contextPath}/workPage" method="post">
						<div>
							<input name="profilePage" type="submit" value="Profile Page!" />
							<input name="employeeLogin" type="submit" value="Log out!" />
							<c:if test="${model.manager}">
								<input name="createEmployee" type="submit" value="Create an employee" />
								<div>
								<input name="message" type="text" value="${model.message}" length=300 />
								<input name="notify" type="submit" value="Submit Notification" />
								<input name="urgency" type="checkbox" value="Urgent" />Urgency<br>
									<c:forEach items="${model.employeeNames}" var="name">
										<input name="${name}" type="checkbox" value="${name}" />${name}<br>
									</c:forEach> 
								<div  class="text-center">
									<h1>Your Notifications</h1>
									<select name="editNotification">	
										<c:forEach items="${model.sourceNotifications}" var = "sourceNotify">
											<option value="${sourceNotify.notificationID}">${sourceNotify.notificationID}</option>
										</c:forEach>
									</select>
								<input name="editNotification" type="submit" value="Edit Notification" />
							</c:if>
							
								<h1>All Orders:</h1>
								<select name="editOrder">	
									<c:forEach items="${model.orders}" var = "order">
										<option value="${order.orderType}">${order.orderType} : $${order.totalPrice} : <c:choose><c:when test="${order.complete}">Complete</c:when><c:otherwise>Pending</c:otherwise></c:choose></option>
									</c:forEach>
								</select>
								<input name="fulfillOrder" type="submit" value="Fulfill Order" />
							
						</div>
					</form>
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
				</div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
