<html>
<head>
<title>Update Details</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<a href="placement_cell_home.jsp" style="float: right"><img src="images/logout.png" alt="" /></a>
<center><h2> Update Your Details <%=request.getParameter("usn") %> -[MYCEM]</h2>
<h2>Student Details Update Form</h2>
</center>
</div>
</div>
<div id="container">
<div id="content">
<center><form action="StudentDetailsUpdateServlet" method="get">
<table border="1">
<tr>
<th>USN</th>
<th>${STUDENT_DETAILS.USN}</th>
</tr>
<input type="hidden" name="usn" value="${STUDENT_DETAILS.USN}"/>
<tr>
<td>First Name</td>
<td><input type="text" name="fname"  required="required" value="${STUDENT_DETAILS.firstName}"/></td>
</tr>

<tr>
<td>Last Name</td>
<td><input type="text" name="lname"  required="required" value="${STUDENT_DETAILS.lastName}"/></td>
</tr>

<tr>
<td>Date of Birth</td>
<td><input type="text" name="dob"  required="required" value="${STUDENT_DETAILS.dateOfBirth}"/></td>
<tr>

<tr>
<td>Address</td>
<td><input type="text" name="address"  required="required" value="${STUDENT_DETAILS.address}"/></td>
<tr>

<tr>
<td>Email ID</td>
<td><input type="text" name="email"  required="required" value="${STUDENT_DETAILS.emailID}"/></td>
</tr>

<tr>
<td>Phone Number</td>
<td><input type="number" name="phone"  required="required" value="${STUDENT_DETAILS.phoneNumber}"/></td>
</tr>


<tr>
<td>Branch</td>
<td><select name="branch">
<option selected="selected">${STUDENT_DETAILS.branch}</option>
<option>Electronics & Communication</option>
<option>Computer Science</option>
<option>Information Science</option>
<option>Mechanical Engineering</option>
<option>Civil Engineering</option>
</select>
</td>
</tr>



<tr>
<td>SSLC Percentage</td>
<td><input type="number" name="sslc"  required="required" step="any" value="${STUDENT_DETAILS.sslcPercentage}"/></td>
</tr>

<tr>
<td>PUC Percentage</td>
<td><input type="number" name="puc"  required="required" step="any" value="${STUDENT_DETAILS.pucPercentage}"/></td>
</tr>

<tr>
<td>CGPA</td>
<td><input type="number" name="CGPA"  required="required" step="any" value="${STUDENT_DETAILS.cgpa}"/></td>
</tr>

<tr>
<td>SGPA</td>
<td><input type="number" name="SGPA"  required="required" step="any" value="${STUDENT_DETAILS.sgpa}"/></td>
</tr>
</table>
<br/>
<input type="submit" value="Update" class="add-student-button"/>
</form>
</center>
</div>
</div></body>
</html>