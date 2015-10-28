<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js">
</script>
<link href="css/estilo-consumo.css">
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
				<li><a href="consumo.jsp?lista=false">Consumo </a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logoff.jsp">Logout <span
						class="glyphicon glyphicon-flag"></span></a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h3>Controle de Consumo</h3>
			<br>	
			<form action="ListaConsumo" method="get">
				<div class="col-xs-4">
				<div class="form-group">
					<label for="idHospedagem">Nº da Hospedagem:</label>
					 <input type="text" name="idHospedagem" class="form-control" placeholder="Id da hospedagem">
				</div>
				<button type="submit">Procurar</button>
				</div>
			</form>
		</div>
		
	</div>
	
		<div class="container" id="consumo-content">
			<div class="row">
				<div class="col-md-6">
					<table id="t-consumo" class="table-striped">
						 <thead>
							<tr>
        						<th>ID</th>
        						<th>Descrição</th>
        						<th>Quantidade</th>
        						<th>Preço Unitário</th>
        						<th>Total</th>
      						</tr>
						</thead>
						<tbody>
							<c:if test="${consumoHospedagem != null }">						
							<c:forEach var="n" items="${consumoHospedagem}">
								<tr>
									<td>${n.produtoServico.idTipoServico} </td>
									<td>${n.produtoServico.descricao}</td>
									<td>${n.quantidade }</td>
									<td>${n.produtoServico.preco}</td>
									<td>${n.valorConsumo}</td>
								</tr>
							</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
				<div class="col-md-6">
					<form action="RegistraConsumo" method="get">
						<div class="form-group">
						<label for="select-produto">Produto: </label>
						<select name="select-produto">
						<c:forEach var="i" items="${produtoServico}">	
								<option value="${i.idTipoServico}">${i.descricao}</option>
						</c:forEach>
						</select>
						<br>
						<label for="quantidade">Quantidade: </label>
						<input type="text" name="quantidade">
						<input hidden="true" type="text" name="idFuncionario" value="${user.id}">
						<input hidden="true" type="text" name="idHospedagem" value="${hospedagem.idHospedagem}">
						<br>
						</div>
						<hr>						
						<button>Registrar Consumo</button>
					</form>
					
					
				</div>
			</div>
			<hr>
		</div>
		
		<div class="container">
			<div class="modal fade" id="modalErroHospedagem" role="dialog">
	    		<div class="modal-dialog">
	      			<div class="modal-content">
	        			<div class="modal-header">
	          				<button type="button" class="close" data-dismiss="modal">&times;</button>
	          				<h4 class="modal-title">Hospedagem não Encontrada</h4>
		    			</div>
		       			<div class="modal-body">
	        	  			<p>Verifique o número e tente novamente</p>
	        			</div>
	        			<div class="modal-footer">
	          				<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
	        			</div>
	      			</div>
   			 	</div>
  			</div>

			<div class="modal fade" id="modalErroConsumo" role="dialog">
	    		<div class="modal-dialog">
	      			<div class="modal-content">
	        			<div class="modal-header">
	          				<button type="button" class="close" data-dismiss="modal">&times;</button>
	          				<h4 class="modal-title">Erro ao registrar consumo</h4>
		    			</div>
		       			<div class="modal-body">
	        	  			<p>Verifique os campos e tente novamente</p>
	        			</div>
	        			<div class="modal-footer">
	          				<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
	        			</div>
	      			</div>
   			 	</div>
  			</div>
  			
  						<div class="modal fade" id="modalSucessoConsumo" role="dialog">
	    		<div class="modal-dialog">
	      			<div class="modal-content">
	        			<div class="modal-header">
	          				<button type="button" class="close" data-dismiss="modal">&times;</button>
	          				<h4 class="modal-title">Consumo Registrado com sucesso</h4>
		    			</div>
		       			<div class="modal-body">
	        	  			<p>feche a janela e retone a aplicação</p>
	        			</div>
	        			<div class="modal-footer">
	          				<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
	        			</div>
	      			</div>
   			 	</div>
  			</div>
  			
		</div>
		
		<div hidden="true" id="div-lista-produto">
			<form action="ListaProdutoServico" method="get" id="form-lista-produto">
				<input name="x" type=submit>
			</form>	
		</div>
		
	<c:choose>
    <c:when test="${user eq null}">
        <jsp:forward page="erroLogin.jsp" />
    </c:when>
    <c:otherwise>
        <p>Bem-vindo ${user.nome}, ${user.id}</p>
    </c:otherwise>
    </c:choose>
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
	</script>
	<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js">
	</script>
	<script src="js/consumo.js"></script>


</body>
</html>