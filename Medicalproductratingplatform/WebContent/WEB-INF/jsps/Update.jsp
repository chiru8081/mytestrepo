<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<form action="Update" method="post">
<table>
<tr>
<td>Rating:</td>
<td><input type="number" name="rating"></td></tr>
<tr>
<td>ProductName:</td>
<td><input type="text" name="productname"></td></tr>
<tr>
<td>Name:</td>
<td><input type="text" name="patientname"></td></tr>
<tr>
<td><input type="submit" name="update"></td></tr>

</table>

</form>


</body>
</html>