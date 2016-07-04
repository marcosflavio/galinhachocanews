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

	<table border="1">
		<tr>
			<td>Id</td>
			<td>Título</td>
			<td>Texto</td>
			<td>Preço</td>
			<td>Telefone</td>
			<td>Autor</td>
			<td>Opção 1</td>
			<td>Opção 2</td>
		</tr>

		<c:forEach var="a" items="${adsList}">
			<tr>
				<td>${a.id}</td>
				<td>${a.title}</td>
				<td>${a.text}</td>
				<td>${a.price}</td>
				<td>${a.tellephone}</td>
				<td>${a.user}</td>
				<td><a href="updateAdsForm?id=${a.id}">Alterar</a></td> 
 				<td><a href="removeAds?id=${a.id}">Remover</a></td> 
			</tr>
		</c:forEach>
	</table>


</body>
</html>