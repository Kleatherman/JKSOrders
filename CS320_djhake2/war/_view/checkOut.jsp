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
			This is checkout!
		</div>
		
		<form action="${pageContext.servletContext.contextPath}/multiplyNumbers" method="post">
			<input type="Submit" name="cancel" value="Cancel Order">
			<input type="Submit" name="thankYou" value="Submit Order">
		</form>
	</body>
</html>