<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
session="false"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

<table>
<c:forEach var="rate" items="${rateList}">
	<tr>
		<td>${rate.abbreviation} ${rate.scale} ${rate.name}</td>
		<td>${rate.officialRate}</td>
	</tr>		
			
</c:forEach>

</table>

</body>
</html>
