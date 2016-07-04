<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Papeis</title>
</head>
<body>

	<table border="1">
		<tr>
		<td>Id</td>
		<td>Papel</td>
 		<td>Opção 1</td> 
 		<td>Opção 2</td> 
	</tr>
	
	<c:forEach var="r" items="${roles}">
	<tr>
		<td>${r.id}</td>
		<td>${r.role}</td>
 		<td><a href="updateRoleForm?id=${r.id}">Aterar</a></td> 
 		<td><a href="removeRole?id=${r.id}">Remover</a></td> 
	</tr>
	</c:forEach>
</table>
	
</body>
</html>