<html>
<head>
<title>Eligibility Form</title>
<link type="text/css" rel="stylesheet" href="css/style2.css">
</head>
<body>

<div id="wrapper">
<div id="header">
<a href="po_home.jsp" style="float: right"><img src="images/back-home.png" alt="" /></a>
<center>
<h2> [College Name]</h2>
<h2>Criteria Form</h2>
</center>
</div>
</div>
<center>
<form action="ShortListedStudentsServlet" method="post">
<div id="container">
<div id="content">
<table border="1">
<tr>
<td style="width:240px">10th Standard Cutoff Percentage[%]</td>
<td style="width:240px"><input type="number" name="sslcCutoff" required="required" step="any"/></td>
</tr>
<tr>
<td style="width:240px">PUC Cutoff Percentage[%]</td>
<td style="width:240px"> <input type="number" name="pucCutoff" required="required" step="any"/></td>
</tr>
<td style="width:240px">CGPA Cutoff</td>
<td style="width:240px"><input type="number" name="CGPACutoff" required="required" step="any"/> </td>
</tr>
<tr>
<td style="width:240px">SGPA Cutoff</td>
<td style="width:240px"> <input type="number" name="SGPACutoff" required="required" step="any"/> </td>
<tr>
<td>Branch:</td>
<td><label>All Branches</label>
      <input type="radio" name="branch_type" value="all" required="required"/></td>
</tr>
<div>
    <div>
      <label>Specific Branch</label>
      <input type="radio" name="branch_type" value="specific"/>
		<div class="forspecific_branch">
		<input type="checkbox" name="branch" value="Electronics & Communication" />
        <label>Electronics & Communication</label>
        <input type="checkbox" name="branch" value="Computer Science"/>
        <label>Computer Science</label>
        <input type="checkbox" name="branch" value="Information Science"/>
        <label>Information Science</label>
        <input type="checkbox" name="branch" value="Mechanical Engineering"/>
        <label>Mechanical Engineering</label>
        <input type="checkbox" name="branch" value="Civil Engineering"/>
        <label>Civil Engineering</label>
        <br/><br/>
      	</div>
     </div>
</div>
</table>
</div></div>
<br/>
<input type="submit" value="Search Students" class="add-student-button"/>
</form>
</center>
 </body>
 </html>