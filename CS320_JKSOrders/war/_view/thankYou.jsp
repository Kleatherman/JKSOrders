

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
	style
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">



<div class="container"  style="text-align:center;">
  <div class="card border-0 shadow my-5"  style="background-color:#cccccc;display:inline-block;"  >
    <div class="card-body p-5">
  		<div class="centered text-center" >
  		
  			<div class = "container-fluid">
				<div class= "TitleText"> Thank You! </div>
					<div class= "TitleText2"> For shopping with us today </div>
					<form action="${pageContext.servletContext.contextPath}/thankYou" method="post">		
							  <button class="btn btn-lg btn-primary btn-block text-uppercase" name="storePage"  value="Login" type="Submit">Return to Store Page</button>
							  
							<input name="accountNumber" type="hidden" value="${accountNumber}" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>	
	
</html>