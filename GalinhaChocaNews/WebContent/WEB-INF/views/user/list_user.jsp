<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Usuários Cadastrados</title>
</head>
<body>
	
	<table border="1">
		<tr>
		<td>Id</td>
		<td>Nome</td>
 		<td>Email</td> 
 		<td>Login</td>
 		<td>Senha</td>
 		<td>Papel</td>
 		<td>Opção 1</td>
 		<td>Opção 2</td> 
	</tr>
	
	<c:forEach var="u" items="${users}">
	<tr>
		<td>${u.id}</td>
		<td>${u.name}</td>
		<td>${u.email}</td>
		<td>${u.login}</td>
		<td>${u.password}</td>
		<td>${u.role}</td>
  		<td><a href="updateUserForm?id=${u.id}">Aterar</a></td>  
 		<td><a href="removeUser?id=${u.id}">Remover</a></td> 
 		<td> <img alt="${u.name}" src="<c:url value="/resources/images/${u.login}.png"/>" /></td>
	</tr>
	</c:forEach>
</table>
	
	
</body>
</html>