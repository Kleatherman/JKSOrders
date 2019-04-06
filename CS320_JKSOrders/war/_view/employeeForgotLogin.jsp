
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<head>

<body style="background-color:#cccccc;">
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Recover Password</h5>
            
            <c:if test="${! empty errorMessage}">
						<div class="error">${errorMessage}</div>
					</c:if>
            
	<form formnovalidate action="${pageContext.servletContext.contextPath}/customerForgotLogin" method="post">
		 <div class="form-label-group">
                <input type="emailAddress" id="inputuserName" name="Username" class="form-control" placeholder="Username" required autofocus>
                <label for="inputuserName">Email address</label>
              </div>

              <div class="form-label-group">
                <input type="phoneNumber" id="inputPhoneNumber" class="form-control"  name="Phone" placeholder="Phone Number" required>
                <label for="inputPhoneNumber">Phone Number</label>
              </div>
         
              <button class="btn btn-lg btn-primary btn-block text-uppercase" formnovalidate name="LoginPage"  value="LoginPage" type="submit">Go Back</button>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" name="submit" value="submit" type="submit">Recover Password</button>
             
			 ${result}
								
              <hr class="my-4">
            
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>