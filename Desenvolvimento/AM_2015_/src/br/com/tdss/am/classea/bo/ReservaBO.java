package br.com.tdss.am.classea.bo;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.ReservaDAO;
import br.com.tdss.am.classea.entity.Reserva;

/**
 * Business Object - Reserva
 * 
 * */
public class ReservaBO {
		
	/**
	 * Metodo para buscar {@link Reserva}
	 * @return {@link Reserva}
	 * */
	public Reserva buscarReserva(Reserva reserva) throws Exception{
		String id = Integer.toString(reserva.getIdReserva());
		if(id == null){
			throw new Exception("Reserva sem id");
		}else{
		ReservaDAO reservaDAO = DaoFactory.getReservaDAO();
		Reserva r = reservaDAO.buscarReservar(reserva);
		return r;
		}
	}
}
