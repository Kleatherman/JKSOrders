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
	
		<title>Profile Page</title>
		<style type="text/css">
		.TitleText2 {
						font-size: 300%;
                        font-weight: bold; 
                        text-align: center;
		}
		.error {
			color: red;
		}
		.standard{
			font-weight: bold;
		}
		</style>
	</head>

	<body>
		<div class = "container-fluid">
			<div class="row">
				<div class="col-sm-4" style="background-color:lavender;">space</div>
				<div class="col-sm-4" style="background-color:white;">
					<div class= "TitleText2">This is your profile page! </div>
					<form action="${pageContext.servletContext.contextPath}/profilePage" method="post">
						<table>
							<tr>
								<td class="label">First name:</td>
								<td>${Name}</td>
							</tr>
							<tr>
								<td class="label">Account Number:</td>
								<td>${Anumber}</td>
							</tr>
							<tr>
								<td class="label">Phone Number:</td>
								<td>${Pnumber}</td>
							</tr>
							<tr>
								<td class="label">Username:</td>
								<td>${Username}</td>
							</tr>
							<tr>
								<td class="label">Password:</td>
								<td>${password}</td>
							</tr>
						</table>
						<div>
							<c:if test="${isCustomer}">
								<select name="sourceOrders">	
										<c:forEach items="${sourceOrders}" var = "order">
											<option value="${order.orderType}">${order.orderType} : $${order.totalPrice}</option>
										</c:forEach>
									</select>
								<input name = "sourceOrdersSubmit" type = "submit" value = "View Order" />
								<input name="storePage" type="submit" value="Store Page!" />
							</c:if>
							<c:if test="${isEmployee}">
								<input name="workPage" type="submit" value="Work Page!"/>
							</c:if>	
								<input name="accountNumber" type="hidden" value="${accountNumber}" />
						</div>
					</form>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
	</body>
</html>