<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Classificados</title>
</head>
<body>


	<c:forEach var="a" items="${adsList}">

		<ul>
			<li><a href="showAdsForm?id=${a.id}">${a.title}</a></li>
			<li>${a.price}</li>
		</ul>

	<div>
		<input type=button
			onClick="parent.location='/GalinhaChocaNews'"
			value='Voltar'>
	</div>

	</c:forEach>


</body>
</html>