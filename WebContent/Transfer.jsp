<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="TransferController">
<center><h3>Third party transfer</h3></center>
<center>
<table>

<tr>
<td>Third Party Account number </td>
<td><input  type="text" name="tpaccnum" required/></td>
</tr>
<tr>
<td>Transfer Ammount </td>
<td><input  type="text" name="transamt" required/></td>
</tr>

<tr>

<td><input  type="submit" value="TRANSFER"/></td>

</tr>
</table>
</center>
</form>
</body>
</html>