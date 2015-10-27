/**
 * 
 */

$(document).ready(function(){
	
	$('#main-content').hide();
	checkParametrosUrl();

});

function checkParametrosUrl(){
	
	var url = window.location.href;
	var parametrosDaUrl = url.split("?")[1];
	var listaParametros = parametrosDaUrl.split("&");
	
	for (var i = 0; i < listaParametros.length; i++) {
		if(listaParametros[i] == "reserva=false"){
			$('#modalReserva').modal('show');
		}else if(listaParametros[i] == "reserva=true"){
			$('#main-content').show();
		} else if(listaParametros[i] == "hospedagem=false"){
			$('#modalErroHospedagem').modal('show');
		} else  if(listaParametros[i]){
			$('#modalSucessoHospedagem').modal('show');
		}
	}
}