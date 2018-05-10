<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>invalid customer name or password</h1></center>
<center><h2>please try again</h2></center>
<center><form action="LoginController">
<table>
<br>
<br>
<tr>
<td>CustomerID </td>
<td><input type="text" name="cusid" required/></td>
</tr>
<tr>
<td>Password </td>
<td><input type="password" name="cuspwd" required/></td>
</tr>

<tr>

<td><input type="submit" value="LOGIN"/></td>
<td><a href="ForgotPassword.jsp">forgot password?</a></td>
</tr>
</table>
</form></center>
</body>
</html>