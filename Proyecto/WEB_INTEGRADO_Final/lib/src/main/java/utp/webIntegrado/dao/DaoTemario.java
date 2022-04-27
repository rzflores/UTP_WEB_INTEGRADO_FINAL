package utp.webIntegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utp.webIntegrado.entidades.Categoria;
import utp.webIntegrado.entidades.Temario;

public class DaoTemario extends DaoGenerico{
	public ArrayList<Temario> consultarTemario(){
		ArrayList<Temario> lst = new ArrayList<Temario>();
		String sql = "select * from Temario";
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				
				Temario ca = new Temario();
				ca.setIdTemario(rs.getInt("id"));
				ca.setUrl(rs.getString("url"));
				ca.setFechaSubida(rs.getDate("fechaSubida"));
				ca.setNombreArchivo(rs.getString("nombreArchivo"));
				
				
				lst.add(ca);				
			}
			cnx.close();		
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	

	public void insertarTemario(Temario te) {
		String sql = "insert into temario values(?,?)" ;
		Connection cnx = getConnection();
		try {
		      
	        PreparedStatement stm = cnx.prepareStatement(sql);
	        stm.setInt(1, te.getIdTemario());
	        stm.setString(2, te.getUrl());
	        stm.setDate(3, te.getFechaSubida());
	        stm.executeUpdate();	        	       
	
	        cnx.close();	        
	    } catch (Exception e) {
	    	throw new RuntimeException(e);
	    }
	    
	}
	public void actualizarTemario(Temario te) {
		String sql = "Update from temario "
				+ "set url = ? ,"
				+ "fechaSubida = ?"
				+ "where id = ?";
		Connection cnx = getConnection();
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
	        stm.setString(1, te.getUrl());
	        stm.setDate(2, te.getFechaSubida());
	        stm.setInt(3, te.getIdTemario());
	        stm.executeUpdate();	
			
		}catch (Exception e) {
	    	throw new RuntimeException(e);
	    }
		
	}
	
	public boolean eliminarTemario(int idTemario) {
	    boolean resultado = false;
	    String sql = "Delete from temario where id =" +idTemario;
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
