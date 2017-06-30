<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<html>
<head>
<title>Конвертер валют</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/converter.css"/>" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/convert_ajax.js"/>"></script>
</head>

<body>
	
	<form class="form-container">
		<div class="form-title">
			<h2>Конвертер валют</h2>
		</div>
		
		<div class="form-title">Текущая валюта:</div>
		<select class="form-field" name="source_currency">
			<c:forEach var="rate" items="${rateList}">
				<option value="${rate.id}">${rate.abbreviation}</option>
			</c:forEach>
		</select>
		
		<div class="form-title">Сумма:</div>
		<input class="form-field" type="text" name="amount_field" /><br />
		
		<div class="form-title">Целевая валюта:</div>
		<select class="form-field" name="target_currency">
			<c:forEach var="rate" items="${rateList}">
				<option value="${rate.id}">${rate.abbreviation}</option>
			</c:forEach>
		</select>
		
		<div class="submit-container">
			<button class="submit-button" type="button" onclick="convert()">Сконвертировать</button>
		</div>
		
		<div class="form-title">Результат:</div>
		<input class="form-field" type="text" name="result_field" />
		
	</form>

	<div class="rates-container">
	<h2>Актуальные курсы валют НБРБ</h2>
	<table>
		<c:forEach var="rate" items="${rateList}">
			<tr>
				<td>${rate.abbreviation} ${rate.scale} ${rate.name}</td>
				<td>${rate.officialRate}</td>
			</tr>

		</c:forEach>
	</table>
	</div>
	
</body>
</html>
