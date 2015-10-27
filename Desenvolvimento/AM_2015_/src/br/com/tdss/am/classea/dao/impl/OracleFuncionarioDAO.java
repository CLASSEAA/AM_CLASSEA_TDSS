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
		
		/* Funcionario getFuncionario(String login, String senha) {
		        conn = ConnectionManager.getInstance().getConnection();
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        try{
		            ps = conn.prepareStatement("select id, nome from usuario where login = ? and senha = ?");
		            ps.setString(1, login);
		            ps.setString(2, senha);
		 
		            rs = ps.executeQuery();
		 
		            if ( rs.next() ){
		                Funcionario func = new Funcionario();
		                func.setId( rs.getInt("id") );
		                func.setLogin(login);
		                func.setSenha(senha);
		                func.setNome( rs.getString("nome") );
		 
		                return func;
		            }
		        }
		        catch (SQLException e){
		            e.printStackTrace();
		        }
		        finally{
		            if (rs != null ) {
		                try { rs.close(); } catch (SQLException e) { ; }
		                rs = null;
		            }
		            if (ps != null ) {
		                try { ps.close(); } catch (SQLException e) { ; }
		                ps = null;
		            }
		            if (conn != null ) {
		                try { conn.close(); } catch (SQLException e) { ; }
		                conn = null;
		            }
		        }
		        return null;
		    }
		    */
	}

}
