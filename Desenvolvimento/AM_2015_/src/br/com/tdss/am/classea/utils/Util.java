package br.com.tdss.am.classea.utils;

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
		
		SimpleDateFormat h = new SimpleDateFormat("YYMMDD");
		SimpleDateFormat r = new SimpleDateFormat("YYMMDD");
		
		try {
			Date dH = h.parse(converterData(dataHospedagem));
			Date dR = r.parse(converterData(dataInicioReserva));
			Calendar cH = Calendar.getInstance();
			Calendar cR = Calendar.getInstance();
			cH.setTime(dH);
			cR.setTime(dR);
			Calendar cRL = cR;
			cRL.add(Calendar.DATE, 1);
			if(cH == cR || cH == cRL){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

		}
		
		return false;
	}
	
	private static String converterData(String data){
		String dia = data.substring(0, 1);
		String mes = data.substring(3,4);
		String ano = data.substring(5, 6);
		
		
				
		String d = ano + mes + dia; 

		return d;
		
	}
	
	public static String converterMilis(Calendar calendar){
			String ano = String.valueOf(calendar.get(Calendar.YEAR));
			String mes = String.valueOf(calendar.get(Calendar.MONTH));
			String dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
			
			return dia + "/" + mes + "/" + ano;
	}
	
}
