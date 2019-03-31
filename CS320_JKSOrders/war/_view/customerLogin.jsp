
<!DOCTYPE html>

<html lag= "en">
	<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<head>

<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
            
	<form formnovalidate action="${pageContext.servletContext.contextPath}/customerLogin" method="post">
		 <div class="form-label-group">
                <input type="emailAddress" id="inputuserName" value="${model.userName}" name="emailAddress" class="form-control" placeholder="Username" required autofocus>
                <label for="inputuserName">Email address</label>
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control"  name="password" value="${model.password}" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>
         
              <button class="btn btn-lg btn-primary btn-block text-uppercase" name="submit"  value="Login" type="submit">Sign in</button>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" formnovalidate name="forgot" value="Forgot Info" type="submit">Forgot Login</button>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" formnovalidate name="createCustomerAccount" value="Create Account" type="submit">Create Account</button>
              <hr class="my-4">
              <input name="accountNumber" type="hidden" value="${accountNumber}" />
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>