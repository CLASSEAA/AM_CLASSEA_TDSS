package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

/**
 * Interface classe DAO da entidade {@link Quarto}}
 * */
public interface QuartoDao {
/**
 * Metodo para busca de {@link QuartoReservado}
 * @return ArrayList<{@link Quarto}
 * */
	public ArrayList<Quarto> buscarQuartoReservado(Reserva reserva) throws SQLException;
	
/**
 * Metodo para busca de {@link Quarto}
 * @return {@link Quarto}
 * */
	public Quarto buscarQuarto(int numeroQuarto) throws SQLException;
}
