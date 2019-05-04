

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
            <h5 class="card-title text-center">Employee Sign In</h5>
            
	<form formnovalidate action="${pageContext.servletContext.contextPath}/employeeLogin" method="post">
	
		 <div class="form-label-group">
                <input type="text" id="inputuserName" value="${model.userName}" name="username" class="form-control" placeholder="Username" required autofocus>
                <label for="inputuserName">Username</label>
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control"  name="pin" value="${model.password}" placeholder="Pin" required autofocus>
                <label for="inputPassword">Pin</label>
              </div>
         
              <button class="btn btn-lg btn-primary btn-block text-uppercase" name="submit"  value="Login" type="submit">Sign in</button>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" formnovalidate name="forgot" value="Forgot Info" type="submit">Forgot Login</button>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" formnovalidate name="createEmployeeAccount" value="Create Account" type="submit">Create Account</button>
              <hr class="my-4">
              <input name="accountNumber" type="hidden" value="${accountNumber}" />
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>