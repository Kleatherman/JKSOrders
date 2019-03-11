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
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
			<tr>
				<td>${item0.itemName}</td>
				<td>${item0.description}</td>
				<td>${item0.price}</td>
			</tr>
			<tr>
				<td>${item1.itemName}</td>
				<td>${item1.description}</td>
				<td>${item1.price}</td>
			</tr>
			<tr>
				<td>${item2.itemName}</td>
				<td>${item2.description}</td>
				<td>${item2.price}</td>
			</tr>
		</table>
		<form action="${pageContext.servletContext.contextPath}/storePage" method="post">
			<div>
				<input name="checkOut" type="submit" value="CheckOut!" />
				<input name="profilePage" type="submit" value="Profile Page!"/>
				<input name="logOut" type="submit" value="LogOut"/>
			</div>
		</form>
	</body>
</html>