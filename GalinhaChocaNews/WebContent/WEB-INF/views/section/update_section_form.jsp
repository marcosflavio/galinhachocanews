<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Seção</title>
</head>
<body>

	<form action="updateSection" method="post">
		<input type="hidden" name="id" value="${section.id}" />
		Título: <input type="text" name="title" value =  "${section.title}"/><br />
		Descrição: <input type="text" name="description" value =  "${section.description}"/><br />
		<br /> <input type="submit" value="Alterar" />
	</form>

</body>
</html>