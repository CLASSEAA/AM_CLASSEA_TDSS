package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;

import br.com.tdss.am.classea.entity.Reserva;


/**
 * Interface classe DAO da entidade {@link Reserva}
 * */
public interface ReservaDAO {
	
	/**
	 * Metodo para busca de {@link Reserva}
	 * @return {@link Reserva}
	 * */
	public Reserva buscarReservar(Reserva reserva) throws SQLException;
	
}
