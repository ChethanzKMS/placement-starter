<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
<link type="text/css" rel="stylesheet" href="css/style3.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<a href="placement_cell_home.jsp" style="float: right"><img src="images/logout.png" alt="" /></a>
<center><h2>Placement Cell- [College Name] </h2>
<h2>Upload Your Resume</h2>
</center>
</div>
</div>
<div id="container">
<div id="content">
<center>
<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
Browse Resume: <input type="file" name="resume" /><br/>
<input type="hidden" value="Hello" name="usn_number"/><br/>
<input type="submit" value="Upload" class="add-student-button"/>
</form>
</center>
</div>
</div>
</body>
</html>