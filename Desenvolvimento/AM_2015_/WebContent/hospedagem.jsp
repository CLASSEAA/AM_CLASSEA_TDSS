<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js">
	
</script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js">	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Boa Viagem Hospedagem</title>
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
				<li><a href="consumo.jsp?lista=false">Consumo </a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp">Logout <span
						class="glyphicon glyphicon-flag"></span></a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h3>Controle de Hospedagem</h3	>
			<br>
			<form action="BuscaReserva" method="get">
				<div class="col-xs-4">
					<div class="form-group">
						<label for="idReserva">Nº da Reserva:</label> 
						<input type="text" name="idReserva" class="form-control" id="usr" placeholder="numero da reserva">
					</div>
					<button type="submit">Procurar</button>
				</div>
			</form>
		</div>

	</div>

	<div class="container" id="main-content">
		<div class="row">
			<form action="RegistraHospedagem" method="get">
					<div class=row>
						<div class="col-md-6">
							<h3 class="text-left">Dados da Reserva:</h3>
							<input type="text" value="${user.id}" hidden="true"> 
					<br>	
						<label for="idReserva">Nº da Reserva:</label> 
							<input readonly="true" type="text" name="idReserva" value="${reserva.idReserva}">
					<br>
						<label for="dataSolicitacao">Data de Solicitação:</label> <input
							readonly="true" type="text" name="dataSolicitacao" value="${reserva.dataSolicitacao}">
					<br>	
						<label for="dataInicio">Data Inicial: </label> 
						<input readonly="true" type="text" name="dataInicio" value="${reserva.dataInicio}">
					<br>
						<label for="dataFinal">Data Final: </label> 
						<input readonly="true" type="text" name="dataFinal" value="${reserva.dataFinal}">
					<br>
						<label for="quantidadeAdulto"> Adultos: </label>
						<input readonly="true" type="text" name="quantidadeAdulto" value="${reserva.quantidadeAdulto}">
					<br>
						<label for="quantidadeCrianca"> Crianças: </label>
						<input readonly="true" type="text" name="quantidadeCrianca" value="${reserva.quantidadeCrianca}">
					<br>
						<h3 class="text-left">Cliente:</h3>
					<br>
						<label for="nome"> Nome: </label>
						<input readonly="true" type="text" name="nome" value="${reserva.cliente.nome}">
					<br>
						<label for="cpf"> CPF: </label>
						<input readonly="true" type="text" name="cpf" value="${reserva.cliente.cpf}">
					<br>
						<label for="rg"> RG: </label>
						<input readonly="true" type="text" name="rg" value="${reserva.cliente.rg}">
					<br>
						<label for="dataNascimento"> Data de Nascimento: </label>
						<input readonly="true" type="text" name="dataNascimento" value="${reserva.cliente.dataNascimento}">
					<br>
						<label for="endereco"> Endereço: </label>
						<input readonly="true" type="text" name="endereco" value="${reserva.cliente.endereco}">
					</div>
					
					<div class="col-md-6">
						<h3>Quarto(s) Reservado(s): </h3>
					<c:forEach var="n" items="${reserva.quartos}" >
								<p>número: ${n.numero}</p>
								<p>tipo: ${n.descricaoQuarto}</p>			
						<label for=n>quantidade de pessoas: </label>
						<input readonly="true" name=n type="text" value="${n.quantidadeHospede}">
						<hr>
						<br>
					</c:forEach>
					
					</div>
					</div>
					<br>
					<hr>
			<div class="row">
		<div class="col-md-5">
	</div>
					<div class="col-md-3">
						<button type="submit">Confirmar Hospedagem</button>
					</div>
					<div class="col-md-4">
				
					</div>
				</div>
					<br>
					<br>
			</form>
		</div>
	</div>
	
	<div class="container">
	<div class="modal fade" id="modalReserva" role="dialog">
	    <div class="modal-dialog">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Reserva não encontrada</h4>
		    </div>
		       <div class="modal-body">
	        	  <p>Por favor informe um numero de reserva válido.</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
	        </div>
	      </div>
   			 </div>
  		</div>
  		
  	<div class="modal fade" id="modalSucessoHospedagem" role="dialog">
	    <div class="modal-dialog">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Hospedagem Confirmada com sucesso!</h4>
		    </div>
		       <div class="modal-body">
	        	  <p>Numero da Hospedagem</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
	        </div>
	      </div>
   			 </div>
  		</div>
  		
  	<div class="modal fade" id="modalErroHospedagem" role="dialog">
	    <div class="modal-dialog">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Erro ao confirmar hospedagem!</h4>
		    </div>
		       <div class="modal-body">
	        	  <p>Favor verificar os campos e ver se estão validos.</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
	        </div>
	      </div>
   			 </div>
  		</div>
	  	
	  	
	</div>
	
	<c:choose>
    <c:when test="${user eq null}">
        <jsp:forward page="erroLogin.jsp" />
    </c:when>
    <c:otherwise>
        <p>Bem-vindo ${user.nome}, ${user.id}</p>
    </c:otherwise>
    </c:choose>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/hospedagem.js"></script>
</body>
</html>