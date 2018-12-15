<html>
<head>
<title>PO Login</title>
<link type="text/css" rel="stylesheet" href="css/style1.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<a href="placement_cell_home.jsp" style="float: right"><img src="images/logout.png" alt="" /></a>
<center><h2> Welcome Placement Officer</h2>
<h2> [College Name] </h2>
</center>
</div>
</div>
<br/>
<div id="container">
<div id="content">

<center>
<input type="button" value="Add a Student" onclick="window.location.href='add_student_form.jsp';return false;"
class="add-student-button"
/>
</center>
<br/>


<center>
<input type="button" value="Delete a Student" onclick="window.location.href='delete_student_form.jsp';return false;" class="add-student-button"/>
</center>
<br/>

<form action="StudentControllerServlet" method="get">
<center>
<input type="submit" value="View All Students" class="add-student-button"/>
</center>
</form>

<form action="shortlist_students.jsp">
<center>
<input type="submit" value="Shortlist Students" class="add-student-button"/>
</center>
</form>

</div>
</div>
</body>
</html>

