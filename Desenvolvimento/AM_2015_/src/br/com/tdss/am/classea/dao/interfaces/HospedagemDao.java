package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;

import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;

/**
 * Interface classe DAO da entidade {@link Hospedagem}
 * */
public interface HospedagemDao {

	/**
	 * Metodo para incluir {@link Hospedagem}
	 * */
	public void incluirHospedagem(Hospedagem hospedagem, Funcionario funcionario) throws SQLException;
	
	/**
	 * Metodo para buscar {@link Hospedagem}
	 * @return {@link Hospedagem}
	 * */
	public Hospedagem buscarHospedagem(int idHospedagem) throws SQLException;
}
