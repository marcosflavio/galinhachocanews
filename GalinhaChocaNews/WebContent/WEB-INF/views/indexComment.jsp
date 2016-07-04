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

<div id="fb-root2"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.6&appId=1589771847988428";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<title>Seja bem vindo!</title>
</head>
<body>

	<h1>Galinha Choca News</h1>


<fb:login-button scope="public_profile,email" autologoutlink="true"> </fb:login-button>

<div class="fb-like" data-href="https://www.facebook.com/Galinha-Choca-News-189179474814913/" 
data-layout="box_count" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>

<div class="fb-comments" data-href="http://localhost:8060/GalinhaChocaNews/" data-numposts="5"></div>
</body>

</html>