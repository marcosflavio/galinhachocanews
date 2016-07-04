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


<title>${ads.title}</title>
</head>
<body>

	<ul>

		<li>${ads.title}</li>
		<li>${ads.text}</li>
		<li>${ads.price}</li>
		<li>${ads.tellephone}</li>
		<li><a href="showUserForm?id=${ads.user.id}">${ads.user}</a></li>

	</ul>


	<div class="fb-comments"
		data-href="http://localhost:8060/GalinhaChocaNews/showNewsForm?id=${news.id}"
		data-numposts="5"></div>

</body>
</html>