package br.com.loja.virtual.db.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.db.connection.factory.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.recuperarConexao();
		conn.setAutoCommit(false);

		PreparedStatement stm = conn.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",
				Statement.RETURN_GENERATED_KEYS);

		adicionarVariavel("MP4", "MP4 AZUL", stm);
		adicionarVariavel("Radio", "Radio AM/FM", stm);
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		if(nome.equals("Radio")) {
			throw new RuntimeException("Não foi possivel adicionar o PRODUTO");
		}

		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);

		}
		rst.close();
	}
}
