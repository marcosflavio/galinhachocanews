<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Classificado</title>
</head>
<body>

	<form action="updateAds" method="post">
		<input type="hidden" name="id" value="${ads.id}" />
		 Título: <input type="text" name="title" value="${ads.title}" /><br />
		 Texto: <input type="text" name="text" value="${ads.text}" /><br />
		 Price: <input type="text" name="price" value="${ads.price}" /><br />
		 Telefone: <input type="text" name="tellephone" value="${ads.tellephone}" /><br />
		<input type="submit" value="Alterar" />
	</form>

</body>
</html>