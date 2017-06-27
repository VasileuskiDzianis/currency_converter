<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<html>
<head>
<title>Конвертер валют</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/convert_ajax.js"/>"></script>
</head>

<body>
	<h1>Конвертер валют</h1>

	<div>
		Текущая валюта: 
		<select name="source_currency">
			<c:forEach var="rate" items="${rateList}">
				<option value="${rate.id}">${rate.abbreviation}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		Сумма:
		<input type="text" name="amount_field"/>
		<button type="button" onclick="convert()">Сконвертировать</button>
	</div>
	
	<div>
		Целевая валюта: 
		<select name="target_currency">
			<c:forEach var="rate" items="${rateList}">
				<option value="${rate.id}">${rate.abbreviation}</option>
			</c:forEach>
		</select>
	</div>
	
	<div>
		Результат:
		<input type="text" name="result_field"/>
	</div>
	

	<h2>Актуальные курсы валют НБРБ</h2>
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
