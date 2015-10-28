package br.com.tdss.am.classea.bo;

import java.util.ArrayList;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.ConsumoDao;
import br.com.tdss.am.classea.entity.Consumo;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;
/**
 * Business object - Consumo
 * */
public class ConsumoBO {
	
	
	/**
	 * Metodo para incluir um {@link Consumo}
	 * */
	public void incluirConsumo(Hospedagem hospedagem, Funcionario funcionario, ArrayList<Consumo> consumo) throws Exception{
		
		if(consumo.size() == 0){
			throw new Exception("Um consumo deve ter no m�nimo um Produto ou Servi�o");
		}
		
		if(funcionario.getIdPessoa() == 0){
			throw new Exception("O registro de consumo deve estar associado � um funcion�rio");
			
		}
		
		if(hospedagem == null){
			throw new Exception("O registro de consumo deve estar associado � uma hospedagem");
		}
		
		for (Consumo c : consumo) {
			if(c.getQuantidade() == 0){
				throw  new Exception("Quantidade n�o especificada em: " + c.getProdutoServico().getDescricao());
			} else {
				ConsumoDao consumoDao = DaoFactory.getConsumoDao();

				consumoDao.incluirConsumo(c, hospedagem, funcionario);
			}
		}
	
	}
	
	/**
	 * Metodo para retornar uma Lista de {@link Consumo}
	 * @return ArrayList<{@link Consumo}>
	 * */
	public ArrayList<Consumo> listarConsumo(Hospedagem hospedagem) throws Exception{
		ArrayList<Consumo> consumo = new ArrayList<Consumo>();
		ConsumoDao consumoDao = DaoFactory.getConsumoDao();
		consumo = consumoDao.listarConsumo(hospedagem);
		return consumo;
	}
}
