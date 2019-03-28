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
	
		<title>Create Customer Account</title>
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
					<div class= "TitleText2">Create Account</div>
					<form action="${pageContext.servletContext.contextPath}/createCustomerAccount" method="post">
					
	
			
							Email Address:<br>
							<input type="text" name="emailAddress" size="12" value="${model.userName}" /><br>
							Password:<br>	
							<input type="password" name="password" size="12" value="${model.password}" /><br>
				
							Name:<br>	
							<input type="text" name="Name" size="12" value="${model.userName}" /><br>
						
							Phone Number:<br>		
							<input type="text" name="phoneNumber" size="12" value="${model.phoneNumber}" /><br>
					
						
						
						<div>
							<input type="Submit" name="submit" value="Create Account">
							
						</div>
					</form>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
	</body>
</html>