package br.com.loja.virtual.db.connection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Produto> listar() throws SQLException{
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		
		try(PreparedStatement pstm = conn.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
					
					produtos.add(produto);
				}
			}
		} return produtos;
	} 
}
