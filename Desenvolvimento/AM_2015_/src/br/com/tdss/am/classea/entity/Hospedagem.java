package br.com.tdss.am.classea.entity;

import java.util.ArrayList;
/**
 * TO - Hospedagem
 * */
public class Hospedagem {
	
	private int idHospedagem;
	private Reserva reserva;
	private Funcionario funcionario;
	private Quarto quarto;
	private ArrayList<Consumo> consumo;
	private String dataEntrada;
	private String dataSaida;

	
	public int getIdHospedagem() {
		return idHospedagem;
	}
	public void setIdHospedagem(int idHospedagem) {
		this.idHospedagem = idHospedagem;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public ArrayList<Consumo> getConsumo() {
		return consumo;
	}
	public void setConsumo(ArrayList<Consumo> consumo) {
		this.consumo = consumo;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	
}
