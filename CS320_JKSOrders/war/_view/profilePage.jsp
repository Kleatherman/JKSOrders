
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html lag= "en">
	<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<head>


  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">This is your profile page</h5>
            <form action="${pageContext.servletContext.contextPath}/profilePage" method="post">
						<table class = "table">
							<tr>
								<td class="label">First name:</td>
								<td>${Name}</td>
							</tr>
							<tr>
								<td class="label">Account Number:</td>
								<td>${Anumber}</td>
							</tr>
							<tr>
								<td class="label">Phone Number:</td>
								<td>${Pnumber}</td>
							</tr>
							<tr>
								<td class="label">Username:</td>
								<td>${Username}</td>
							</tr>
							<tr>
								<td class="label">Password:</td>
								<td>${password}</td>
							</tr>
						</table>
						<div>
							<c:if test="${isCustomer}">
								<select name="sourceOrders">	
										<c:forEach items="${sourceOrders}" var = "order">
											<option value="${order.orderType}">${order.orderType} : $${order.totalPrice}</option>
										</c:forEach>
									</select>
								<input name = "sourceOrdersSubmit" type = "submit" value = "View Order" />
								<input name="storePage" type="submit" value="Store Page!" />
							</c:if>
							<c:if test="${isEmployee}">
								<input name="workPage" type="submit" value="Work Page!"/>
							</c:if>	
								<input name="accountNumber" type="hidden" value="${accountNumber}" />
						</div>
					</form>
	
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>