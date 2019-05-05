<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">




<div class="container"  style="text-align:center;">
	<div class="row">
  		<div class="card border-0 shadow w-100 my-5"  style="background-color:#cccccc;display:inline-block;"  >
    		<div class="card-body p-5">
  				<div class="centered text-center" >
					<div>
						<form action="${pageContext.servletContext.contextPath}/fulfillOrder" method="post">
							<ul class="pagination justify-content-center">
							<h1 align="center">Fulfill Order Page</h1><br/><br />
							<input name="customerAccountNumber" type="Hidden" value="${model.customer.accountNumber}"/>
							<input name="orderNumber" type="Hidden" value="${model.order.orderType}"/>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class = "col-sm-6">
			<div class="card border-0 w-100 shadow my-5"  style="background-color:#cccccc;display:inline-block;"  >
				<div class="card-body p-5">
  					<div class="centered text-center" >
						<h2>Order: ${model.order.orderType}</h2>
				
				
						
						<span  style="color:#007bff; text-align:center"; font-size:40px;"><b>Order Status: <c:choose><c:when test="${model.order.complete}">Complete</c:when><c:otherwise>Pending</c:otherwise></c:choose></b></span>
				
						<table align="center" class="table">
							<tr>
								<th>Item</th>
								<th>Item UPC</th>
								<th>Location</th>
								<th>Quantity</th>
							</tr>
							<c:forEach items="${model.order.itemList}" var="item">
								<tr>
									<td>${item.itemName}</td>
									<td>${item.UPC}</td>
									<td>${item.location}</td>
									<td>${item.numInOrder}</td>
								</tr>
							</c:forEach>
						</table>
						<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name = "fulfilledOrder" formnovalidate >Order Is Complete</button>
						
					</div>
				</div>
			</div>
		</div>
		<div class = "col-sm-6">
			<div class="card border-0 w-100 shadow my-5"  style="background-color:#cccccc;display:inline-block;"  >
				<div class="card-body p-5">
  					<div class="centered text-center" >
						<h2>Customer: ${model.customer.firstName} ${model.customer.lastName}</h2>
						<span  style="color:#007bff; text-align:center"; font-size:40px;"><b>Customer Car</b></span>
				
						<table align="center" class="table">
							<tr>
								<th>Brand</th>
								<th>Type</th>
								<th>Color</th>
								<th>Year</th>
							</tr>
							<tr>
								<td>${model.car.brand}</td>
								<td>${model.car.type}</td>
								<td>${model.car.color}</td>
								<td>${model.car.year}</td>
						</table>
						<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name = "workPage" formnovalidate >Back to WorkPage</button>
						
						
					</form>		
					<span class = ErrorMessage>${model.errorMessage}</span>
			    	</div>
				</div>
			</div>	
		</div>
    </div>
</div>
</html>