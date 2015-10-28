	package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tdss.am.classea.dao.interfaces.ConsumoDao;
import br.com.tdss.am.classea.entity.Consumo;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;
import br.com.tdss.am.classea.entity.ProdutoServico;
/**
 * Classe para implementação de {@link Consumo} no banco de dados
 * @author Ivan Tarabay
 * */
public class OracleConsumoDao implements ConsumoDao {

	/**
	 * Metodo para inclusão de {@link Consumo} no Banco de Dados
	 * @throws SQLException
	 * @return void
	 * */
	@Override
	public void incluirConsumo(Consumo consumo, Hospedagem hospedagem, Funcionario funcionario) throws SQLException {
		Connection conn = null;

		try {

			conn = ConnectionManager.getInstance().getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO T_AM_CLA_CONSUMO (ID_CONSUMO,"
							+ " ID_HOSPEDAGEM, ID_TIPO_SERVICO, ID_FUNCIONARIO, DT_CONSUMO, QT_CONSUMIDA)"
							+ "VALUES (SQ_AM_CONSUMO.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE, 'DDMMYY'), ?)");

			stmt.setInt(1, hospedagem.getIdHospedagem());
			stmt.setInt(2, consumo.getProdutoServico().getIdTipoServico());
			stmt.setInt(3, funcionario.getIdPessoa());
			stmt.setInt(4, consumo.getQuantidade());

			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			throw new SQLException("Erro ao registrar no banco");
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
	 * Metodo para a listagem de {@link Consumo}
	 * @return ArrayLista<{@link Consumo}>
	 * @throws SQLException
	 * */
	@Override
	public ArrayList<Consumo> listarConsumo(Hospedagem hospedagem) throws SQLException {
		ArrayList<Consumo> consumoTotal = new ArrayList<Consumo>();
		Connection conn = null;

		try {

			conn = ConnectionManager.getInstance().getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("SELECT "
							+ "CS.ID_CONSUMO, "
							+ "CS.ID_TIPO_SERVICO, "
							+ "PS.DS_SERVICO, "
							+ "CS.ID_FUNCIONARIO, "
							+ "CS.DT_CONSUMO, "
							+ "CS.QT_CONSUMIDA, "
							+ "P.NM_PESSOA, "
							+ "HP.VL_PRECO "
							+ "FROM T_AM_CLA_CONSUMO CS "
							+ "INNER JOIN T_AM_CLA_PRODUTO_SERVICO PS "
							+ "ON (CS.ID_TIPO_SERVICO = PS.ID_TIPO_SERVICO) "
							+ "INNER JOIN T_AM_CLA_FUNCIONARIO F "
							+ "ON (F.ID_FUNCIONARIO = CS.ID_FUNCIONARIO) "
							+ "INNER JOIN T_AM_CLA_PESSOA P "
							+ "ON (F.ID_FUNCIONARIO = P.ID_PESSOA) "
							+ "INNER JOIN T_AM_CLA_HIST_PRECO HP "
							+ "ON (PS.ID_TIPO_SERVICO = HP.ID_TIPO_SERVICO) "
							+ "WHERE CS.ID_HOSPEDAGEM = ? "
							+ "AND TO_CHAR(HP.DT_VALIDADE, 'YYYYMMDD') >= TO_CHAR(CS.DT_CONSUMO, 'YYYYMMDD')");

			stmt.setInt(1, hospedagem.getIdHospedagem());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Consumo consumo = new Consumo();
				ProdutoServico produtoServico = new ProdutoServico();
				Funcionario funcionario = new Funcionario();

				consumo.setIdConsumo(rs.getInt("ID_CONSUMO"));
				consumo.setData(rs.getString("DT_CONSUMO"));
				consumo.setQuantidade(rs.getInt("QT_CONSUMIDA"));

				funcionario.setIdPessoa(rs.getInt("ID_FUNCIONARIO"));
				funcionario.setNome(rs.getString("NM_PESSOA"));
				consumo.setFuncionario(funcionario);

				produtoServico.setIdTipoServico(rs.getInt("ID_TIPO_SERVICO"));
				produtoServico.setDescricao(rs.getString("DS_SERVICO"));
				produtoServico.setPreco(rs.getDouble("VL_PRECO"));
				consumo.setProdutoServico(produtoServico);
				consumo.calcularValorConsumo();

				consumoTotal.add(consumo);

			}
		} catch (SQLException e3) {
			e3.printStackTrace();
			throw new SQLException("Erro ao conectar com o banco");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					throw new SQLException("Erro ao fechar conexão");
				}
			}

		}
		return consumoTotal;
	}

	}

	
	

