<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
		<meta charset ="utf-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
		<title>Edit Item</title>
		<style type="text/css">
		.TitleText2 {
						font-size: 300%;
                        font-weight: bold; 
                        text-align: center;
		}
		
		.ErrorMessage {
						font-size: 150%;
						text-align: center;
						color: red;		
		}
		</style>
	</head>

	<body>
	<div class = "container-fluid">
			<div class="row">
				<div class="col-sm-4" style="background-color:lavender;">space</div>
				<div class="col-sm-4" style="background-color:white;">
					<div class= "TitleText2">Edit Item ${model.item.UPC}</div>
					<form action="${pageContext.servletContext.contextPath}/editItem" method="post">
						<div>
							<input name="workPage" type="submit" value="Return to Work Page" />
							<c:choose>
								<c:when test="${model.newItem}"><input name="addItem" type="submit" value="Add Item" /></c:when>
								<c:otherwise><input name="update" type="submit" value="Update Item" /></c:otherwise>
							</c:choose>
							<input name="delete" type="submit" value="Delete This Item" />
							<input name="itemUPC" type="hidden" value="${model.item.UPC}"/>
							<input name="name" type="text" value="${model.item.itemName}" />Item Name<br>
							<input name="description" style="height:50px;font-size:14pt;width:150%" type="text" value="${model.item.description}" /><br>
							<input name="visible" type="checkbox" />Visibility<br>
						</div>
						<input name="price" type="text" value="${model.item.price}" />Price<br>
						<input name="location" type="text" value="${model.item.location}" />Location<br>
						<input name="numInventory" type="number" value="${model.item.numInInventory}" />Quantity in Inventory<br>
						<input name="image" type="text" value="${model.item.photo}" />Picture<br>
					</form>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
	</body>
</html>
