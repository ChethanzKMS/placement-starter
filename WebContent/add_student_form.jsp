<html>
<head>
<title>Add Student</title>
<link type="text/css" rel="stylesheet" href="css/style1.css">
</head>
<% String addStatus = (String)request.getAttribute("add_Status");
//System.out.print(addStatus);
%>
<body>
<div id="wrapper">
<div id="header">
<a href="po_home.jsp" style="float: right"><img src="images/back-home.png" alt="" /></a>
<center><h2>Placement Cell-[College Name]</h2>
<h2>Add a Student</h2></center>
</div>
</div>
<div id="container">
<div id="content">
<center>
<% if(addStatus != null && addStatus.equals("success")) { %>
<h3>Student Added Successfully!</h3>
<% } %>
<form action="StudentLoginServlet" method="GET" >
<table border="1">
<tr>
<td style="width:240px">University Seat Number:</td>
<td style="width:240px"><input type="text" name="usnCred" required="required"/></td>
</tr>
<tr>
<td style="width:240px">Default Password:</td>
<td style="width:240px"> <input type="text" name="defaultPwd" required="required"/></td>
</tr>
</table>
<br/>
<br/>
<input type="submit" value="Add Student" class="add-student-button"/>
</form>
</center>
</div>
</div>
</body>
</html>