<html>
<head>
<title>Login Page</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<a href="placement_cell_home.jsp" style="float: right"><img src="images/back-home.png" alt="" /></a>
<center>
<h2> Welcome Placement Officer</h2>
<h2>[College Name]</h2>
</center>
</div>
</div>
<br/>
<center>
<form action="POLoginServlet" method="post">
Enter the Admin ID:<input type="text" name="adminID"/><br/><br/>
Enter the Password:<input type="password" name="adminpwd"/><br/><br/>
<input type="submit" value="Login" class="add-student-button"/>
</form>
</center>
</body>
</html>