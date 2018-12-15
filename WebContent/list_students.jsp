<%@ page import="java.util.*, com.web.placement.*" %>
<!DOCTYPE html>
<html>
<head>
<title>List of Students</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<%
List<Student> theStudents=(List<Student>) request.getAttribute("STUDENTS_LIST");
List<String> emailId = new ArrayList<String>(); 
%>
<body>
<div id="wrapper">
<div id="header">
<a href="po_home.jsp" style="float: right"><img src="images/back-home.png" alt="" /></a>
<center>
<h2> [College Name] </h2>
<h2>Student's List</h2>
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
</tr>
<% for(Student tempStudent:theStudents) { %>
<tr>
<td><%= tempStudent.getUSN() %></td>
<td><%= tempStudent.getFirstName() %></td>
<td><%= tempStudent.getLastName() %></td>
<td><%= tempStudent.getBranch() %></td>
<td><%= tempStudent.getDateOfBirth() %></td>
<td><%= tempStudent.getEmailID() %></td>
<td><%= tempStudent.getPhoneNumber() %></td>
<td><%= tempStudent.getAddress() %></td>
<td><%= tempStudent.getSslcPercentage() %></td>
<td><%= tempStudent.getPucPercentage() %></td>
<td><%= tempStudent.getCgpa() %></td>
<td><%= tempStudent.getSgpa() %></td>
</tr>
<% 
emailId.add(tempStudent.getEmailID());
} %>
<% System.out.println("From Students List:"+emailId); %>
</table>
<br/>
<% String indicator=(String)request.getAttribute("backButtonNeeded");
if(indicator=="yes") {
%>
<a href="shortlist_students.jsp"><img src="images/back-button.png" alt="" width="116" height="34"/></a>
<br/>
<% } %>
<br/>
<% if(theStudents.size()!=0) { %>
<form action="company_details.jsp">
<%
session.setAttribute("emailList", emailId);
%>
<input type="submit" value="Send Mail...!" class="add-student-button"/>
</form>
<% }%>
</center>
</div>
</div>
</body>
</html>