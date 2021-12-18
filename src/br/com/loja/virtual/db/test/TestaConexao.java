package br.com.loja.virtual.db.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.loja.virtual.db.connection.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		 Connection connection = connectionFactory.recuperarConexao();
		 
		 System.out.println("Fechando conexão");
		 connection.close();
	}
	
}
