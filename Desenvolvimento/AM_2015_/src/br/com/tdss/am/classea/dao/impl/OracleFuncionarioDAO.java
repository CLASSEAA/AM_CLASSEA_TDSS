package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tdss.am.classea.dao.interfaces.FuncionarioDAO;
import br.com.tdss.am.classea.entity.Funcionario;

public class OracleFuncionarioDAO implements FuncionarioDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private static final String sqlConsulta = "SELECT F.ID_FUNCIONARIO, P.NM_PESSOA FROM T_AM_CLA_FUNCIONARIO F INNER JOIN T_AM_CLA_PESSOA P ON(F.ID_FUNCIONARIO = P.ID_PESSOA) WHERE F.ID_FUNCIONARIO = ?";
	
	@Override
	public Funcionario buscarFuncionarioDAO(Funcionario funcionario) {
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
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return null;
	}

}
