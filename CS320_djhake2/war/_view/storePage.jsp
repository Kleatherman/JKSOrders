<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Store Page</title>
		<style type="text/css">
		</style>
		
	</head>

	<body>
	<p>This is the Store Page</p>
		
	
		<form action="${pageContext.servletContext.contextPath}/storePage" method="post">
			<div>
				<input name="checkOut" type="submit" value="CheckOut!" />
				<input name="profilePage" type="submit" value="Multiply Numbers!" />
			</div>
		</form>
	</body>
</html>