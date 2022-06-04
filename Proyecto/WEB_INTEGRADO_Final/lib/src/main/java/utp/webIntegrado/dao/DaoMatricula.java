package utp.webIntegrado.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import utp.webIntegrado.dto.DTOConsultaCurso;
import utp.webIntegrado.dto.DTOParticipanteMatricula;


public class DaoMatricula extends DaoGenerico {
	public void insertarMatriculas(DTOParticipanteMatricula dto, List<DTOConsultaCurso> lst) {
		String sql = "insert into matricula(fecha,id_curso,id_usuario) values (?, ? , ?)";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		Connection cnx = getConnection();
		try {
			for (DTOConsultaCurso dtoCursoConsulta : lst) {
				System.out.println(dtoCursoConsulta.getIdCurso());
				LocalDate localDate = LocalDate.now();
				PreparedStatement stm = cnx.prepareStatement(sql);			
				stm.setDate(1,Date.valueOf(localDate) );
				stm.setInt(2, dto.getIdParticipante());
				stm.setInt(3, dtoCursoConsulta.getIdCurso());
				stm.execute();
			}
			cnx.close(); 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
