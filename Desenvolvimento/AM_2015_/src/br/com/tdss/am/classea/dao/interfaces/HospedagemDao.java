package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;

import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;

public interface HospedagemDao {

	public void incluirHospedagem(Hospedagem hospedagem, Funcionario funcionario) throws SQLException;
	public Hospedagem buscarHospedagem(int idHospedagem) throws SQLException;
}
