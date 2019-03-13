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
			This is checkout!
		</div>
		
		<form action="${pageContext.servletContext.contextPath}/checkOut" method="post">
			<div>
				<input type="Submit" name="cancel" value="Cancel Order">
				<input type="Submit" name="thankYou" value="Submit Order">
			</div>
		</form>
	</body>
</html>