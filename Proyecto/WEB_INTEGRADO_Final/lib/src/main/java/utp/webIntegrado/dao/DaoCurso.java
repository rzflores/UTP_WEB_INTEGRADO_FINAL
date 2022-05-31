package utp.webIntegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utp.webIntegrado.dto.DTOConsultaCurso;
import utp.webIntegrado.entidades.Curso;
import utp.webIntegrado.entidades.Categoria;
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
	
	
	public List<DTOConsultaCurso> consultaCursoPorNombre(String cadena){
		List<DTOConsultaCurso> lst = new ArrayList<DTOConsultaCurso>();
		String sql = "select curso.id , cu.nombre , curso.precio , curso.descripcion , categoria.nombre  as categoria, temario.url "
				+ "	from curso  curso 	"
				+ "	inner join categoria   on (categoria.id = curso.\"idCategoria\")"
				+ "	inner join  temario  on (temario.id = curso.\"idTemario\")"
				+ "	where curso.nombre like ? ";
		Connection cnx = getConnection();
		
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setString(1,cadena);
			rs = stm.executeQuery();
	
			while(rs.next()) {
				DTOConsultaCurso obj = new DTOConsultaCurso();				
				obj.setIdCurso(rs.getInt("id"));
				obj.setNombreCurso(rs.getString("nombre"));
				obj.setDescripcion(rs.getString("descripcion"));		
				obj.setNombreCategoria(rs.getString("categoria"));
				obj.setUrlTemario(rs.getString("url"));																																								
				lst.add(obj);				
			}
			cnx.close();		
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		

		return lst;
		
	}
	
	
}
