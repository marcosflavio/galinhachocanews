<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar novo Usuário</title>
</head>
<body>

	<form action="insertUser" method="post" enctype="multipart/form-data">
		Nome: <input type="text" name="name" />
		<%-- 		<form:errors path="role.role" /> --%>
		<br /> 
		E-mail: <input type="text" name="email" /> <br />
		Login: <input type="text" name="login" /> <br />
		Senha: <input type="password" name="password" /> <br />
		Papel: <input type="text" name="roleAux" /> <br />
		Imagem: <input type="file" name="imagem" /> <br />
		<input type="submit" value="Inserir" />
	</form>


</body>
</html>