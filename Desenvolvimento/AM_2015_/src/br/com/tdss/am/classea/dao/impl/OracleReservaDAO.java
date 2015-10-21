package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.dao.interfaces.ReservaDAO;
import br.com.tdss.am.classea.entity.Cliente;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;

public class OracleReservaDAO implements ReservaDAO{
	
	Connection conn;
	PreparedStatement stmt;
	private static final String sqlConsultaReserva = "SELECT R.ID_RESERVA, P.ID_PESSOA, TO_CHAR(R.DT_SOLICITACAO,'DD/MM/YYYY'), TO_CHAR(R.DT_INICIO_RESERVA,'DD/MM/YYYY'), TO_CHAR(R.DT_FINAL_RESERVA,'DD/MM/YYYY'), R.QT_ADULTO, R.QT_CRIANCA, R.ST_RESERVA FROM T_AM_CLA_RESERVA R INNER JOIN T_AM_CLA_CLIENTE C ON(R.ID_CLIENTE = C.ID_CLIENTE) INNER JOIN T_AM_CLA_PESSOA P ON(C.ID_CLIENTE = P.ID_PESSOA) WHERE R.ID_RESERVA = ? ";
	private ResultSet rs;
	private Reserva reserva;
	private Cliente cliente;
	private Funcionario funcionario;
	private Quarto quarto;
	
	@Override
	public Reserva buscarReservar(Reserva reserva) {
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			//Instanciando PreparedStatement de forma que ele retorne Reserva
			stmt = conn.prepareStatement(sqlConsultaReserva);
			stmt.setInt(1, reserva.getIdReserva());
			
			rs = stmt.executeQuery(); //Atribuindo retorno do stmt(RESERVA) ao ResultSet
			
			this.reserva = new Reserva(); //Instanciando uma reserva
			cliente = new Cliente(); //Instanciando uma cliente
			funcionario = new Funcionario();
			
			
			while(rs.next()){
				this.reserva.setIdReserva(rs.getInt("ID_RESERVA"));
				//this.reserva.
				//cliente.setIdPessoa(rs.getInt("ID_PESSOA")); //pegando o id do cliente vindo da reserva e atribuindo ao cliente já instanciado
				this.reserva.setDataSolicitacao(rs.getString("TO_CHAR(R.DT_SOLICITACAO,'DD/MM/YYYY')"));
				this.reserva.setDataInicio(rs.getString("TO_CHAR(R.DT_INICIO_RESERVA,'DD/MM/YYYY')"));
				this.reserva.setDataFinal(rs.getString("TO_CHAR(R.DT_FINAL_RESERVA,'DD/MM/YYYY')"));
				this.reserva.setQuantidadeAdulto(rs.getInt("QT_ADULTO"));
				this.reserva.setQuantidadeCrianca(rs.getInt("QT_CRIANCA"));
				this.reserva.setStatusReserva(rs.getBoolean("ST_RESERVA"));
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
