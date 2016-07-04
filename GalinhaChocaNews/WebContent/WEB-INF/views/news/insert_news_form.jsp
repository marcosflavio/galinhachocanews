<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Nova Notícias</title>
</head>
<body>

	<form action="insertNews" method="post">
		Título: <input type="text" name="title" /> <br />
	    Sub-Título: <input type="text" name="subTitle" /> <br />
	    Texto: <input type="text" name="text" /> <br />
	    Seção: <input type="text" name="idSection" /> <br />
	    <input type="submit" value="Criar" />
	</form>	
	
</body>
</html>