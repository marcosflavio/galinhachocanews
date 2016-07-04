<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notícias</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>Id</td>
			<td>Título</td>
			<td>Subtítulo</td>
			<td>Texto</td>
			<td>Data</td>
			<td>Autor</td>
			<td>Categoria</td>

			<c:choose>

				<c:when test="${user_logged_editor != null}">
					<td>Opção 1</td>
				</c:when>

				<c:when
					test="${user_logged_journalist != null}">
					<td>Opção 1</td>
					<td>Opção 2</td>

				</c:when>


			</c:choose>

		</tr>

		<c:forEach var="n" items="${newsList}">
			<tr>
				<td>${n.id}</td>
				<td><a href="showNewsForm?id=${n.id}">${n.title}</a></td>
				<td>${n.subTitle}</td>
				<td>${n.text}</td>
				<td>${n.date}</td>
				<td><a href="showUserForm?id=${n.user.id}">${n.user}</a></td>
				<td>${n.section}</td>

				<c:choose>

					<c:when test="${user_logged_editor != null}">
						<td><a href="removeNews?id=${n.id}">Remover</a></td>
					</c:when>

					<c:when
						test="${user_logged_journalist != null and user_logged_journalist.id == n.user.id}">
						<td><a href="updateNewsForm?id=${n.id}">Alterar</a></td>
						<td><a href="removeNews?id=${n.id}">Remover</a></td>
					</c:when>

					<c:when
						test="${user_logged_journalist != null and user_logged_journalist.id != n.user.id}">
						<td>Não Habilitado</td>
						<td>Não Habilitado</td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</table>


</body>
</html>