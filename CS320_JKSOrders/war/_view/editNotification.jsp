<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
		<meta charset ="utf-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
		<title>Work Page</title>
		<style type="text/css">
		.TitleText2 {
						font-size: 300%;
                        font-weight: bold; 
                        text-align: center;
		}
		
		.ErrorMessage {
						font-size: 150%;
						text-align: center;
						color: red;		
		}
		</style>
	</head>

	<body>
	<div class = "container-fluid">
			<div class="row">
				<div class="col-sm-4" style="background-color:lavender;">space</div>
				<div class="col-sm-4" style="background-color:white;">
					<div class= "TitleText2">Edit Notification ${model.notify.notificationID}</div>
					<form action="${pageContext.servletContext.contextPath}/editNotification" method="post">
						<div>
							<input name="workPage" type="submit" value="Return to Work Page" />
							<input name="update" type="submit" value="Update Notification" />
							<input name="delete" type="submit" value="Delete This Notification" />
							<input name="editNotification" type="hidden" value="${model.notify.notificationID}"/>
							<input name="message" style="height:50px;font-size:14pt;width:150%" type="text" value="${model.notify.message}" /><br>
							<input name="urgency" type="checkbox" />Urgency<br>
						</div>
						
						<h1>Choose New Recipient List</h1>
						<c:forEach items="${model.allNames}" var="name">
							<input name="${name}" type="checkbox" value="${name}" />${name}<br>
						</c:forEach>
					</form>
					<table>
						<tr>
							<th><h1>Current Recipient Names</h1></th>
						</tr>
						<c:forEach items="${model.destinationNames}" var="name">
							<tr>
								<td>${name}</td>
							</tr>
						</c:forEach>
					</table>
					
					<span class = ErrorMessage>${model.errorMessage}</span>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>	
		</div>
	</body>
</html>
