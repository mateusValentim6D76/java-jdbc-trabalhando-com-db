package br.com.loja.virtual.db.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.virtual.db.connection.dao.Categoria;
import br.com.loja.virtual.db.connection.dao.CategoriaDAO;
import br.com.loja.virtual.db.connection.factory.ConnectionFactory;

public class TestaListagemDeCategoria {

	public static void main(String[] args) throws SQLException {
		try(Connection conn = new ConnectionFactory().recuperarConexao()){
			CategoriaDAO categoriaDao = new CategoriaDAO(conn);
			List<Categoria> listaDeCategorias = categoriaDao.listar();
			listaDeCategorias.stream().forEach(ct -> System.out.println(ct.getNome()));
			
		}
		
	}
}
