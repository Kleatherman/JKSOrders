<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">


<div class="container">
  <div class="card border-0 shadow my-5">
    <div class="card-body p-5">
  	<div class = "container-fluid">
			<div class="row">

				
				
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
						<span style="color:blue; font-size:20px;">Your Order's Total Price: $${cartModel.price }</span>
					</form>		
					<span class = ErrorMessage>${model.errorMessage}</span>
				
				<div class="col-sm-4" style="background-color:clear;"></div>
			</div>	
		</div>
    </div>

</html>