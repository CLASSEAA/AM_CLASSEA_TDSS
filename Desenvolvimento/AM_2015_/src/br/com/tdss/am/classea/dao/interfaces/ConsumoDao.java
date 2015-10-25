package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tdss.am.classea.entity.Consumo;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;


/**
 * Interface classe DAO da entidade {@link Consumo}
 * */
public interface ConsumoDao {

/**
 * Metodo para incluir {@link Consumo}
 * */
	public void incluirConsumo(Consumo consumo, Hospedagem hospedagem, Funcionario funcionario) throws SQLException;
	
/**
 * Metodo para retorno de {@link Consumo}
 * @return ArrayLista<{@link Consumo}>
 * */
	public ArrayList<Consumo> listarConsumo (Hospedagem hospedagem) throws SQLException;

}


