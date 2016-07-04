<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body style="text-align: center;">

	<h3>Role Section</h3>
	<h4>Section visivel apenas para o adm</h4>
	<a href="listRole"> Listar Papeis</a>
	<br />
	<a href="insertRoleForm"> Inserir Papel </a>
	<br />

	<h3>User Section</h3>
	<h4>Section visivel apenas para o Adm e o Editor</h4>
	<a href="insertUserForm"> Cadastrar Usuário </a>
	<br />
	<a href="listUser"> Listar Usuários </a>
	<br />
	<a href="showUser"> Detalhar Usuário </a>
	<br />
	<a href="logout"> Logout </a>
	<br />
	
	<h3>Section Section</h3>
	<h4>Section visivel apenas para o Adm e o Editor</h4>
	<a href="insertSectionForm"> Cadastrar Seção </a> <br />
	<a href="listSection"> Listar Seções </a> 
	<br />
	
	<h3>Ads Section</h3>
	<h4>Section visivel apenas para o Editor</h4>
	<a href="insertAdsForm"> Criar Classificado </a> <br />
 	<a href="listAds"> Listar Classificados </a>  
	<br />
	
</body>
</html>