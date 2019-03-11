<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Customer Login</title>
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
		<h1>Customer Login</h1>
		<form action="${pageContext.servletContext.contextPath}/customerLogin" method="post">
			<table>
				<tr>
					<td class="label">Email Address:</td>
					<td><input type="text" name="emailAddress" size="12" value="${emailAddress}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" name="password" size="12" value="${password}" /></td>
				</tr>
			</table>
			<div>
				<input type="Submit" name="submit" value="Login">
				<input type="Submit" name="forgot" value="Forgot Info">
				<input type="Submit" name="createCustomerAccount" value="Create Account">
			</div>
		</form>
	</body>
</html>