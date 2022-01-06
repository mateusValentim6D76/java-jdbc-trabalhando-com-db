package br.com.loja.virtual.db.connection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

	private Connection conn;

	public CategoriaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Categoria> listar() throws SQLException{
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		String sql = "SELECT * FROM CATEGORIA";
		
		try(PreparedStatement pstm = conn.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
						
					categorias.add(categoria);
				}
			}
		}
		return categorias; 
	}
}
