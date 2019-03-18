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
			text-align: center;
		}
		.TitleText {
						font-size: 550%;
                        font-weight: bold; 
                        text-align: center;
		}
		.TitleText2 {
						font-size: 300%;
                        font-weight: bold; 
                        text-align: center;
		}
		.SpaceTaker{
		font-size: 3000%;
		}
		</style>
	</head>

	<body>
		<div class = "container-fluid">
			<div class="row">
				<div class="col-sm-4" style="background-color:lavender;">space</div>
				<div class="col-sm-4" style="background-color:white;">
					<div class= "TitleText"> Thank You! </div>
					<div class= "TitleText2"> For shopping with us today </div>
					<form action="${pageContext.servletContext.contextPath}/thankYou" method="post">
						<div>
							<input type="Submit" name="storePage" value="Close">
						</div>
					</form>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">space</div>
			</div>
		</div>
		
	</body>
</html>