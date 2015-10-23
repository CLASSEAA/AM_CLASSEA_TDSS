package br.com.tdss.am.classea.entity;

public class Funcionario extends Pessoa {

	private String dt_admissao;
	private String ds_cargo;

	public String getDt_admissao() {
		return dt_admissao;
	}

	public void setDt_admissao(String dt_admissao) {
		this.dt_admissao = dt_admissao;
	}

	public String getDs_cargo() {
		return ds_cargo;
	}

	public void setDs_cargo(String ds_cargo) {
		this.ds_cargo = ds_cargo;
	}

}
