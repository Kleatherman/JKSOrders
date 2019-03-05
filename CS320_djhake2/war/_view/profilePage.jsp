<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Profile Page</title>
		<style type="text/css">
		</style>
	</head>

	<body>
		This is the Profile Page
	
		<form action="${pageContext.servletContext.contextPath}/profilePage" method="post">
			<div>
				<input name="storePage" type="submit" value="Store Page!" />
				<input name="workPage" type="submit" value="Work Page!"/>
				
			</div>
		</form>
	</body>
</html>