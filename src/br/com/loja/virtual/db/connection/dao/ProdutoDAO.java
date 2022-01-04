package br.com.loja.virtual.db.connection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.loja.virtual.db.connection.factory.ConnectionFactory;
import br.com.loja.virtual.db.connection.model.Produto;

public class ProdutoDAO {

	private Connection conn;

	public ProdutoDAO(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Produto produto) throws SQLException {
		try (Connection conn = new ConnectionFactory().recuperarConexao()) {

			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

			try (PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

				pstm.setString(1, produto.getNome());
				pstm.setString(2, produto.getDescricao());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						produto.setId(rst.getInt(1));
					}
				}
			}
		}
	}
}
