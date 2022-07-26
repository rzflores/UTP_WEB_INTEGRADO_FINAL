package utp.webIntegrado.proc.registrarMatricula;


import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Body;

import utp.webIntegrado.dto.DTOConsultaParticipante;
import utp.webIntegrado.dto.DTOParticipanteMatricula;
import utp.webIntegrado.dto.DTORegistrarMatricula;
import utp.webIntegrado.dto.DTORestRespuesta;
import utp.webIntegrado.proc.gestionCursos.dto.DTOConsultaCurso;


/**
 * Session Bean implementation class EJBCompraCurso
 */
@Path("EJBMatriculaEstudiante")
@Stateless
@LocalBean
public class EJBMatriculaEstudiante {
	
	  @PersistenceContext(unitName = "web-integrado-jpa")
			private EntityManager em;	

		public EJBMatriculaEstudiante() {
			
		}
		
	  


		@POST
		@Path("registrarMatricula")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public DTORestRespuesta registrarMatricula(DTORegistrarMatricula dtoRegistrarMatricula ) {
			
			DTORestRespuesta res = new DTORestRespuesta();
			em.createNativeQuery("INSERT INTO public.matricula( "
					+ "	fecha, nota, id_curso, id_usuario) "
					+ "	VALUES (?, ?, ?, ?);")
			.setParameter(1, LocalDate.now() )
			.setParameter(2, 0)
			.setParameter(3, dtoRegistrarMatricula.getIdCurso())
			.setParameter(4, dtoRegistrarMatricula.getIdUsuario())
			.executeUpdate();
		
			res.setCodigo(200);
			res.setMensaje("Se Matriculo Correctamente");
			
			
			return res;
			
		}
	    
	    
	}
