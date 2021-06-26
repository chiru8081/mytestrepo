<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Average of Rating</title>
</head>
<body>
<sb:form action="Avg" method="post">
<table>
<tr>
<th>AverageRating:</th>
</tr>
<s:forEach items="${avgdaata}" var="msg" >
<tr>

<td>${msg}</td>

</tr>
</s:forEach>
</table>
</sb:form>
</body>
</html>