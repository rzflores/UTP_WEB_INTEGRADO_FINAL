package utp.webIntegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.webIntegrado.entidades.Categoria;
import utp.webIntegrado.entidades.Curso;
import utp.webIntegrado.entidades.Temario;



public class DaoCurso extends DaoGenerico{
	public List<Curso> consultarCurso(){
		List<Curso> lst = new ArrayList<Curso>();
		String sql = "select cu.id , cu.nombre , cu.precio , cu.descripcion , ca.nombre  as categoria, te.url "
				+ "from curso  cu "
				+ "inner join categoria ca  on ca.id = cu.\"idCategoria\""
				+ "inner join  temario te on te.id =cu.\"idTemario\"";
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				Curso cu = new Curso();
				cu.setIdCurso(rs.getInt("id"));
				cu.setNombre(rs.getString("nombre"));
				cu.setPrecio(rs.getDouble("precio"));;
				cu.setDescripcion(rs.getString("descripcion"));
				Categoria ca = new Categoria();
				ca.setNombre(rs.getString("categoria"));
				cu.setCategoria(ca);
				Temario te = new Temario();
				te.setUrl(rs.getString("url"));
				cu.setTemario(te);
				lst.add(cu);				
			}
			cnx.close();		
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	
}
