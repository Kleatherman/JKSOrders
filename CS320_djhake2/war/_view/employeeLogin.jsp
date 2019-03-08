<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Employee Login</title>
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
		<h1>Employee Login</h1>
		<form action="${pageContext.servletContext.contextPath}/employeeLogin" method="post">
			<table>
				
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				
				<tr>
					<td class="label">Pin:</td>
					<td><input type="password" name="pin" size="12" value="${pin}" /></td>
				</tr>
			</table>
			<div>
				<input type="Submit" name="submit" value="Login">
				<input type="Submit" name="forgot" value="Forgot Info">
				<input type="Submit" name="createEmployeeAccount" value="Create Account">
			</div>
		</form>
	</body>
</html>