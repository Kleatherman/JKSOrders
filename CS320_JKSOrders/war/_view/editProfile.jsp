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
            <h5 class="card-title text-center">Edit Account</h5>
            
            <form action="${pageContext.servletContext.contextPath}/editProfile" method="post">
             
             <c:if test="${model.customer}">
             
             	<div class="form-label-group">
                <input type="name" id="userName" class="form-control"  placeholder="userName" name = "Username" required autofocus>
                <label for="userName">Name</label>
              </div>

				<div class="form-label-group">
                <input type="name" id="inputName" class="form-control"  placeholder="Name" name = "name" required autofocus>
                <label for="inputName">Name</label>
              </div>
             </c:if>
              
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" name = "email" placeholder="Email address" required autofocus>
                <label for="inputEmail">Email address</label>
              </div>
              
              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" name = "password" placeholder="Password" required autofocus>
                <label for="inputPassword">Password</label>
              </div>

				<div class="form-label-group">
                <input type="phoneNumber" id="inputphoneNumber" class="form-control" name = "number" placeholder="Phone Number" required autofocus>
                <label for="inputphoneNumber">Phone Number</label>
              </div>
             <c:if test="${model.customer}">
              <div class="form-label-group">
                <input type="name" id="inputcarMake" class="form-control" name = "carmake" placeholder="Car Make" required autofocus>
                <label for="inputcarMake">Car Make</label>
              </div>
              
               <div class="form-label-group">
                <input type="name" id="inputcarModel" class="form-control" name = "carmodel" placeholder="Car Model" required autofocus>
                <label for="inputcarModel">Car Model</label>
              </div>
              
               <div class="form-label-group">
                <input type="name" id="inputcarColor" class="form-control" name = "carcolor" placeholder="Car Color" required autofocus>
                <label for="inputcarColor">Car Color</label>
              </div>
              
               <div class="form-label-group">
                <input type="number" id="inputcarYear" class="form-control" name = "caryear" placeholder="Car Model Year" required autofocus>
                <label for="inputcarYear">Car Model Year</label>
              </div>
             </c:if>
              
  
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name = "EditPage" > Edit Profile</button>
               <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name = "ProfilePage" formnovalidate >Go Back</button>
              <hr class="my-4">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>