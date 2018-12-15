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
<h2> Welcome To Placement Cell-[College Name]</h2>
</center>
</div>
</div>
<br/>
<center>
<form action="StudentLoginServlet" method="post">
---Enter the USN---:<input type="text" name="usn"/><br/><br/>
Enter the Password:<input type="password" name="pwd"/><br/><br/>
<input type="submit" value="Login" class="add-student-button"/>
</form>
</center>
</body>
</html>