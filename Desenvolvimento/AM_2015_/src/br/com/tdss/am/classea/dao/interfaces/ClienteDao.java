package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;

import br.com.tdss.am.classea.entity.Cliente;

/**
 * Interface classe DAO entidade {@link Cliente}
 * */

public interface ClienteDao {
	
	
	/**
	 * Metodo para implementação de busca de {@link Cliente}
	 * @throws SQLException
	 * */
	public Cliente buscarCliente(Cliente cliente) throws SQLException;
	
	
	
}
