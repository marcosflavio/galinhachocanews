<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar nova Se��o</title>
</head>
<body>

	<form action="insertSection" method="post">
		T�tulo: <input type="text" name="title" /> <br /> Descri��o: <input
			type="text" name="description" /> <br /> <input type="submit"
			value="Cadastrar" />
	</form>


</body>
</html>