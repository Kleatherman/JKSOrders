<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<form action="${pageContext.servletContext.contextPath}/storePage" method="post">
    <!-- Page Heading -->

    <h1 class="my-4">JKS Orders
        <small>Inventory</small>
      </h1>

    <c:forEach items="${model.items}" var="item">
		
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
                </a>
            </div>
            <div class="col-md-5">
                <h3>${item.itemName}</h3>
                <p>${item.description}</p>
                 ${item.price}
          		<input name="${item.itemName}Quantity" type="number" min="0" max="${item.numInInventory}" /><p><br /></p>
       			<button class="btn btn-lg btn-primary btn-block" style="width: 300px;" style="height: 2px;" type="submit" name="${item.itemName}">Add ${item.itemName} To Cart</button>
       			<p><br /><br /></p>
       			
            </div>

       		</div>
  			<br><br><br>
    </c:forEach>
 	
	
    <div style="color: red">${errorMessage}</div><br />
    <ul class="pagination justify-content-center">
 
	<p><br /><br /><br /></p>
			
            	<button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 3px;" type="submit" name="checkOut"> Check Out </button>
            	&nbsp;&nbsp;&nbsp;&nbsp;
            	<button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="profilePage"> Profile Page </button>
            	&nbsp;&nbsp;&nbsp;&nbsp;
                <button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="logOut"> Log Out </button>
                &nbsp;&nbsp;&nbsp;&nbsp;
           		<button class="btn btn-lg btn-primary btn-block text-uppercase" style="width: 300px;" style="height: 300px;" type="submit" name="cart"> My Cart </button>
           
                <input name="accountNumber" type="hidden" value="${accountNumber}" />
				
				
 		   	         

    <!-- /.container -->

    </html>


