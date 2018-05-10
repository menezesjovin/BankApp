<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
<% 
out.println("Hello,   "+session.getAttribute("name"));
%>
</h1>
</center>
<center>
<table>


<tr>
<td><h3>
<a href="Transfer.jsp">Third Party Tranfer</a></h3>
</td>
</tr>
<br>

<tr>
<td><h3>
<a href="Password.jsp">Change Password</a></h3>
</td>
</tr>
<br>

<tr>
<td><h3>
<a href="BalanceController">Check Balance</a></h3>
</td>
</tr>
<br>
<tr>
<td><h3>
<a href="Loan.jsp">Apply loan</a></h3>
</td>
</tr>
<br>
<tr>
<td><h3>
<a href="StatementController">Mini Statement</a></h3>
</td>
</tr>
<br>
<tr>
<td><h3>
<a href="Logout.jsp">Logout</a></h3>
</td>
</tr>
</table>
</center>
</body>
</html>