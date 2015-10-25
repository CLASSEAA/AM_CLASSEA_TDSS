package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;

import br.com.tdss.am.classea.entity.Cliente;

public interface ClienteDao {
	
	public Cliente buscarCliente(Cliente cliente) throws SQLException;
	
	
	
}
