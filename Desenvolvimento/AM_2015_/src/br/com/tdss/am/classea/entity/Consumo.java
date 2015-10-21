package br.com.tdss.am.classea.entity;


public class Consumo {
	
	private int idConsumo;
	private ProdutoServico produtoServico;
	private int quantidade;
	private String data;
	private Funcionario funcionario;
	private double valorConsumo;
	
	public void calcularValorConsumo(){
		this.valorConsumo = this.produtoServico.getPreco() * quantidade;
	}
	
	public double getValorConsumo() {
		return valorConsumo;
	}
	public int getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(int idConsumo) {
		this.idConsumo = idConsumo;
	}
	public ProdutoServico getProdutoServico() {
		return produtoServico;
	}
	public void setProdutoServico(ProdutoServico produtoServico) {
		this.produtoServico = produtoServico;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
