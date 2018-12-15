<%@ page import="java.util.*, com.web.placement.*" %>
<html>
<head>
<title>Company Details</title>
<link type="text/css" rel="stylesheet" href="css/style1.css">
</head>
<body>
<% 
ArrayList emailId = (ArrayList)session.getAttribute("emailList");
String emailIdString="";
for(int i=0;i<emailId.size();i++) {
	emailIdString=emailIdString+emailId.get(i)+",";
}
//System.out.println("From Company Details: "+emailId);
//System.out.println("String:"+emailIdString);
%>

<div id="wrapper">
<div id="header">
<a href="placement_cell_home.jsp" style="float: right"><img src="images/logout.png" alt="" /></a>
<center><h2> Placement Cell -[College Name]</h2>
<h2>Company Details Form</h2>
</center>
</div>
</div>
<div id="container">
<div id="content">
<center><form action="SendMailServlet" method="post">
<table border="1">
<tr>
<td>Company Name</td>
<td><input type="text" name="companyName"  required="required"/></td>
</tr>
<tr>
<td>Date of Visit</td>
<td><input type="text" name="dateOfVisit"  required="required"/></td>
</tr>
<tr>
<td>Reporting Time</td>
<td><input type="text" name="reportingTime"  required="required"/></td>
</tr>
<tr>
<td>Location</td>
<td><input type="text" name="location"  required="required"/></td>
</tr>
<tr>
<td>Additional Information</td>
<td><input type="textbox" name="additional_Info" /></td>
</tr>
</table>
<br/>
<input type="hidden" name="emailIds" value="<%=emailIdString%>" />
<input type="submit" value="Send!" class="add-student-button" />
</form>
</center>
</div>
</div>
</body>
</html>