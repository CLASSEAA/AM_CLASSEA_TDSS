package br.com.tdss.am.classea.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe com função de auxiliar as demais classes no processamento de
 * informações
 * */
public class Util {

	/**
	 * Metodo para comparar data de reserva com data da hospedagem
	 * 
	 * @return {@link Boolean}
	 * */
	public static boolean compararDatas(String dataHospedagem,
			String dataInicioReserva) {

		try {

			if (dataHospedagem.equals(dataInicioReserva)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

		}

		return false;
	}

	/**
	 * Metodo para converter data e milissegundos do sistema em String;
	 * 
	 * @return {@link String}
	 * */
	public static String converterMilis(Calendar calendar) {
		String ano = String.valueOf(calendar.get(Calendar.YEAR));
		String mes = String.valueOf(calendar.get(Calendar.MONTH));
		String dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

		return dia + "/" + mes + "/" + ano;
	}

	/**
	 * Metodo para buscar a data atual no sistema
	 * 
	 * @return {@link String}
	 * */
	public String buscarDataAtual() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String data = dateFormat.format(date);
		return data;
	}

}
