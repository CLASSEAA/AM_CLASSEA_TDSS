package br.com.tdss.am.classea.bo;

import java.util.ArrayList;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.QuartoDao;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

public class QuartoBO {

		public ArrayList<Quarto> buscarQuartoReservado(Reserva reserva){
			QuartoDao quartoDao = DaoFactory.getQuartoDAO();
			return null;
		}
}
