<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Notícia</title>
</head>
<body>

		<form action="updateNews" method="post">
		<input type="hidden" name="id" value="${news.id}" />
		 Título: <input type="text" name="title" value="${news.title}" /><br />
		 Subtítulo: <input type="text" name="subTitle" value="${news.subTitle}" /><br />
		 Texto: <input type="text" name="text" value="${news.text}" /><br />
		 Seção: <input type="text" name="idSection" value="${ads.idSection}" /><br />
		<input type="submit" value="Alterar" />
	</form>	

</body>
</html>