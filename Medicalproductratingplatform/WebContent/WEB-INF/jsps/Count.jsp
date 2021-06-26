<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Info of all products</h1>

<table>
<tr>

<th>CountRating: </th>

</tr>

<s:forEach items="${data}" var="list" >

<tr>

<td>${list}</td>


</tr>

</s:forEach>
</table>

</body>
</html>