<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"> </script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"> </script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Boa Viagem Hospedagem</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Hotel Boa Viagem</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">Hospedagem</a></li>
        <li><a href="#">Consumo </a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="login.jsp">Logout  <span class="glyphicon glyphicon-flag"></span></a></li>
      </ul>
    </div>
  </div>
</nav>

<form action"#" class = "jumbotron">
<div> 
  <p><h1> Controle de Hospedagem </h1></p>
  <p>Registrar hospedagem</p>
  </br>
  </br>
  </br>
</div> 
</form>
  <div class="col-xs-4">
  <label for="ex3">NRº Rerseva: </label>
  <input type="text" class="form-control" id="ex3" placeholder="informe o numero da reserva" /> <button type="button" class = "btn btn-default">Buscar</button>
  </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"> </script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"> </script>
</body>
</html>