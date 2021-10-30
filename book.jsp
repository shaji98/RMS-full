<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
	margin-left: auto;
	margin-right: auto;
}

ul{
list-style-type: none;
margin: 0;
padding: 0;
overflow:hidden;
background-color: #333;
}

li{
float: left;
}

li a{
display: block;
color: white;
text-align: center;
padding: 14px 16px;
text-decoration: none;
}
li a:hover {
	background-color: red;
	
}
body{
background-image:
url('bg.jpg');
background-repeat: no-repeat;
background-attachment: fixed;
background-size: 100% 100%;
 }
#table1 {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#table1 td, #table1 th {
text-align: center;
  border: 1px solid #ddd;
  padding: 8px;
}

#table1 tr:nth-child(even){background-color: #f2f2f2;}

#table1 tr:hover {background-color: #ddd;}

#table1 th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #04AA6D;
  color: white;
}
input[type=submit]{
 background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
input[type=submit]:hover {
  background-color: blue;
}
</style>
</head>
<body>
<%@page import="java.sql.*,calldatabase.*" %>
<table class="center">
<tr>
<td>
<ul>
<li><a class="active" href="userhome.html">Home</a></li>
<li><a href="specialmenu.html">Special Menu</a></li>
<li><a href="chefs.html">Chefs</a></li>
<li><a href="book.jsp">Contact Us</a></li>
<li><a href="foodgallery.html">Food Gallery</a></li>
<li><a href="userlogin.html">Logout</a></li>
</ul>
</td>
</tr>
</table>
<center><h2>Book your seat...</h2></center>
<hr>
<form action="Book">
<table border="1" id="table1">
<tr><th>Size of Table</th><th>Cost</th><th>Facility</th><th>Select</th></tr>
<%
try{
	Connection cn=GetData.getCn();
	PreparedStatement ps=cn.prepareStatement("select  size,cost,facility,sid from table1 where status='free'");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><input type="radio" name="sc" value=<%=rs.getString(4) %>></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
}
	%>
<tr><td colspan="5"><input type="submit" id="sub"value="Reserve"></td></tr>
</table>
</form>
<br><br><br>
<center><h2>Contact Us</h2></center>
<hr>
<center>
<table border="2" bgcolor="#4CAF50">
<tr>
<td>Phone number</td><td>943398608</td><td><img src="download.png" height="50" width="50"></td>
</tr>
<tr>
<td>Email</td><td>mommaskitchen@gmail.com</td><td><img src="download (1).png" height="50" width="50"></td>
</tr>
<tr>
<td>Twitter</td><td>mommaskitchen</td><td><img src="th (2).jpg" height="50" width="50"></td>
</tr>
</table>
</center>
</body>
</html>