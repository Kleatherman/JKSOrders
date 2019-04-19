<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Page Heading -->

    <h1 class="my-4">JKS Orders
        <small>Inventory</small>
      </h1>

    <c:forEach items="${items}" var="item">

        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
                </a>
            </div>
            <div class="col-md-5">
                <h3>${item.itemName}</h3>
                <p>${item.description}</p>
                <a class="btn btn-primary" href="#">AddToCart</a>
            </div>

            <td>${item.price}</td>
            <td>
                <input name="${item.itemName}" type="number" />
            </td>
           
            </tr>
    </c:forEach>
    </hr>
    
    <ul class="pagination justify-content-center">
 
            <div>
            	<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name="checkOut" > CheckOut! </button>
            	<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name="profilePage"> Profile Page! </button>
                <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name="logOut"> LogOut </button>
           		<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name="logOut"> LogOut </button>
                <input name="cart" type="submit" value="My Cart" />
                <input name="accountNumber" type="hidden" value="${accountNumber}" />

                
        </li>
    </ul>

    </div>
    <!-- /.container -->

    </html>


