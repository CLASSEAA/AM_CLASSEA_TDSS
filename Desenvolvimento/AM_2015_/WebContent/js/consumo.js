/**
 * 
 */

$(document).ready(function(){
	
	$('#consumo-content').hide();
	checkParametrosUrl();
	
});

function checkParametrosUrl(){
	
	var url = window.location.href;
	var parametrosDaUrl = url.split("?")[1];
	var listaParametros = parametrosDaUrl.split("&");

	for (var i = 0; i < listaParametros.length; i++) {
		if(listaParametros[i] == "lista=false"){
			document.forms["form-lista-produto"].submit();
		} else if(listaParametros[i] == "hospedagem=true"){
			$('#consumo-content').show();
		} else if(listaParametros[i] == "hospedagem=false"){
			$('#modalErroHospedagem').modal('show');
		} else if(listaParametros[i] == "consumo=false"){
			$('#modalErroConsumo').modal('show');
		} else if(listaParametros[i] == "consumo=true"){
			$('#consumo-content').hide();
			$('#modalSucessoConsumo').modal('show');
		}
	}
}