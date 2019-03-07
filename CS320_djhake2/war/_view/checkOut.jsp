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