package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

public interface QuartoDao {

	public List<Quarto> buscarQuarto(Reserva reserva) throws SQLException ;
}
