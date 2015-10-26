<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js">
	
</script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Boa Viagem Consumo</title>
</head>
<body>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Hotel Boa Viagem</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="hospedagem.jsp">Hospedagem</a></li>
				<li><a href="consumo.jsp">Consumo </a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp">Logout <span
						class="glyphicon glyphicon-flag"></span></a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="jumbotron">
		<h1>Controle de hospedagem</h1>
		<p>Informe o numero da reserva abaixo, para realizarmos a
			hospegadem.</p>
			</br>
			</br>
			</br>
			</br>
			</br>
		<div class="container">
			<form action="#" method="get">
				<div class="col-xs-4">
				<div class="form-group">
					<label for="usr">NR� da Hospedagem:</label>
					 <input type="text" class="form-control" id="usr" placeholder="Id da hospedagem">
				</div>
				<button type="button">Validar</button>
				</div>
			</form>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
	</script>
	<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js">
		
	</script>



</body>
</html>