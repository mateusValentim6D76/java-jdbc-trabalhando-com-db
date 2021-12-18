package br.com.loja.virtual.db.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.db.connection.factory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.recuperarConexao();
		
		Statement stm = conn.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		/*Retorna true se for uma lista, no caso de um SELECT
		 * Em caso de insert, ou delete ou update retorna false
		 */
		ResultSet rst = stm.getResultSet();
		//Se tiver próximo...
		while (rst.next()) {
			//Nome e tipo da coluna
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		conn.close();
	}
}
