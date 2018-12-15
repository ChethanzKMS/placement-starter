<%@page import="com.sun.xml.internal.txw2.Document"%>
<html>
<head>
<title>Delete Student</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<% String deleteStatus = (String)request.getAttribute("delete_Status");
//System.out.print(addStatus);
%>
<body>
<div id="wrapper">
<div id="header">
<a href="po_home.jsp" style="float: right"><img src="images/back-home.png" alt="" /></a>
<center><h2>Placement Cell - [MYCEM]</h2><h2> Delete a Student</h2></center>
</div>
</div>
<br/>
<center>
<% if(deleteStatus != null && deleteStatus.equals("success")) { %>
<h2>Student Deleted Successfully!</h2>
<% } %>

<% if(deleteStatus != null && deleteStatus.equals("failure")) { %>
<h2>Student Details not Found!</h2>
<% } %>

<form action="DeleteStudentServlet" method="get">
<h2>Enter the USN to Delete:</h2>
<input type="text" name="usn" required="required" maxlength="10" required /><br/><br/>
<input type="submit" value="Delete Student" class="add-student-button" onclick="if(!(confirm('Are you sure you want to delete this Student?'))) return false"/>
</form>
</center>
</body>
</html>