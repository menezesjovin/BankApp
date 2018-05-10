<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert ti</title>
</head>
<body>
<form action="PasswordController">
<center><h3>Change Password</h3></center>
<center>
<table>

<tr>
<td>old password </td>
<td><input  type="password" name="opw" required/></td>
</tr>
<tr>
<td>new password </td>
<td><input  type="password" name="npw" required/></td>
</tr>
<tr>
<td>confirm new password </td>
<td><input  type="password" name="cnpw" required/></td>
</tr>
<tr>

<td><input  type="submit" value="CHANGE"/></td>

</tr>
</table>
</center>
</form>
</body>
</html>