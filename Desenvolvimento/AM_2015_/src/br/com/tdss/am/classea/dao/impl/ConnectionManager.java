package br.com.tdss.am.classea.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gerenciador de conexao com o banco de dados Oracle.
 */
class ConnectionManager {

	private static ConnectionManager instance;
	
		
	private ConnectionManager() throws ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	}
	
	
	/**
	 * Pega instancia desta classe
	 * @return Instancia
	 * @throws SQLException
	 */
	public static ConnectionManager getInstance() throws SQLException{

		try{
		
			if (instance == null) {
				instance = new ConnectionManager();
			}
		
		}
		catch(ClassNotFoundException e){
			
			throw new SQLException("O Driver JDBC nao foi encontrado!");
			
		}
		
		return instance;
	}
	
	
	/**
	 * Abre uma conexao com o banco de dados.
	 * @return Um objeto que representa a conexao com o banco de dados.
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		String usuario = "OPS$RM74694";
		String senha = "020395";
		String jdbcUrl = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; 
		
		try{
		
			//Abre a conexao com o SGBDR
			return DriverManager.getConnection(jdbcUrl, usuario, senha);
	
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			throw new SQLException(e.getMessage());

		}
		
	}

}
