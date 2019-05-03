<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
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
					<div class= "TitleText2">Welcome to work! </div>
					<form action="${pageContext.servletContext.contextPath}/workPage" method="post">
						<div>
							<input name="profilePage" type="submit" value="Profile Page!" />
							<input name="employeeLogin" type="submit" value="Log out!" />
							<input name="accountNumber" type="hidden" value="${model.accountNumber}" />
							<c:if test="${model.manager}">
								<input name="message" type="text" value="${model.message}" length=300 />
								<input name="notify" type="submit" value="Submit Notification" />
								<input name="urgency" type="checkbox" value="Urgent" />Urgency<br>
									<c:forEach items="${model.employeeNames}" var="name">
										<input name="${name}" type="checkbox" value="${name}" />${name}<br>
									</c:forEach> 
								
									<h1>Pending Orders:</h1>
										<select name="editOrder">	
											<c:forEach items="${model.orders}" var = "order">
											<option value="${order.orderType}">${order.orderType} : $${order.totalPrice}</option>
											</c:forEach>
										</select>
										<input name="fulfillOrder" type="submit" value="Fulfill Order" />
									<h1>Your Notifications</h1>
									<select name="editNotification">	
										<c:forEach items="${model.sourceNotifications}" var = "sourceNotify">
											<option value="${sourceNotify.notificationID}">${sourceNotify.notificationID}</option>
										</c:forEach>
									</select>
								<input name="editNotification" type="submit" value="Edit Notification" />
							</c:if>
							
						</div>
					</form>
					<table>
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
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
	</body>
</html>
