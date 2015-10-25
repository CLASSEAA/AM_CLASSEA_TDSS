package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tdss.am.classea.dao.interfaces.QuartoDao;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;
/**
 *implementação de {@link Quarto} no banco de dados
 *@author Ivan Tarabay
 * */
public class OracleQuartoDAO implements QuartoDao {

	private Connection conn;
	String buscaQuartoReservado = ("SELECT RQ.NR_QUARTO " + "FROM T_AM_CLA_RESERVA_QUARTO RQ "
			+ "INNER JOIN T_AM_CLA_QUARTO QU "
			+ "ON(RQ.NR_QUARTO = QU.NR_QUARTO) " + "WHERE RQ.ID_RESERVA=?");
	
	String buscarQuarto  = "SELECT "
						   + "Q.ID_TIPO_QUARTO, "
						   + "Q.NR_ANDAR, "
						   + "Q.NR_CAPACIDADE, "
						   + "TQ.DS_TIPO_QUARTO, "
						   + "HV.VL_PRECO_QUARTO "
						   + "FROM T_AM_CLA_QUARTO Q "
						   + "INNER JOIN T_AM_CLA_TIPO_QUARTO TQ "
						   + "ON (Q.ID_TIPO_QUARTO = TQ.ID_TIPO_QUARTO) "
						   + "INNER JOIN T_AM_CLA_HIST_VALOR HV "
						   + "ON (TQ.ID_TIPO_QUARTO = HV.ID_TIPO_QUARTO) "
						   + "WHERE Q.NR_QUARTO = ? "
						   + "AND TO_CHAR(HV.DT_VALIDADE, 'YYYYMMDD') >= TO_CHAR(SYSDATE, 'YYYYMMDD')";
	
	
	/**
	 * Metodo para busca de uma lista de {@link Quarto} no Banco de Dados
	 * @param {@link Reserva}
	 * @return Arraylist<{@link Quarto}>
	 * @throws SQLException 
	 * */
	public ArrayList<Quarto> buscarQuartoReservado(Reserva reserva) throws SQLException {

		try {
			PreparedStatement stmt = conn.prepareStatement(buscaQuartoReservado);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Quarto> quartos = new ArrayList<Quarto>();

			while (rs.next()) {
				Quarto quarto = new Quarto();
				quarto.setNumero(rs.getInt("numero"));
				quarto.setIdTipo(rs.getInt("idTipo"));
				quarto.setAndar(rs.getInt("andar"));
				quarto.setCapacidade(rs.getInt("capacidade "));
				quarto.setPrecoDiaria(rs.getDouble("precoDiaria"));
				quartos.add(quarto);
			}
			stmt.execute();
			stmt.close();
			return quartos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao buscar quarto no Banco");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					throw new SQLException("Erro ao fechar conexão");
				}
			}
		}

	}

	/**
	 * Metodo para a busca de um único {@link Quarto} no banco de dados
	 * @return {@link Quarto}
	 * @throws SQLException
	 * */
	@Override
	public Quarto buscarQuarto(int numeroQuarto) throws SQLException {
		try {
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(buscarQuarto);
			ResultSet rs = stmt.executeQuery();
			Quarto quarto = new Quarto();
			
				quarto.setNumero(numeroQuarto);
				quarto.setAndar(rs.getInt("NR_ANDAR"));
				quarto.setCapacidade(rs.getInt("NR_CAPACIDADE"));
				quarto.setDescricaoQuarto(rs.getString("DS_TIPO_QUARTO"));
				quarto.setIdTipo(rs.getInt("ID_TIPO_QUARTO"));
				quarto.setPrecoDiaria(rs.getDouble("VL_PRECO_QUARTO"));
				
				return quarto;
				
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					throw new SQLException("Erro ao fechar conexão");
				}
			}
		}
		return null;
	}

}
