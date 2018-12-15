<html>
<head>
<title>Student Registration</title>
<link type="text/css" rel="stylesheet" href="css/style1.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<a href="placement_cell_home.jsp" style="float: right"><img src="images/logout.png" alt="" /></a>
<center><h2> Welcome <%=request.getParameter("usn") %> -[MYCEM]</h2>
<h2>Student Registration Form</h2>
</center>
</div>
</div>
<div id="container">
<div id="content">
<center><form action="AddStudentDetailsServlet" method="post">
<input type="hidden" name="usn" value=<%=request.getParameter("usn") %> />
<table border="1">
<tr>
<th>USN</th>
<th><%=request.getParameter("usn") %></th>
</tr>
<tr>
<td>First Name</td>
<td><input type="text" name="fname"  required="required"/></td>
</tr>

<tr>
<td>Last Name</td>
<td><input type="text" name="lname"  required="required"/></td>
</tr>

<tr>
<td>Branch</td>
<td><select name="branch">
<option>Electronics & Communication</option>
<option>Computer Science</option>
<option>Information Science</option>
<option>Mechanical Engineering</option>
<option>Civil Engineering</option>
</select>
</td>
</tr>

<tr>
<td>D.O.B-(DD-MON-YYYY)</td>
<td><input type="text" name="dob"  required="required"/></td>
</tr>

<tr>
<td>Email ID</td>
<td><input type="text" name="email"  required="required"/></td>
</tr>

<tr>
<td>Phone Number</td>
<td><input type="number" name="phone"  required="required"/></td>
</tr>

<tr>
<td>Address</td>
<td><input type="text" name="address"  required="required"/></td>
</tr>

<tr>
<td>SSLC Percentage</td>
<td><input type="number" name="sslc"  required="required" step="any"/></td>
</tr>

<tr>
<td>PUC Percentage</td>
<td><input type="number" name="puc"  required="required" step="any"/></td>
</tr>

<tr>
<td>CGPA</td>
<td><input type="number" name="CGPA"  required="required" step="any"/></td>
</tr>

<tr>
<td>SGPA</td>
<td><input type="number" name="SGPA"  required="required" step="any"/></td>
</tr>

</table><br/>
<input type="submit" value="Add Details" class="add-student-button" />
</form></center>
</div></div>
</body>
</html>