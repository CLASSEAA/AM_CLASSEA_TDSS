package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

public interface QuartoDao {

	public ArrayList<Quarto> buscarQuartoReservado(Reserva reserva) throws SQLException;
	public Quarto buscarQuarto(int numeroQuarto) throws SQLException;
}
