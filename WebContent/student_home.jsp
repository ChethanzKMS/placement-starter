<%@ page import="java.util.*, com.web.placement.*" %>
<html>
<head>
<title>Student Home</title>
<link type="text/css" rel="stylesheet" href="css/style3.css">
</head>

<%
Student theStudent= (Student)request.getAttribute("student_details");
%>

<body>
<div id="wrapper">
<div id="header">
<a href="placement_cell_home.jsp" style="float: right"><img src="images/logout.png" alt="" /></a>
<center><h2> Welcome <%=request.getParameter("usn") %> -[MYCEM]</h2>
<h2>Student's Detatils</h2>
</center>
</div>
</div>
<div id="container">
<div id="content">
<center>
<table border="1">
<tr>
<th>USN</th>
<th>First Name</th>
<th>Last Name</th>
<th>Branch</th>
<th>D.O.B</th>
<th>Email ID</th>
<th>Phone Number</th>
<th>Address</th>
<th>SSLC Percentage</th>
<th>PUC Percentage</th>
<th>CGPA</th>
<th>SGPA</th>
<th>Action</th>
</tr>
<tr>
<td><%=theStudent.getUSN() %></td>
<td><%=theStudent.getFirstName() %></td>
<td><%=theStudent.getLastName() %></td>
<td><%=theStudent.getBranch() %></td>
<td><%=theStudent.getDateOfBirth() %></td>
<td><%=theStudent.getEmailID() %></td>
<td><%=theStudent.getPhoneNumber() %></td>
<td><%=theStudent.getAddress() %></td>
<td><%=theStudent.getSslcPercentage() %></td>
<td><%=theStudent.getPucPercentage() %></td>
<td><%=theStudent.getCgpa() %></td>
<td><%=theStudent.getSgpa() %></td>
<td>
<form action="StudentDetailsUpdateServlet" method="post">
<input type="hidden" value=<%=request.getParameter("usn") %> name="usn"/>
<input type="image" name="submit" src="images/edit-icon.png" alt="Submit" width="41" height="41" />
</form>
<form action="file_upload_form.jsp">
<input type="hidden" value=<%=request.getParameter("usn") %> name="usn"/>
<input type="image" name="submit" src="images/upload.png" alt="Submit" width="41" height="41" />
</form>
</td>
</tr>
</table>
</center>
</div>
</div>
</body>
</html>