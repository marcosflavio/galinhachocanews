<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhar Usuário</title>
</head>
<body>
	<h2>Usuário Detalhado</h2>
		<table border="1">
		<tr>
		<td>Id</td>
		<td>Nome</td>
 		<td>Email</td> 
 		<td>Login</td>
 		<td>Senha</td>
 		<td>Papel</td>
	</tr>
	
	<tr>
		<td>${user.id}</td>
		<td>${user.name}</td>
		<td>${user.email}</td>
		<td>${user.login}</td>
		<td>${user.password}</td>
		<td>${user.role}</td>
	</tr>
</table>
	
	
	
</body>
</html>