<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script src="http://connect.facebook.net/en_US/all.js"></script>

<div id="fb-root2"></div>
<script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.6&appId=1589771847988428";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>

<title>Notícia ${news.title}</title>
</head>
<body>

	<ul>

		<li>${news.section}</li>
		<li>${news.date}</li>
		<li>${news.title}</li>
		<li>${news.subTitle}</li>
		<li><a href="showUserForm?id=${news.user.id}">${news.user}</a></li>
		<li>${news.text}</li>
	</ul>
	<%--  <button onClick="parent.location='removeNews?id=${news.id}'" value='Apagar Notícia'></button>	  --%>
	<c:choose>

		<c:when test="${user_logged_editor != null}">
			<input type=button
				onClick="parent.location='removeNews?id=${news.id}'"
				value='Apagar Notícia'>
		</c:when>

		<c:when
			test="${user_logged_journalist != null and user_logged_journalist.id == news.user.id}">
			<input type=button
				onClick="parent.location='removeNews?id=${news.id}'"
				value='Apagar Notícia'>
		</c:when>


	</c:choose>

	<div>
		<input type=button
			onClick="parent.location='showNewsInSection?id=${news.section.id}'"
			value='Voltar'>
	</div>

	<div class="fb-comments"
		data-href="http://localhost:8060/GalinhaChocaNews/showNewsForm?id=${news.id}"
		data-numposts="5"></div>
</body>
</html>