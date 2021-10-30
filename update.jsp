<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-image:
url('multibackground.jpg');
background-repeat: no-repeat;
background-attachment: fixed;
background-size: 100% 100%;
 }
table{
	margin-left: auto;
	margin-right: auto;
}
td {
  text-align: center;
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
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

</style>
</head>
<body>
<%@page import="java.sql.*,calldatabase.*" %>
<form action="Update">
<table>
<tr><th colspan="2">Update Fields</th></tr>
<%
try{
	int id=Integer.parseInt(request.getParameter("sid"));
	session=request.getSession();
	session.setAttribute("sid",id);
	Connection cn=GetData.getCn();
	PreparedStatement ps=cn.prepareStatement("select size,cost,facility from table1 where sid=?");
	ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
%>
<tr><td>Enter new size </td><td><input type="text" name="size" value=<%=rs.getString(1) %>></td></tr>
<tr><td>Enter new cost </td><td><input type="text" name="cost" value=<%=rs.getString(2) %>></td></tr>
<tr><td>Enter new facility </td><td><input type="text" name="facility" value=<%=rs.getString(3) %>></td></tr>
<%}else{ %>
	<font color="red">No record found</font><br>
	<a href="update.html">Back</a>
<% } %>
<%}catch(Exception e){
	out.print(e);
} %>
<tr><td colspan="2"><input type="submit" value="update"></td></tr>
</table>
</form>
</body>
</html>