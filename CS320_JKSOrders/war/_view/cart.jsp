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
	
		<title>Cart Page</title>
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
		table {
 						 font-family: arial, sans-serif;
						 border-collapse: collapse;
						 width: 100%;
		}
		td, th {
						 border: 1px solid #dddddd;
						 text-align: left;
						 padding: 8px;
		}
		tr:nth-child(even) {
 						 background-color: #dddddd;
		}
		</style>
	</head>

	<body style="background-color:gray; padding-top: 200px; ">
	<div class = "container-fluid">
			<div class="row">
				<div class="col-sm-4" style="background-color:clear;"></div>
				<div class="col-sm-4" style="background-color:white;border-style:solid;border-color:blue; border-width:thick;">
				
					<form action="${pageContext.servletContext.contextPath}/cart" method="post">
						<h1 style="text-align:center">Your Cart Page</h1><br/><br />
						<input name="store" type="Submit" value="Back to Store" />
						<input name="checkOut" type="Submit" value="Checkout" />
						<input name="cancelOrder" type="Submit" value="Cancel Order" />
						<input name="accountNumber" type="Hidden" value="${accountNumber}"/>
						
						<table>
							<th>Item Name</th>
							<th>Item Quantity</th>
							<th>Item Price</th>
							<c:forEach items="${cartModel.itemArrayList}" var="item">
								<tr>
									<td>${item.itemName}</td>
									<td>${item.numInOrder}</td>
									<td>${item.price}</td>
								</tr>
							</c:forEach>
						</table>
						<span style="color:blue; font-size:20px;">Your Order's Total Price: $${cartModel.price }</span>
					</form>		
					<span class = ErrorMessage>${model.errorMessage}</span>
				</div>
				<div class="col-sm-4" style="background-color:clear;"></div>
			</div>	
		</div>
	</body>
</html>
