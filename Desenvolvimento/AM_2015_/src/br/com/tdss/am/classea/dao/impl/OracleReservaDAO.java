package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.ReservaDAO;
import br.com.tdss.am.classea.entity.Cliente;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

public class OracleReservaDAO implements ReservaDAO{
	
	Connection conn;
	PreparedStatement stmt;
	private static final String sqlConsultaReserva = "SELECT P.ID_PESSOA, P.NM_PESSOA, C.NR_CPF, C.NR_RG, L.DS_LOGRADOURO, TO_CHAR(C.DT_NASCIMENTO,'DD/MM/YYYY'), R.ID_RESERVA,TO_CHAR(R.DT_SOLICITACAO,'DD/MM/YYYY'), TO_CHAR(R.DT_INICIO_RESERVA,'DD/MM/YYYY'), TO_CHAR(R.DT_FINAL_RESERVA,'DD/MM/YYYY'), R.QT_ADULTO, R.QT_CRIANCA, R.ST_RESERVA, Q.NR_QUARTO, TQ.ID_TIPO_QUARTO, Q.NR_ANDAR, Q.NR_CAPACIDADE, TQ.DS_TIPO_QUARTO, V.VL_PRECO_QUARTO, TO_CHAR(R.DT_SOLICITACAO,'DD/MM/YYYY'), TO_CHAR(R.DT_INICIO_RESERVA,'DD/MM/YYYY'), TO_CHAR(R.DT_FINAL_RESERVA,'DD/MM/YYYY'), R.QT_ADULTO, R.QT_CRIANCA, R.ST_RESERVA FROM T_AM_CLA_PESSOA P INNER JOIN T_AM_CLA_CLIENTE C ON(P.ID_PESSOA = C.ID_CLIENTE) INNER JOIN T_AM_CLA_PESSOA_ENDE PE ON(PE.ID_PESSOA = P.ID_PESSOA) INNER JOIN T_AM_CLA_LOGRADOURO L ON (L.NR_CEP = PE.NR_CEP) INNER JOIN T_AM_CLA_RESERVA R ON(R.ID_CLIENTE = C.ID_CLIENTE) INNER JOIN T_AM_CLA_RESERVA_QUARTO RQ ON(RQ.ID_RESERVA = R.ID_RESERVA) INNER JOIN T_AM_CLA_QUARTO Q ON(RQ.NR_QUARTO = Q.NR_QUARTO) INNER JOIN T_AM_CLA_TIPO_QUARTO TQ ON(TQ.ID_TIPO_QUARTO = Q.ID_TIPO_QUARTO) INNER JOIN T_AM_CLA_HIST_VALOR V ON(V.ID_TIPO_QUARTO = TQ.ID_TIPO_QUARTO) WHERE R.ID_RESERVA = ?";
	private ResultSet rs;
	private Reserva reserva;
	private Cliente cliente;
	private Funcionario funcionario;
	private ArrayList<Quarto> quartoList;
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
			quarto = new Quarto();
			funcionario = new Funcionario();
			while(rs.next()){
				cliente.setIdPessoa(rs.getInt("ID_PESSOA"));
				cliente.setNome(rs.getString("NM_PESSOA"));
				cliente.setDataNascimento(rs.getString("TO_CHAR(C.DT_NASCIMENTO,'DD/MM/YYYY')"));
				cliente.setCpf(rs.getString("NR_CPF"));
				cliente.setRg(rs.getString("NR_RG"));
				cliente.setEndereco(rs.getString("DS_LOGRADOURO"));
				quarto.setAndar(rs.getInt("NR_QUARTO"));
				quarto.setCapacidade(rs.getInt("NR_CAPACIDADE"));
				quarto.setDescricaoQuarto(rs.getString("DS_TIPO_QUARTO"));
				quarto.setIdTipo(rs.getInt("ID_TIPO_QUARTO"));
				quarto.setNumero(rs.getInt("NR_CAPACIDADE"));
				quarto.setPrecoDiaria(rs.getDouble("VL_PRECO_QUARTO"));
				quartoList.add(quarto);
				this.reserva.setDataSolicitacao(rs.getString("TO_CHAR(R.DT_SOLICITACAO,'DD/MM/YYYY')"));
				this.reserva.setDataInicio(rs.getString("TO_CHAR(R.DT_INICIO_RESERVA,'DD/MM/YYYY')"));
				this.reserva.setDataFinal(rs.getString("TO_CHAR(R.DT_FINAL_RESERVA,'DD/MM/YYYY')"));
				this.reserva.setQuantidadeAdulto(rs.getInt("QT_ADULTO"));
				this.reserva.setQuantidadeCrianca(rs.getInt("QT_CRIANCA"));
				this.reserva.setStatusReserva(rs.getBoolean("ST_RESERVA"));
				this.reserva.setCliente(cliente);
				this.reserva.setQuartos(quartoList);
			}
			
			this.reserva.setCliente(cliente);
			
			//this.reserva.setFuncionario(rs.get);
			
			return this.reserva;
			
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

	@Override
	public String buscarDataAtual() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
