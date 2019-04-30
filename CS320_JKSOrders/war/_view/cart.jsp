<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
	style
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">




<div class="container"  style="text-align:center;">
  <div class="card border-0 shadow my-5"  style="background-color:#cccccc;display:inline-block;"  >
    <div class="card-body p-5">
  		<div class="centered text-center" >
				<div class="row" >
	
				
					<form action="${pageContext.servletContext.contextPath}/cart" method="post">
						<h1 align="center">Your Cart Page</h1><br/><br />
						<input name="accountNumber" type="Hidden" value="${accountNumber}"/>
						
						<ul class="pagination justify-content-center">
						
						
					
						<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name = "store" formnovalidate >Back to Store</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button  class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name = "checkOut" formnovalidate >Checkout</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name = "cancelOrder" formnovalidate >Cancel Order</button>
						
						</div>
						
						<table  align="center">
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
						<span  style="color:blue; text-align:center"; font-size:20px;">Your Order's Total Price: $${cartModel.price }</span>
					</form>		
					<span class = ErrorMessage>${model.errorMessage}</span>
				</div>
			</div>	
		</div>
    </div>

</html>