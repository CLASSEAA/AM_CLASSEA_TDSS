package br.com.tdss.am.classea.dao;

import br.com.tdss.am.classea.dao.impl.OracleClienteDAO;
import br.com.tdss.am.classea.dao.impl.OracleConsumoDao;
import br.com.tdss.am.classea.dao.impl.OracleFuncionarioDAO;
import br.com.tdss.am.classea.dao.impl.OracleHospedagemDao;
import br.com.tdss.am.classea.dao.impl.OracleProdutoServicoDAO;
import br.com.tdss.am.classea.dao.impl.OracleQuartoDAO;
import br.com.tdss.am.classea.dao.impl.OracleReservaDAO;
import br.com.tdss.am.classea.dao.interfaces.ClienteDao;
import br.com.tdss.am.classea.dao.interfaces.ConsumoDao;
import br.com.tdss.am.classea.dao.interfaces.FuncionarioDAO;
import br.com.tdss.am.classea.dao.interfaces.HospedagemDao;
import br.com.tdss.am.classea.dao.interfaces.ProdutoServicoDAO;
import br.com.tdss.am.classea.dao.interfaces.QuartoDao;
import br.com.tdss.am.classea.dao.interfaces.ReservaDAO;
import br.com.tdss.am.classea.entity.Cliente;
import br.com.tdss.am.classea.entity.Consumo;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

/**
 * Fabrica de DAOs<br/>
 * Classe utilizada para a utilização de qualquer DAO do sistema
 * */
public abstract class DaoFactory {
	
	/**
	 * @return Implementação de {@link Hospedagem}
	 * @see br.com.tdss.am.classea.dao.impl.OracleHospedagemDao
	 * */
	public static HospedagemDao getHospedagemDao(){
		return new OracleHospedagemDao();
	}
	/**
	 * @return Implementação de {@link Consumo}
	 * @see br.com.tdss.am.classea.dao.impl.OracleConsumoDao
	 * */
	public static ConsumoDao getConsumoDao(){
		return new OracleConsumoDao();
	}
	
	/**
	 * @return Implementação de {@link Cliente}
	 * @see br.com.tdss.am.classea.dao.impl.OracleClienteDAO
	 * */
	public static ClienteDao getClienteDao(){
		return new OracleClienteDAO();
	}
	
	public static ProdutoServicoDAO getProdutoServicoDAO(){
		return new OracleProdutoServicoDAO();
	}
	/**
	 * @return Implementação de {@link Funcionario}
	 * @see br.com.tdss.am.classea.dao.impl.OracleFuncionarioDAO
	 * */
	public static FuncionarioDAO getFuncionarioDAO(){
		return new OracleFuncionarioDAO();
	}
	
	/**
	 * @return Implementação de {@link Reserva}
	 * @see br.com.tdss.am.classea.dao.impl.OracleReservaDAO
	 * */
	public static ReservaDAO getReservaDAO(){
		return new OracleReservaDAO();
	}
	

	/**
	 * @return Implementação de {@link Quarto}
	 * @see br.com.tdss.am.classea.dao.impl.OracleQuartoDAO
	 * */
	public static QuartoDao getQuartoDAO(){
		return new OracleQuartoDAO();
	}
}
