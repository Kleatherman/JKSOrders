<!DOCTYPE html>
<html lag= "en">
	<head>
		<meta charset ="utf-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
		<title>Thank You</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		.text {
			text-align: left;
		}
		
		#MainFormat{
		 				position: absolute;
   						top: 50%;
    					left: 50%;
    					margin-top: -50px;
    					margin-left: -50px;
    					width: 100px;
    					height: 100px;
		}
		#ThankYou {	
						font-size: 300%;
                        font-weight: bold; 
  
		}
		.TitleText {
						font-size: 150%;
                        font-weight: bold; 
		}
		</style>
	</head>

	<body>
		<div id="MainFormat" >
			<span id="ThankYou">Thank You for using our services!</span>
			<span class="TitleText">Your order has been placed</span>
		</div>
		
		<form action="${pageContext.servletContext.contextPath}/thankYou" method="post">
			<div>
				<input type="Submit" name="storePage" value="Close">
			</div>
		</form>
	</body>
</html>