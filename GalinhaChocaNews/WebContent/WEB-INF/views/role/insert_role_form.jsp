<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Novo Papel</title>
</head>
<body>

	<form action="insertRole" method="post">
		Papel: <input type="text" name="role" />
		<form:errors path="role.role" /> 
		<br />
		<input type="submit" value="Inserir" />
	</form>

</body>
</html>