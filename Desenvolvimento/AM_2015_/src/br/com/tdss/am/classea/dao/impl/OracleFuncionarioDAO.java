package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tdss.am.classea.dao.interfaces.FuncionarioDAO;
import br.com.tdss.am.classea.entity.Funcionario;
/**
 * Classe para implementação de {@link Funcionario} no Banco de Dados
 * @author Vitor Costa José;
 * */
public class OracleFuncionarioDAO implements FuncionarioDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private static final String sqlConsulta = "SELECT F.ID_FUNCIONARIO, P.NM_PESSOA FROM T_AM_CLA_FUNCIONARIO F INNER JOIN T_AM_CLA_PESSOA P ON(F.ID_FUNCIONARIO = P.ID_PESSOA) WHERE F.ID_FUNCIONARIO = ?";
	
	
	/**
	 * Metodo para buscar {@link Funcionario} no banco de dados
	 * @param {@link Funcionario} 
	 * @return {@link Funcionario}
	 * @throws SQLException 
	 * **/
	@Override
	public Funcionario buscarFuncionarioDAO(Funcionario funcionario) throws SQLException {
		try {

			conn = ConnectionManager.getInstance().getConnection();
			
			stmt = conn.prepareStatement(sqlConsulta);
			stmt.setInt(1, funcionario.getIdPessoa());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				funcionario.setIdPessoa(rs.getInt("ID_FUNCIONARIO"));
				funcionario.setNome(rs.getString("NM_PESSOA"));
			}
			
			return funcionario;
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
