<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js">
	
</script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<title>Hotel Boa Viagem Login</title>
</head>
<body background="img/citylights.jpg">

	<div class="wrappp">
		<p><h3>Para efetuar login usuario = ltpweb</h3></p>
		<p><h3>Para efetuar login senha = 123456</h3></p>
	</div>

	<h1 class="wrapp">Favor informar Login e senha</h1>

	<form action="ValidarLogin" method="post" class="wrap">
		<div class="col-xs-4">
			<label>Login: </label>
			 <input class="form-control" type="text" maxlength="20" name="login" placeholder="login" required="true">
			 <label>Senha: </label>
			 <input class="form-control" type="password" maxlength="20" name="senha" placeholder="senha" required="true">
			 </br>
			 <button type="submit" value="login" class="btn btn-default">Entrar</button>
		</div>
	</form>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
		
	</script>
	<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js">
		
	</script>
	<script src="js/login.js"></script>
</body>
</html>