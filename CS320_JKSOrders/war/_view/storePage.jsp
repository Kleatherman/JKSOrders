<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
		<title>Store Page</title>
		<style type="text/css">
		.TitleText2 {
						font-size: 300%;
                        font-weight: bold; 
                        text-align: center;
		}
		</style>
		
	</head>

	<body>
	<div class = "container-fluid">
			<div class="row">
				<div class="col-sm-4" style="background-color:lavender;">space</div>
				<div class="col-sm-4" style="background-color:white;">
					<div class= "TitleText2">This is the store page! </div>
					<div class= "TitleText2">We seem to have issues here, I'll work on it </div>
					<form action="${pageContext.servletContext.contextPath}/storePage" method="post">
						<table>
							<tr>
								<th>Name</th>
								<th>Description</th>
								<th>Price</th>
							</tr>
							<c:forEach items="${items}" var="item">
								<tr>
									<td>${item.itemName}</td>
									<td>${item.description}</td>
									<td>${item.price}</td>
								</tr>
							</c:forEach>
							
						</table>
						<div>
							<input name="checkOut" type="submit" value="CheckOut!" />
							<input name="profilePage" type="submit" value="Profile Page!"/>
							<input name="logOut" type="submit" value="LogOut"/>
							<input name="accountNumber" type="hidden" value="${accountNumber}" />
						</div>
					</form>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
	</body>
</html>