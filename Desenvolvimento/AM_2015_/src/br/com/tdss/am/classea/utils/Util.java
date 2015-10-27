package br.com.tdss.am.classea.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe com função de auxiliar as demais classes no processamento de informações
 * */
public class Util {

	
	/**
	 * Metodo para comparar data de reserva com data da hospedagem
	 * @return {@link Boolean}
	 * */
	public static boolean compararDatas(String dataHospedagem, String dataInicioReserva){
		
		SimpleDateFormat h = new SimpleDateFormat("DDMMYYYY");
		SimpleDateFormat r = new SimpleDateFormat("DDMMYYYY");
		
		try {
			
			if(dataHospedagem.equals(dataInicioReserva)){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

		}
		
		return false;
	}
	
	private static String converterData(String data){
		String dia = data.substring(0, 2);
		String mes = data.substring(3,5);
		String ano = data.substring(6, 10);
		
		
				
		String d = dia + mes + ano; 

		return d;
		
	}
	
	public static String converterMilis(Calendar calendar){
			String ano = String.valueOf(calendar.get(Calendar.YEAR));
			String mes = String.valueOf(calendar.get(Calendar.MONTH));
			String dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
			
			return dia + "/" + mes + "/" + ano;
	}
	
	public String buscarDataAtual(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String data = dateFormat.format(date);
		return data;
	}
	
}
