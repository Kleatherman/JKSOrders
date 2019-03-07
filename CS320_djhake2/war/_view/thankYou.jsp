<!DOCTYPE html>
<html>
	<head>
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