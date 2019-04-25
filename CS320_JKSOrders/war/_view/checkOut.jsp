<!DOCTYPE html>
<html lag= "en">
	<head>
		<meta charset ="utf-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		
		<title>Check Out</title>
		<style type="text/css">
		
		.text {
			text-align: left;
		}
		</style>
	</head>

	<body>
		<div class = "container-fluid">
			<div class="row">
				<div class="col-sm-4" style="background-color:lavender;">space</div>
				<div class="col-sm-4" style="background-color:white;">
					<h1> This is checkout </h1>
					<h1> Hi Y'all </h1>
					<form action="${pageContext.servletContext.contextPath}/checkOut" method="post">
						<div>
							<input type="Submit" name="cancel" value="Cancel Order">
							<input type="Submit" name="cart" value="My Cart">
							<input type="Submit" name="thankYou" value="Submit Order">
							<input name="accountNumber" type="hidden" value="${accountNumber}" />
						</div>
						
  					  <div style="color: red">${errorMessage}</div><br />
					</form>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
		
	</body>
</html>