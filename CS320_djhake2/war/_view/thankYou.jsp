<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Thank You</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		.text {
			color: red;
			text-align: right;
		}
		</style>
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
		
		<div class = text>Thank You for using our services!</div>
		
		<form action="${pageContext.servletContext.contextPath}/multiplyNumbers" method="post">
			<input type="Submit" name="storePage" value="Close">
		</form>
	</body>
</html>