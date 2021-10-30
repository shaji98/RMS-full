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
</style>

</head>
<body>
<%@page import="java.sql.*,calldatabase.*" %>
<table class="center">
<tr>
<td>
<ul>
<li><a class="active" href="adminhome.html">Home</a></li>
<li><a href="addtables.html">Add Table</a></li>
<li><a href="update.html">Update Table</a></li>
<li><a href="delete.html">Delete Table</a></li>
<li><a href="showstatus.jsp">Booking Status</a></li>
<li><a href="adminlogin.html">Logout</a></li>
</ul>
</td>
</tr>
</table>
<table border="2" id="table1">
<tr bgcolor="lightblue"><th colspan="7">Seat Booking Info</th></tr>
<tr><td>Table No</td><td>Size of the Table</td><td>Cost</td><td>Facility</td><td>Status</td></tr>
<%
try{
	Connection cn=GetData.getCn();
	PreparedStatement ps=cn.prepareStatement("select * from table1");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>

</body>
</html>