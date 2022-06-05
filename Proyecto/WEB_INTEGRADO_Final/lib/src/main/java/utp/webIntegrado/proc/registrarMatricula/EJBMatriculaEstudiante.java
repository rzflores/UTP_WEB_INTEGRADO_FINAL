package utp.webIntegrado.proc.registrarMatricula;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import utp.webIntegrado.dao.DaoCurso;
import utp.webIntegrado.dao.DaoParticipante;
import utp.webIntegrado.dao.DaoMatricula;
import utp.webIntegrado.dto.DTOConsultaCurso;
import utp.webIntegrado.dto.DTOConsultaParticipante;
import utp.webIntegrado.dto.DTOParticipanteMatricula;


/**
 * Session Bean implementation class EJBCompraCurso
 */
@Stateless
@LocalBean
public class EJBMatriculaEstudiante {

		public EJBMatriculaEstudiante() {
			
		}
		
	    public List<DTOConsultaParticipante> consultarEstudiantes(String cadena) {
	    	List<DTOConsultaParticipante> lst = null;
	    	DaoParticipante dao = new DaoParticipante();
	    	lst = dao.consultarEstudiantePorNombre("%" + cadena + "%");
	    	return lst;
	    }
	    
		public DTOParticipanteMatricula consultarParticipantePorId(int idParticipante) {
			DTOParticipanteMatricula dto = null;
			DaoParticipante dao = new DaoParticipante();
			dto = dao.consultarparticipantePorId(idParticipante);
			return dto;
		}

		public List<DTOConsultaCurso> consultaCursoPorNombre(String cadena) {
			List<DTOConsultaCurso> lst = null;
			DaoCurso dao = new DaoCurso();
			lst = dao.consultaMatriculaCursoPorNombre("%" + cadena + "%");
			return lst;
			
		}

		public void matricular(DTOParticipanteMatricula dto, List<DTOConsultaCurso> lst) {
			
			System.out.println(dto.getCorreoParticipante());
			DaoMatricula dao = new DaoMatricula();
			dao.insertarMatriculas(dto, lst);
		
			
		}
	    
	    
	}
