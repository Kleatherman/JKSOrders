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
		
		<title>Retrieve customer login</title>
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
					<c:if test="${! empty errorMessage}">
						<div class="error">${errorMessage}</div>
					</c:if>
					<div class= "TitleText2">The Customer forgot their login</div>
					<form action="${pageContext.servletContext.contextPath}/customerForgotLogin" method="post">
						<table>
							<tr>
								<td class="standard">Username:</td>
								<td><input type="text" name="Username" size="12" value="${Username}" /></td>
							</tr>
							<tr>
								<td class="standard">Phone number:</td>
								<td><input type="text" name="Phone" size="12" /></td>
							</tr>
				
							<tr>
								<td class="label">Password:</td>
								<td>${result}</td>
							</tr>
						</table>
						<input type="Submit" name="submit" value="Get Info">
						<div>
							<input type="Submit" name="LoginPage" value="Go Back">
						</div>
					</form>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
	</body>
</html>