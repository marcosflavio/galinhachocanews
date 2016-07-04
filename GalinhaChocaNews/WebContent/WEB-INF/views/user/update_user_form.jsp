<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar dados do Usuário</title>
</head>
<body>

	<form action="updateUser" method="post">
		<input type="hidden" name="id" value="${user.id}" /> 
		Nome: <input type="text" name="name" value="${user.name}" /> <br /> 
		Email: <input type="text" name="email" value="${user.email}" /> <br /> 
		Login: <input type="text" name="login" value="${user.login}" /> <br /> 
		Senha: <input type="text" name="password" value="${user.password}" /> <br />
		Papel: <input type="text" name="roleAux" value="${user.roleId}" /> <br />  
		<input type="submit" value="Alterar" />
	</form>


</body>
</html>