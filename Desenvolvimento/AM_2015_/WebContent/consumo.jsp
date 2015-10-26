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
		<h3>Controle de Consumo</h3>
			<br>	
		<div class="container">
			<form action="ListaConsumo" method="get">
				<div class="col-xs-4">
				<div class="form-group">
					<label for="idHospedagem">N� da Hospedagem:</label>
					 <input type="text" name="idHospedagem" class="form-control" placeholder="Id da hospedagem">
				</div>
				<button type="submit">Procurar</button>
				</div>
			</form>
		</div>
		
	</div>
	
			<div class="container" id="consumo-content">
			<div class="row">
				<div class="col-lg-8">
					<table id="t-consumo" class="table-striped">
						 <thead>
							<tr>
        						<th>ID</th>
        						<th>Descri��o</th>
        						<th>Pre�o Unit�rio</th>
        						<th>Total</th>
      						</tr>
						</thead>
						<tbody>
							<c:if test="${consumoHospedagem != null }">						
							<c:forEach var="n" items="${consumoHospedagem}">
								<tr>
									<td>${n.produtoServico.idTipoServico} </td>
									<td>${n.produtoServico.descricao}</td>
									<td>${n.produtoServico.preco}</td>
									<td>${n.valorConsumo}</td>
								</tr>
							</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
	</script>
	<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js">
		
	</script>



</body>
</html>