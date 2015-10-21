package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tdss.am.classea.dao.interfaces.QuartoDao;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

public class OracleQuartoDAO implements QuartoDao {

	private Connection conn;
	String buscaQuartoReservado = ("SELECT RQ.NR_QUARTO " + "FROM T_AM_CLA_RESERVA_QUARTO RQ "
			+ "INNER JOIN T_AM_CLA_QUARTO QU "
			+ "ON(RQ.NR_QUARTO = QU.NR_QUARTO) " + "WHERE RQ.ID_RESERVA=?");
	

	public List<Quarto> buscarQuartoReservado(Reserva reserva) throws SQLException {

		try {
			PreparedStatement stmt = conn.prepareStatement(buscaQuartoReservado);
			ResultSet rs = stmt.executeQuery();
			List<Quarto> quartos = new ArrayList<Quarto>();

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

	@Override
	public Quarto buscarQuarto(int numeroQuarto) throws SQLException {
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			
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
