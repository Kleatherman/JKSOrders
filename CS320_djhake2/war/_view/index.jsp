<!DOCTYPE html>
<html>
	<head>
		<title>Check Out</title>
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