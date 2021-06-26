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
<th>PatientName: </th>
<th>ProductName: </th>
<th>Rating: </th>

</tr>

<s:forEach items="${productdata}" var="bean" >

<tr>
<td><s:out value="${bean.patientname}"></s:out></td>
<td><s:out value="${bean.productname}"></s:out></td>
<td><s:out value="${bean.rating}"></s:out></td>
<td>

<a href="Update">Update</a><br/>  
<a href="Avg">Average of Rating</a><br/>
<a href="Count">Count of Rating</a><br/>
</td>
</tr>

</s:forEach>
</table>
</body>
</html>