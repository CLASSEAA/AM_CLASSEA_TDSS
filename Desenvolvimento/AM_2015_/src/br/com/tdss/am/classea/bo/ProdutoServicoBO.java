package br.com.tdss.am.classea.bo;

import java.util.ArrayList;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.ProdutoServicoDAO;
import br.com.tdss.am.classea.entity.ProdutoServico;

public class ProdutoServicoBO {

	public ArrayList<ProdutoServico> listarProdutoServico() throws Exception{
		ArrayList<ProdutoServico> ps = new ArrayList<ProdutoServico>();
		ProdutoServicoDAO produtoServicoDAO = DaoFactory.getProdutoServicoDAO();
		ps = produtoServicoDAO.listarProdutoServico();
		return ps;
	}
}
