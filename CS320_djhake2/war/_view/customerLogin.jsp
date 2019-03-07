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
		<form action="${pageContext.servletContext.contextPath}/customerLogin" method="post">
			<table>
				<tr>
					<td class="label">Email Address:</td>
					<td><input type="text" name="emailAddress" size="12" value="${emailAddress}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="text" name="password" size="12" value="${password}" /></td>
				</tr>
				
			
			</table>
			<input type="Submit" name="submit" value="Login">
			<input type="Submit" name="forgot" value="Forgot Info">
		</form>
	</body>
</html>