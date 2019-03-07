<!DOCTYPE html>
<html>
	<head>
		<title>Check Out</title>
		<style type="text/css">
		
		.text {
			color: red;
			text-align: right;
		}
		</style>
	</head>

	<body>
		<div class = text>
			<h1>This is Index page!</h1>
			<h2>This Website is under construction</h2>
		</div>
		
		<form action="${pageContext.servletContext.contextPath}/multiplyNumbers" method="post">
			<input type="Submit" name="customer" value="Customer Login">
			<input type="Submit" name="employee" value="Employee Login">
		</form>
	</body>
</html>