package br.com.loja.virtual.db.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import br.com.loja.virtual.db.connection.dao.ProdutoDAO;
import br.com.loja.virtual.db.connection.factory.ConnectionFactory;
import br.com.loja.virtual.db.connection.model.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Painel", "Painel para tv até 70 polegadas");

		try(Connection conn = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDao = new ProdutoDAO(conn);
			produtoDao.salvar(comoda);
		}

		System.out.println(comoda);
	}
}
