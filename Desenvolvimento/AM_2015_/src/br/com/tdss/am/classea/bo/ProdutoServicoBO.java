package br.com.tdss.am.classea.bo;

import java.util.ArrayList;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.ProdutoServicoDAO;
import br.com.tdss.am.classea.entity.ProdutoServico;

/**
 * Business object - Produto
 * */
public class ProdutoServicoBO {
	
	
	/**
	 * Metodo para listar {@link ProdutoServico}
	 * @return ArrayList<{@link ProdutoServico}>
	 * */
	public ArrayList<ProdutoServico> listarProdutoServico() throws Exception{
		ArrayList<ProdutoServico> ps = new ArrayList<ProdutoServico>();
		ProdutoServicoDAO produtoServicoDAO = DaoFactory.getProdutoServicoDAO();
		ps = produtoServicoDAO.listarProdutoServico();
		return ps;
	}
}
