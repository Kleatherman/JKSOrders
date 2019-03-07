<!DOCTYPE html>
<html>
	<head>
		<title>Thank You</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		.text {
			text-align: left;
		}
		</style>
	</head>

	<body>
		<div class = text>Thank You for using our services!</div>
		<h1>Thank You page</h1>
		<form action="${pageContext.servletContext.contextPath}/thankYou" method="post">
			<div>
				<input type="Submit" name="storePage" value="Close">
			</div>
		</form>
	</body>
</html>