package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;

import br.com.tdss.am.classea.entity.Funcionario;

/**
 * Interface classe DAO da entidade {@link Funcionario} 
 * */
public interface FuncionarioDAO {
	
	
	/**
	 * Metodo para busca de {@link Funcionario}
	 * @return {@link Funcionario}
	 * */
	public Funcionario buscarFuncionarioDAO(Funcionario funcionario) throws SQLException;
	
	
}
