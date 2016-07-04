<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Seções</title>
</head>
<body>
<%-- Usuario logado: ${user_logged_editor.name} --%>
	<table border="1">
		<tr>
		<td>Id</td>
		<td>Título</td>
		<td>Descrição</td>
		<td>Autor</td>
 		<td>Opção 1</td> 
 		<td>Opção 2</td> 
	</tr>
	
	<c:forEach var="s" items="${sections}">
	<tr>
		<td>${s.id}</td>
			<td><a href="showNewsInSection?id=${s.id}">${s.title}</a></td>
		<td>${s.description}</td>
		<td>${s.user}</td>
 		<td><a href="updateSectionForm?id=${s.id}">Alterar</a></td> 
 		<td><a href="removeSection?id=${s.id}">Remover</a></td> 
	</tr>
	</c:forEach>
</table>

</body>
</html>