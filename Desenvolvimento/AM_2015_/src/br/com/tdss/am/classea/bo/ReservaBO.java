package br.com.tdss.am.classea.bo;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.ReservaDAO;
import br.com.tdss.am.classea.entity.Reserva;

public class ReservaBO {
	
	public Reserva buscarReserva(Reserva reserva) throws Exception{
		ReservaDAO reservaDAO = DaoFactory.getReservaDAO();
		Reserva r = reservaDAO.buscarReservar(reserva);
		return r;
	}
}
