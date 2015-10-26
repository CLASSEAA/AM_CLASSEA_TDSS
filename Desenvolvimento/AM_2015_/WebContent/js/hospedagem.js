/**
 * 
 */

$(document).ready(function(){
	
	$('.container').hide();
	checkParametrosUrl();

});

function checkParametrosUrl(){
	
	var url = window.location;
	var parametrosDaUrl = url.split("?")[1];
	var listaParametros = parametrosDaUrl.split("&");
	
	for (var int = 0; int < listaParametros.length; int++) {
		if(listaParametros[i] == "reserva=false"){
			
		}else if(listaParametros[i] == "reserva=true"){
			$('.container').show();
			$('#modalReserva').modal();
		} else if(listaParametros[i] == "hospedagem=false"){
			$('#modalErroHospedagem').modal('show');
		} else  if(listaParametros[i]){
			$('#modalSucessoHospedagem').modal('show');
		}
	}
}