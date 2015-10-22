package br.com.tdss.am.classea.bo;

import java.util.ArrayList;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.ConsumoDao;
import br.com.tdss.am.classea.entity.Consumo;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;

public class ConsumoBO {
	
	public void incluirConsumo(Hospedagem hospedagem, Funcionario funcionario, ArrayList<Consumo> consumo) throws Exception{
		
		if(consumo.size() == 0){
			throw new Exception("Um consumo deve ter no mínimo um Produto ou Serviço");
		}
		
		if(funcionario.getIdPessoa() == 0){
			throw new Exception("O registro de consumo deve estar associado à um funcionário");
			
		}
		
		if(hospedagem == null){
			throw new Exception("O registro de consumo deve estar associado à uma hospedagem");
		}
		
		for (Consumo c : consumo) {
			if(c.getQuantidade() == 0){
				throw  new Exception("Quantidade não especificada em: " + c.getProdutoServico().getDescricao());
			} else {
				ConsumoDao consumoDao = DaoFactory.getConsumoDao();

				consumoDao.incluirConsumo(c, hospedagem, funcionario);
			}
		}
	
	}
	
	public ArrayList<Consumo> listarConsumo(Hospedagem hospedagem) throws Exception{
		ArrayList<Consumo> consumo = new ArrayList<Consumo>();
		ConsumoDao consumoDao = DaoFactory.getConsumoDao();
		consumo = consumoDao.listarConsumo(hospedagem);
		return consumo;
	}
}
