package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.javafx.geom.Quat4f;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.ReservaDAO;
import br.com.tdss.am.classea.entity.Cliente;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

public class OracleReservaDAO implements ReservaDAO {

	Connection conn;
	PreparedStatement stmt;
	private static final String sqlConsultaReserva = "SELECT P.ID_PESSOA, P.NM_PESSOA, C.NR_CPF, C.NR_RG, PE.NR_LOGRADOURO, TO_CHAR(C.DT_NASCIMENTO,'DD/MM/YYYY'), L.DS_LOGRADOURO, R.ID_RESERVA, TO_CHAR(R.DT_SOLICITACAO,'DD/MM/YYYY'), TO_CHAR(R.DT_INICIO_RESERVA,'DD/MM/YYYY'), TO_CHAR(R.DT_FINAL_RESERVA,'DD/MM/YYYY'), R.QT_ADULTO, R.QT_CRIANCA, R.ST_RESERVA, Q.NR_QUARTO, Q.NR_ANDAR, TQ.DS_TIPO_QUARTO, Q.NR_ANDAR, Q.NR_CAPACIDADE, TQ.DS_TIPO_QUARTO, V.VL_PRECO_QUARTO FROM T_AM_CLA_PESSOA P, T_AM_CLA_CLIENTE C, T_AM_CLA_PESSOA_ENDE PE, T_AM_CLA_LOGRADOURO L, T_AM_CLA_RESERVA R, T_AM_CLA_RESERVA_QUARTO RQ, T_AM_CLA_QUARTO Q, T_AM_CLA_TIPO_QUARTO TQ, T_AM_CLA_HIST_VALOR V WHERE C.ID_CLIENTE = P.ID_PESSOA AND P.ID_PESSOA = PE.ID_PESSOA AND L.NR_CEP = PE.NR_CEP AND C.ID_CLIENTE = R.ID_CLIENTE AND RQ.ID_RESERVA = R.ID_RESERVA AND RQ.NR_QUARTO = Q.NR_QUARTO AND  Q.ID_TIPO_QUARTO = TQ.ID_TIPO_QUARTO AND  TQ.ID_TIPO_QUARTO = V.ID_TIPO_QUARTO AND R.ID_RESERVA = ? AND V.DT_VALIDADE = (SELECT MAX(DT_VALIDADE) FROM T_AM_CLA_HIST_VALOR WHERE ID_TIPO_QUARTO = V.ID_TIPO_QUARTO)";
	private static final String sqlConsultaFuncionario = "SELECT F.ID_FUNCIONARIO, P.NM_PESSOA, F.DS_CARGO, TO_CHAR(F.DT_ADMISSAO,'DD/MM/YYYY') FROM T_AM_CLA_PESSOA P, T_AM_CLA_FUNCIONARIO F, T_AM_CLA_RESERVA R WHERE P.ID_PESSOA = F.ID_FUNCIONARIO AND R.ID_RESERVA = ?";
	private ResultSet rs;
	private Reserva reserva;
	private Cliente cliente;
	private Funcionario funcionario;
	private ArrayList<Quarto> quartoList = new ArrayList<Quarto>();
	private Quarto quarto;

	@Override
	public Reserva buscarReservar(Reserva reserva) {
		try {
			conn = ConnectionManager.getInstance().getConnection();

			stmt = conn.prepareStatement(sqlConsultaReserva);
			stmt.setInt(1, reserva.getIdReserva());
			rs = stmt.executeQuery();

			this.reserva = new Reserva();
			cliente = new Cliente();
			while (rs.next()) {
				cliente.setIdPessoa(rs.getInt("ID_PESSOA"));
				cliente.setNome(rs.getString("NM_PESSOA"));
				cliente.setDataNascimento(rs
						.getString("TO_CHAR(C.DT_NASCIMENTO,'DD/MM/YYYY')"));
				cliente.setCpf(rs.getString("NR_CPF"));
				cliente.setRg(rs.getString("NR_RG"));
				cliente.setEndereco(rs.getString("DS_LOGRADOURO"));
				quarto = new Quarto();
				quarto.setAndar(rs.getInt("NR_ANDAR"));
				quarto.setCapacidade(rs.getInt("NR_CAPACIDADE"));
				quarto.setDescricaoQuarto(rs.getString("DS_TIPO_QUARTO"));
				quarto.setIdTipo(rs.getInt("ID_TIPO_QUARTO"));
				quarto.setNumero(rs.getInt("NR_QUARTO"));
				quarto.setPrecoDiaria(rs.getDouble("VL_PRECO_QUARTO"));
				quartoList.add(quarto);
				this.reserva.setIdReserva(rs.getInt("ID_RESERVA"));
				this.reserva.setDataSolicitacao(rs
						.getString("TO_CHAR(R.DT_SOLICITACAO,'DD/MM/YYYY')"));
				this.reserva
						.setDataInicio(rs
								.getString("TO_CHAR(R.DT_INICIO_RESERVA,'DD/MM/YYYY')"));
				this.reserva.setDataFinal(rs
						.getString("TO_CHAR(R.DT_FINAL_RESERVA,'DD/MM/YYYY')"));
				this.reserva.setQuantidadeAdulto(rs.getInt("QT_ADULTO"));
				this.reserva.setQuantidadeCrianca(rs.getInt("QT_CRIANCA"));
				this.reserva.setStatusReserva(rs.getBoolean("ST_RESERVA"));
				this.reserva.setCliente(cliente);
			}
			this.reserva.setQuartos(quartoList);
			this.reserva.setCliente(cliente);

			stmt = conn.prepareStatement(sqlConsultaFuncionario);
			stmt.setInt(1, reserva.getIdReserva());
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				funcionario = new Funcionario();
				funcionario.setIdPessoa(rs.getInt("ID_FUNCIONARIO"));
				funcionario.setNome("NM_PESSOA");
			}
			this.reserva.setFuncionario(funcionario);
			
			return this.reserva;
		} catch (Exception e) {
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

	@Override
	public String buscarDataAtual() {
		return null;
	}
}
