package br.com.tdss.am.classea.dao;

import br.com.tdss.am.classea.dao.impl.OracleClienteDAO;
import br.com.tdss.am.classea.dao.impl.OracleConsumoDao;
import br.com.tdss.am.classea.dao.impl.OracleFuncionarioDAO;
import br.com.tdss.am.classea.dao.impl.OracleHospedagemDao;
import br.com.tdss.am.classea.dao.impl.OracleQuartoDAO;
import br.com.tdss.am.classea.dao.impl.OracleReservaDAO;
import br.com.tdss.am.classea.dao.interfaces.ClienteDao;
import br.com.tdss.am.classea.dao.interfaces.ConsumoDao;
import br.com.tdss.am.classea.dao.interfaces.FuncionarioDAO;
import br.com.tdss.am.classea.dao.interfaces.HospedagemDao;
import br.com.tdss.am.classea.dao.interfaces.QuartoDao;
import br.com.tdss.am.classea.dao.interfaces.ReservaDAO;

public abstract class DaoFactory {

	public static HospedagemDao getHospedagemDao(){
		return new OracleHospedagemDao();
	}
	
	public static ConsumoDao getConsumoDao(){
		return new OracleConsumoDao();
	}
	
	public static ClienteDao getClienteDao(){
		return new OracleClienteDAO();
	}
	
	
	public static FuncionarioDAO getFuncionarioDAO(){
		return new OracleFuncionarioDAO();
	}
	
	public static ReservaDAO getReservaDAO(){
		return new OracleReservaDAO();
	}
	
	public static QuartoDao getQuartoDAO(){
		return new OracleQuartoDAO();
	}
}
