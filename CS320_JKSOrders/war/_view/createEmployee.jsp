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
            <h5 class="card-title text-center">Add an Employee</h5>
            
             

            
	<form action="${pageContext.servletContext.contextPath}/createEmployee" method="post">
	
 				<div class="form-label-group">
                <input type="text" id="inputUsername" class="form-control"  name = "username" placeholder="UserName" required autofocus>
                <label for="inputUsername">UserName</label>
              </div>

				

				<div class="form-label-group">
                <input type="name" id="inputname" class="form-control" name = "name" placeholder="Name" required autofocus>
                <label for="inputName">Name</label>
              </div>
              
              <input name="manager" type="checkbox" value="Manager" />Manager<br><br>
              
              
  
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name="createAccount"  >Create Employee Account </button>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name = "workPage" formnovalidate  >Go Back</button>
              
              <hr class="my-4">
            </form>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>