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
	
		<title>Customer Login</title>
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
					<div class= "TitleText2">Customer Login</div>
					<form action="${pageContext.servletContext.contextPath}/customerLogin" method="post">
						<table>
							<tr>
								<td class="label">Email Address:</td>
								<td><input type="text" name="emailAddress" size="12" value="${model.userName}" /></td>
							</tr>
							<tr>
								<td class="label">Password:</td>
								<td><input type="password" name="password" size="12" value="${model.password}" /></td>
							</tr>
						</table>
						<div>
							<input type="Submit" name="submit" value="Login">
							<input type="Submit" name="forgot" value="Forgot Info">
							<input type="Submit" name="createCustomerAccount" value="Create Account">
						</div>
						<input name="accountNumber" type="hidden" value="${accountNumber}" />
					</form>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
	</body>
</html>