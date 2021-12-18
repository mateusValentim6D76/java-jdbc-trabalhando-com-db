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
		stm.execute("SELECT ID, NOME, DESCRICAO, FROM PRODUTO");
		
		/*Retorna true ou false, se a tabela estiver populada retorna true
		 * Caso esteja vazia, retorna false
		 */
		ResultSet rst = stm.getResultSet();
		//Se tiver próximo...
		while (rst.next()) {
			//Nome da coluna
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
