package br.com.loja.virtual.db.test;

import java.sql.SQLException;
import java.util.Iterator;

import br.com.loja.virtual.db.connection.factory.ConnectionFactory;

public class TestaPoolDeConexoes {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connFactory = new ConnectionFactory();
		
		for (int i = 0;  i < 20; i++) {
			connFactory.recuperarConexao();
			System.out.println("Conexão de número" + i);
		}
	}

}
