package br.com.tdss.am.classea.bo;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.FuncionarioDAO;
import br.com.tdss.am.classea.entity.Funcionario;

public class FuncionarioBO {

	public Funcionario buscarFuncionario(Funcionario funcionario) throws Exception{
		FuncionarioDAO funcionarioDAO = DaoFactory.getFuncionarioDAO();
		Funcionario f = funcionarioDAO.buscarFuncionarioDAO(funcionario);
		return f;
	}
}
