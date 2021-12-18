package br.com.loja.virtual.db.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.db.connection.factory.ConnectionFactory;

import br.com.loja.virtual.db.connection.factory.ConnectionFactory;

public class TesteDelete {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.recuperarConexao();
		
		Statement stm = conn.createStatement();
		stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
		
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
	}
}
