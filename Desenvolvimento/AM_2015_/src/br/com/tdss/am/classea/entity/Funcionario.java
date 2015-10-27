package br.com.tdss.am.classea.entity;

/**
 * TO - Funcionario
 */
public class Funcionario extends Pessoa {

	private String dt_admissao;
	private String ds_cargo;
	private String login;
	private String senha;
	private String nome;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDt_admissao() {
		return dt_admissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
