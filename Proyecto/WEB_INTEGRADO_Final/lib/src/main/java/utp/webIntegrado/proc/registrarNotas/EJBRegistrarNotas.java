package utp.webIntegrado.proc.registrarNotas;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import utp.webIntegrado.entidades.Menu;
import utp.webIntegrado.jpa.entidades.Matricula;
import utp.webIntegrado.jpa.entidades.UsuariosMenus;
import utp.webIntegrado.proc.registrarNotas.dto.DTOParticipanteEvaluar;

/**
 * Session Bean implementation class EJBRegistrarNotas
 */


@Path("EJBRegistrarNotas")
@Stateless
@LocalBean
public class EJBRegistrarNotas {

    /**
     * Default constructor. 
     */
    public EJBRegistrarNotas() {
        // TODO Auto-generated constructor stub
    }
	@PersistenceContext(unitName = "web-integrado-jpa")
	private EntityManager em;
    

	@GET
    @Path("obtenerParticipanteEvaluar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOParticipanteEvaluar> obtenerParticipanteEvaluar(DTOConsultaParticipanteEvaluar dtoC){
    	
    	List<DTOParticipanteEvaluar> lstPa = new ArrayList<DTOParticipanteEvaluar>();
    	Query query;
    	if(dtoC.getCadena().equals("")) {
    		query = em.createNamedQuery("Matricula.obtenerListaParcipantesEvaluar");
    	}else {
    		query = em.createNamedQuery("Matricula.obtenerParcipantesEvaluar");   
    		query.setParameter("cadena","%"+dtoC.getCadena()+"%");    	
    		  
    	}
    	
      	List<Matricula> lstMatricula = query.getResultList();
      	
      	
      	
      	for( Matricula ma : lstMatricula ) 
      	{
      		DTOParticipanteEvaluar dto = new DTOParticipanteEvaluar();
     		dto.setIdMatriculaParticipante(ma.getId());
      		dto.setParticipante(ma.getUsuario().getPrimerNombre() + " " + ma.getUsuario().getApellidoPaterno() + " " + ma.getUsuario().getApellidoMaterno());
      		dto.setCursoNombre(ma.getCurso().getNombre());
      		dto.setNota(ma.getNota());
      		
      		lstPa.add(dto);    		    		    		    		    		    		
      	}
     

      	return lstPa;
      	
      }
    
    
		public DTOParticipanteEvaluar obtenerParticipanteEvaluarPorId(int idParticipanteMatricula){
    	
    	
    	Query query =  em.createNamedQuery("Matricula.obtenerParcipantesEvaluarPorId");   
    	query.setParameter("idParticipanteMatricula",idParticipanteMatricula);    	
    	
      	Matricula participanteMatricula = (Matricula)query.getSingleResult();
      	
      		DTOParticipanteEvaluar dto = new DTOParticipanteEvaluar();
     		dto.setIdMatriculaParticipante(participanteMatricula.getId());
      		dto.setParticipante(participanteMatricula.getUsuario().getPrimerNombre() + " " + participanteMatricula.getUsuario().getApellidoPaterno() + " " + participanteMatricula.getUsuario().getApellidoMaterno());
      		dto.setCursoNombre(participanteMatricula.getCurso().getNombre());
      		dto.setNota(participanteMatricula.getNota());
      		
      	


      	return dto;
      	
      }
    
    
		@POST
		@Path("registrarNota")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
    	public boolean registrarNota(DTOParticipanteEvaluar  dto){
  		
      	
    	Query query =  em.createQuery("UPDATE Matricula m SET m.nota =:notaCalificada   WHERE m.id =:idParticipanteMatricula");   
      	query.setParameter("idParticipanteMatricula",dto.getIdMatriculaParticipante());
      	query.setParameter("notaCalificada", dto.getNota() );
      	
      	 query.executeUpdate();
      	
      	     

      	return true;
      	
      }
    
    
    
}
