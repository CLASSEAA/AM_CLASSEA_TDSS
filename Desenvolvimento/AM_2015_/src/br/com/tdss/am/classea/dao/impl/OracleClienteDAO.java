package br.com.tdss.am.classea.dao.impl;

import java.sql.*;

import br.com.tdss.am.classea.dao.interfaces.ClienteDao;
import br.com.tdss.am.classea.entity.Cliente;


/**
 * Classe para busca de clientes no banco de dados
 * **/
public class OracleClienteDAO implements ClienteDao {

	private PreparedStatement stmt;
	private Connection conn;
	private static final String sqlConsulta = "SELECT C.ID_CLIENTE, P.NM_PESSOA, C.NR_CPF, C.NR_RG, to_char(C.DT_NASCIMENTO,'DDMMYYYY'), L.DS_LOGRADOURO FROM T_AM_CLA_CLIENTE C INNER JOIN T_AM_CLA_PESSOA P on(C.ID_CLIENTE = P.ID_PESSOA) INNER JOIN T_AM_CLA_PESSOA_ENDE PE ON (PE.ID_PESSOA = P.ID_PESSOA) INNER JOIN T_AM_CLA_LOGRADOURO L ON (PE.NR_CEP = L.NR_CEP) WHERE ID_CLIENTE = ?";

	
	/**
	 * Metodo que realiza a busca
	 * @param Passe <code>Cliente</code> como parametro
	 * @return <code>Cliente</code>
	 * **/
	@Override
	public Cliente buscarCliente(Cliente cliente) {
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			stmt = conn.prepareStatement(sqlConsulta);
			stmt.setInt(1, cliente.getIdPessoa());
			ResultSet rs = stmt.executeQuery();

			Cliente cliente2 = new Cliente();
			while (rs.next()) {
				cliente2.setIdPessoa(rs.getInt("ID_CLIENTE"));
				cliente2.setNome(rs.getString("NM_PESSOA"));
				cliente2.setCpf(rs.getString("NR_CPF"));
				cliente2.setRg(rs.getString("NR_RG"));
				cliente2.setDataNascimento(rs.getString("to_char(C.DT_NASCIMENTO,'DDMMYYYY')"));
				cliente2.setEndereco(rs.getString("DS_LOGRADOURO"));
			}
			return cliente2;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}	
		return null;
	}

}
