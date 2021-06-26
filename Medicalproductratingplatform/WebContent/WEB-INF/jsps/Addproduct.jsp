<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sb" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Product</title>


<style type="text/css">
label {
	display: inline-block;
	width: 200px;
	margin: 5px 5px 5px 5px ;
	text-align: left;
	
}
</style>
</head>
<body>
<div align="left">
<h1>Add a Product</h1>
</div>
<sb:form action="commitproduct" method="post" modelAttribute="pb">
            <sb:label path="patientname">Name</sb:label>
<sb:input path="patientname"/><sb:errors path="patientname"></sb:errors><br/>
           <sb:label path="productname">ProductName</sb:label>
<sb:select path="productname" items="${productname}"/><sb:errors path="productname"></sb:errors><br/>
            <sb:label path="rating">Rating for the product</sb:label>
<sb:input path="rating"/><sb:errors path="rating"></sb:errors><br/>

<input type="submit" value="Submit"><br/>


</sb:form>

</body>
</html>