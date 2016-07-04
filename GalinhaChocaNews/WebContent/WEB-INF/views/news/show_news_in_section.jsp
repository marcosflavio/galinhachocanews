<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notícias</title>
</head>
<body>


	<c:forEach var="n" items="${newsList}">
		<ul>
			<li><a href="showNewsForm?id=${n.id}">${n.title}</a></li>
			<li>${n.subTitle}</li>
		</ul>


	</c:forEach>

	<div>
		<input type=button
			onClick="parent.location='/GalinhaChocaNews'"
			value='Voltar'>
	</div>

</body>
</html>