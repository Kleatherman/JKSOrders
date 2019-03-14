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
	
		<title>Index</title>
		<style type="text/css">
		
		.text {
			text-align: left;
		}
		</style>
	</head>

	<body>
		<div class = text>
			<h1>This is Index page!</h1>
			<h2>This Website is under construction</h2>
		</div>
		
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<div>	
				<input type="Submit" name="customer" value="Customer Login">
				<input type="Submit" name="employee" value="Employee Login">
			</div>
		</form>
	</body>
</html>