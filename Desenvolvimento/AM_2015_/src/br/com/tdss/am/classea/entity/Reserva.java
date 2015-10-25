package br.com.tdss.am.classea.entity;

import java.util.ArrayList;


/**
 * TO - Reserva
 * */
public class Reserva {

	private int idReserva;
	private Cliente cliente;
	private Funcionario funcionario;
	private ArrayList<Quarto> quartos;
	private String dataSolicitacao;
	private String dataInicio;
	private String dataFinal;
	private int quantidadeAdulto;
	private int quantidadeCrianca;
	private boolean statusReserva;

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public ArrayList<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(ArrayList<Quarto> quartos) {
		this.quartos = quartos;
	}

	public String getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getQuantidadeAdulto() {
		return quantidadeAdulto;
	}

	public void setQuantidadeAdulto(int quantidadeAdulto) {
		this.quantidadeAdulto = quantidadeAdulto;
	}

	public int getQuantidadeCrianca() {
		return quantidadeCrianca;
	}

	public void setQuantidadeCrianca(int quantidadeCrianca) {
		this.quantidadeCrianca = quantidadeCrianca;
	}

	public boolean isStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(boolean statusReserva) {
		this.statusReserva = statusReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
