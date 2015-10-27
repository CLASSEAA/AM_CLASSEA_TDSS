package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tdss.am.classea.dao.interfaces.ProdutoServicoDAO;
import br.com.tdss.am.classea.entity.ProdutoServico;

public class OracleProdutoServicoDAO implements ProdutoServicoDAO {

	private static String SQL_LISTA = "SElECT PS.ID_TIPO_SERVICO, PS.DS_SERVICO, HP.VL_PRECO FROM T_AM_CLA_PRODUTO_SERVICO PS"
			+ " INNER JOIN T_AM_CLA_HIST PRECO HP"
			+ " ON (PS.ID_TIPO_SERVICO = HP.ID_TIPO_SERVICO)"
			+ " TO_CHAR(HP.DT_VALIDADE, 'YYYYMMDD') >= '20150131')";
	
	@Override
	public ArrayList<ProdutoServico> listarProdutoServico() throws SQLException {
		Connection conn = null;
		try {
			ArrayList<ProdutoServico> ps = new ArrayList<ProdutoServico>();
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(SQL_LISTA);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ProdutoServico p = new ProdutoServico();
				p.setIdTipoServico(rs.getInt("ID_TIPO_SERVICO"));
				p.setDescricao(rs.getString("DS_SERVICO"));
				p.setPreco(rs.getDouble("VL_PRECO"));
				ps.add(p);
			}
			return ps;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao conectar com BD");
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

	
}
