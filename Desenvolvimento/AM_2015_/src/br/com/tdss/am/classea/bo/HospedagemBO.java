package br.com.tdss.am.classea.bo;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.HospedagemDao;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.utils.Util;

/**
 * Business object - Hospedagem
 * */

public class HospedagemBO {

	/**
	 * Metodo para incluir {@link Hospedagem}
	 * 
	 * */
	public void incluirHospedagem(Hospedagem hospedagem, Funcionario funcionario) throws Exception {

		if (hospedagem.getReserva() == null) {
			throw new Exception("A hospedagem deve ter uma reserva associada");
		}

		if (!Util.compararDatas(hospedagem.getDataEntrada(), hospedagem.getReserva().getDataInicio())) {
			throw new Exception("A data de hospedagem excede o limite da reserva");
		}
		
		try{
		hospedagem.setDataEntrada(hospedagem.getDataEntrada().replace("/", ""));

		HospedagemDao hospedagemDao = DaoFactory.getHospedagemDao();
		hospedagemDao.incluirHospedagem(hospedagem, funcionario);}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("A reserva já está hospedada");
		}
	}

	/**
	 * Metodo para buscar {@link Hospedagem} através do id
	 * 
	 * @return {@link Hospedagem}
	 * */
	public Hospedagem buscarHospedagem(int idHospedagem) throws Exception {
		HospedagemDao hospedagemDao = DaoFactory.getHospedagemDao();
		Hospedagem hospedagem = hospedagemDao.buscarHospedagem(idHospedagem);
		return hospedagem;
	}

	/**
	 * Metodo para buscar {@link Hospedagem} através do {@link Quarto}
	 * 
	 * @return {@link Hospedagem}
	 * */
	public Hospedagem buscarHospedagem(Quarto quarto) throws Exception {
		HospedagemDao hospedagemDao = DaoFactory.getHospedagemDao();
		Hospedagem hospedagem = hospedagemDao.buscarHospedagem(quarto);
		return hospedagem;
	}
}
