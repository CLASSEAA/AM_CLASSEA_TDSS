package br.com.tdss.am.classea.entity;


/**
 * TO - Quarto
 * */
public class Quarto {
	
	private int numero;
	private int idTipo;
	private int andar;
	private int capacidade;
	private String descricaoQuarto;
	private double precoDiaria;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public double getPrecoDiaria() {
		return precoDiaria;
	}
	public void setPrecoDiaria(double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}
	public String getDescricaoQuarto() {
		return descricaoQuarto;
	}
	public void setDescricaoQuarto(String descricaoQuarto) {
		this.descricaoQuarto = descricaoQuarto;
	}
	
	
}
