<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script src="http://connect.facebook.net/en_US/all.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
		FB.init({
			appId: '1589771847988428',
			cookie: true,
			status: true,
			xfbml: true

		});

	FB.Event.subscribe('auth.authResponseChange', function(response){
		if(response.authResponse){
			FB.api('/me', {fields: 'name,email'},function(response){
				$('#nome').html(response.email + response.name);
				

			});

		} else if (response.status === 'not_authorized'){
			FB.login();
		}else{
			$('#nome').html(null);

		}
	});
	</script>
	
	<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.6&appId=1589771847988428";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
	

<title> Galinha Choca News</title>


</head>
<body>
	
	
	<h1> Galinha Choca News </h1>
	
	<h3> <a href="loginForm"> Login </a></h3>
	
	<h3> Conecte-se com seu Facebook para interagir conosco!</h3>
	 <fb:login-button scope="public_profile,email" autologoutlink="true"> </fb:login-button>
	 
	 
	<c:forEach var="s" items="${sections}">
			<ul> 
		        <li><a href="showNewsInSection?id=${s.id}">${s.title}</a></li> 
    		</ul>
	</c:forEach>
	 
	<h3><a href="listAdsUser"> Classificados </a></h3> 
	
	 <div class="fb-like" data-href="https://www.facebook.com/Galinha-Choca-News-189179474814913/" 
data-layout="box_count" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>

</body>
</html>