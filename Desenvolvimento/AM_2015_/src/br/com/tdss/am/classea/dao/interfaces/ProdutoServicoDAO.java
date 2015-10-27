package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tdss.am.classea.entity.ProdutoServico;

public interface ProdutoServicoDAO {

	public ArrayList<ProdutoServico> listarProdutoServico() throws SQLException;
	
}
