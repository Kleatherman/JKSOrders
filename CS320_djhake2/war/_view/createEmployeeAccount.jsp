<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Create Employee Account</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>
		This is the Create Employee Account page
		<form action="${pageContext.servletContext.contextPath}/createEmployeeAccount" method="post">
			<div>
				<input type="Submit" name="loginPage" value="Go Back">
			</div>
		</form>
	</body>
</html>