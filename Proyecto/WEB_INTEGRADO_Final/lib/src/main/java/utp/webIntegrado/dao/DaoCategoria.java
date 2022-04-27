package utp.webIntegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import utp.webIntegrado.entidades.Categoria;
import utp.webIntegrado.entidades.Temario;


public class DaoCategoria extends DaoGenerico{
	public ArrayList<Categoria> consultarCategoria(){
		ArrayList<Categoria> lst = new ArrayList<Categoria>();
		String sql = "select * from categoria";
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				
				Categoria ca = new Categoria();
				ca.setIdCategoria(rs.getInt("id"));
				ca.setNombre(rs.getString("nombre"));
				ca.setDescripcion(rs.getString("descripcion"));
				ca.setNombreCorto(rs.getString("nombreCorto"));
				
				
				lst.add(ca);				
			}
			cnx.close();		
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public void insertarCategoria(Categoria ca) {
		String sql = "insert into categoria values(?,?)" ;
		Connection cnx = getConnection();
		try {
		      
	        PreparedStatement stm = cnx.prepareStatement(sql);
	        stm.setInt(1, ca.getIdCategoria());
	        stm.setString(2, ca.getNombre());
	        stm.executeUpdate();	        	       
	
	        cnx.close();	        
	    } catch (Exception e) {
	    	throw new RuntimeException(e);
	    }
	    
	}
	
	public void actualizarCategoria(Categoria ca) {
		String sql = "Update from categoria "
				+ "set nombre = ? "
				+ "where id = ?";
		Connection cnx = getConnection();
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
	        stm.setString(1, ca.getNombre() );
	        stm.setInt(2, ca.getIdCategoria());
	        stm.executeUpdate();	
			
		}catch (Exception e) {
	    	throw new RuntimeException(e);
	    }
		
	}
	

	public boolean eliminarCategoria(int idCategoria) {
	    boolean resultado = false;
	    String sql = "Delete from categoria where id =" +idCategoria;
		Connection cnx = getConnection();
	    try {
	      
	        PreparedStatement stm = cnx.prepareStatement(sql);
	        int valor =  stm.executeUpdate(sql);	        	       
	        if(valor>0){
	            resultado = true;
	        }
	        cnx.close();	        
	    } catch (Exception e) {
	    	throw new RuntimeException(e);
	    }
	    return resultado;
	}
}
