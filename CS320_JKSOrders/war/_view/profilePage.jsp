
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
							<c:if test="${model.customer}">
							
										<table class = "table">
							<tr>
								<td class="label">First name:</td>
								<td>${model.customerAccount.firstName}</td>
							</tr>
							<tr>
								<td class="label">Account Number:</td>
								<td>${model.customerAccount.accountNumber}</td>
							</tr>
							<tr>
								<td class="label">Phone Number:</td>
								<td>${model.customerAccount.phoneNumber}</td>
							</tr>
							<tr>
								<td class="label">Username:</td>
								<td>${model.customerAccount.login.userName}</td>
							</tr>
							<tr>
								<td class="label">Password:</td>
								<td>${model.customerAccount.login.password}</td>
							</tr>
							<tr>
								<td class="label">Email:</td>
								<td>${model.customerAccount.email}</td>
							</tr>
							<tr>
								<td class="label">Car Make:</td>
								<td>${model.customerAccount.pickUpInfo.car.brand}</td>
							</tr>
							<tr>
								<td class="label">Car Model:</td>
								<td>${model.customerAccount.pickUpInfo.car.type}</td>
							</tr>
							<tr>
								<td class="label">Car Color:</td>
								<td>${model.customerAccount.pickUpInfo.car.color}</td>
							</tr>
							<tr>
								<td class="label"> Car Year:</td>
								<td>${model.customerAccount.pickUpInfo.car.year}</td>
							</tr>
							
						</table>
						<div>
								<select name="sourceOrders">	
										<c:forEach items="${model.customerAccount.orders}" var = "order">
											<option value="${order.orderType}">${order.orderType} : $${order.totalPrice}</option>
										</c:forEach>
									</select>
								<input name = "viewOrder" type = "submit" value = "View Order" />
								<input name="storePage" type="submit" value="Store Page!" />
								<input name="editProfile" type="submit" value="Edit Profile" />
								
								
							</c:if>
							
							<c:if test="${model.employee}">
							
									
										<table class = "table">
							<tr>
								<td class="label">First name:</td>
								<td>${model.employeeAccount.firstName}</td>
							</tr>
							<tr>
								<td class="label">Account Number:</td>
								<td>${model.employeeAccount.accountNumber}</td>
							</tr>
							<tr>
								<td class="label">Phone Number:</td>
								<td>${model.employeeAccount.phoneNumber}</td>
							</tr>
							<tr>
								<td class="label">Username:</td>
								<td>${model.employeeAccount.login.userName}</td>
							</tr>
							<tr>
								<td class="label">Password:</td>
								<td>${model.employeeAccount.login.password}</td>
							</tr>
							<tr>
								<td class="label">Email:</td>
								<td>${model.employeeAccount.email}</td>
							</tr>
						<div>
								<input name="workPage" type="submit" value="Work Page!"/>
								<input name="editProfile" type="submit" value="Edit Profile" />
							
							</c:if>	
								
						</div>
					</form>
	
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>