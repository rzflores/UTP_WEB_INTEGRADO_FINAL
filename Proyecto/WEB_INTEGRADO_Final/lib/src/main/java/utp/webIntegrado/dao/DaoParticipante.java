package utp.webIntegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import utp.webIntegrado.dto.*;
import utp.webIntegrado.entidades.Categoria;
import utp.webIntegrado.entidades.Curso;
import utp.webIntegrado.entidades.Temario;
import utp.webIntegrado.jpa.entidades.*;
import utp.webIntegrado.dto.*;


public class DaoParticipante extends DaoGenerico  {
	

	public List<DTOConsultaParticipante> consultarEstudiantePorNombre(String cadena) {
		List<DTOConsultaParticipante> lst = new ArrayList<DTOConsultaParticipante>();
			DTOConsultaParticipante c = null;
			String sql = "select * from usuarios where id_rol = 3 and primer_nombre like ?";
			Connection cnx = getConnection();
			ResultSet rs;

			try {
				PreparedStatement stm = cnx.prepareStatement(sql);
				stm.setString(1, cadena);
				rs = stm.executeQuery();
				while (rs.next()) {
					c = new DTOConsultaParticipante();
					c.setIdParticipante(rs.getInt("id"));
					c.setNombreParticipante(rs.getString("primer_nombre"));
					c.setApellidopaternoParticipante(rs.getString("apellido_paterno"));
					c.setApellidomaternoParticipante(rs.getString("apellido_materno"));
					c.setCorreoParticipante(rs.getString("correo"));
					c.setTelefonoParticipante(rs.getString("telefono"));								
					lst.add(c);
				}
				cnx.close();
				}
			catch(SQLException e) {
				throw new RuntimeException(e);
			}
			return lst;
		}
	
	public DTOParticipanteMatricula consultarparticipantePorId(int idParticipante) {
		DTOParticipanteMatricula dto = null;
		String sql = "select * from usuarios where id_rol = 3 and id = ?";
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, idParticipante);
			rs = stm.executeQuery();
			if (rs.next()) {
				dto = new DTOParticipanteMatricula();
				dto.setIdParticipante(rs.getInt("id"));
				dto.setNombreParticipante(rs.getString("primer_nombre"));
				dto.setCorreoParticipante(rs.getString("correo"));
				dto.setTelefonoParticipante(rs.getString("telefono"));

			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return dto;
	}
	
	
}
