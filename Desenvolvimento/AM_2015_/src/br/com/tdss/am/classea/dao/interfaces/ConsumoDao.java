package br.com.tdss.am.classea.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tdss.am.classea.entity.Consumo;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;

public interface ConsumoDao {


	public void incluirConsumo(Consumo consumo, Hospedagem hospedagem, Funcionario funcionario) throws SQLException;
	public ArrayList<Consumo> listarConsumo (Hospedagem hospedagem) throws SQLException;

}


