package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tdss.am.classea.dao.interfaces.HospedagemDao;
import br.com.tdss.am.classea.entity.Cliente;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

/**
 * @author Ivan Tarabay
 * Classe para implementação de {@link Hospedagem} no banco de dados
 * */
public class OracleHospedagemDao implements HospedagemDao {
	
	
	/**
	 * Metodo responsavel pela inclusão de {@link Hospedagem} no banco de dados
	 * @return void
	 * @throws SQLException
	 * */
	@Override
	public void incluirHospedagem(Hospedagem hospedagem, Funcionario funcionario) throws SQLException {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			PreparedStatement stmt = conn.prepareStatement
					("INSERT INTO T_AM_HOSPEDAGEM "
					+ "(ID_HOSPEDAGEM, NR_QUARTO, ID_RESERVA, ID_CLIENTE, ID_FUNCIONARIO,"
					+ " VL_PERC_DESCONTO, DT_ENTRADA)"
					+ " VALUES"
					+ " (SQ_AM_HOSPEDAGEM, ?, ?, ?, ?, 0, ?)");
			
			stmt.setInt(1, hospedagem.getQuarto().getNumero());
			stmt.setInt(2, hospedagem.getReserva().getIdReserva());
			stmt.setInt(3, hospedagem.getReserva().getCliente().getIdPessoa());
			stmt.setInt(4, hospedagem.getFuncionario().getIdPessoa());
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao conectar com o banco");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
					throw new SQLException("Erro ao fechar a conexão");
				}
			}
		}
		
	}

	/**
	 * Metodo para busca de {@link Hospedagem} no banco de dados
	 * @return {@link Hospedagem}
	 * */
	@Override
	public Hospedagem buscarHospedagem(int idHospedagem) throws SQLException {
		Connection conn = null;
		Hospedagem hospedagem;
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT "
					+ "ID_HOSPEDAGEM, "
					+ "NR_QUARTO, "
					+ "ID_RESERVA, "
					+ "ID_CLIENTE, "
					+ "ID_FUNCIONARIO, "
					+ "DT_ENTRADA, "
					+ "DT_SAIDA "
					+ "FROM T_AM_CLA_HOSPEDAGEM "
					+ "WHERE ID_HOSPEDAGEM = ?"
					);
			
			stmt.setInt(1, idHospedagem);
			ResultSet rs = stmt.executeQuery();
			hospedagem = new Hospedagem();
			while (rs.next()) {
				Quarto quarto = new Quarto();
				Funcionario funcionario = new Funcionario();
				Reserva reserva = new Reserva();
				Cliente cliente = new Cliente();
				hospedagem.setIdHospedagem(rs.getInt("ID_HOSPEDAGEM"));
				quarto.setNumero(rs.getInt("NR_QUARTO"));
				reserva.setIdReserva(rs.getInt("ID_RESERVA"));
				cliente.setIdPessoa(rs.getInt("ID_CLIENTE"));
				reserva.setCliente(cliente);
				funcionario.setIdPessoa(rs.getInt("ID_FUNCIONARIO"));
				hospedagem.setFuncionario(funcionario);
				hospedagem.setReserva(reserva);
				hospedagem.setDataEntrada(rs.getString("DT_ENTRADA"));
				if(rs.getString("DT_SAIDA") != null){
					hospedagem.setDataSaida(rs.getString("DT_SAIDA"));
				}
				
				return hospedagem;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao conectar com o banco");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
					throw new SQLException("Erro ao fechar a conexão");
				}
			}
		}
		return null;
	}

	
	
}
