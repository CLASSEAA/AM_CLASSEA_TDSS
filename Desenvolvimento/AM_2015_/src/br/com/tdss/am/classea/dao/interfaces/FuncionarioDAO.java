package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;

import br.com.tdss.am.classea.entity.Funcionario;

public interface FuncionarioDAO {
	
	public Funcionario buscarFuncionarioDAO(Funcionario funcionario) throws SQLException;
	
	
}
