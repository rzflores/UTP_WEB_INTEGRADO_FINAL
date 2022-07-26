package utp.webIntegrado.proc.Consulta;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import utp.webIntegrado.jpa.entidades.*;
import utp.webIntegrado.proc.gestionCursos.dto.DTOConsultaCurso;


/**
 * Session Bean implementation class EJBCompraCurso
 */
@Stateless
@LocalBean
public class EJBConsultaCursoNombre {

	@PersistenceContext(unitName = "web-integrado-jpa")
	private EntityManager em;	
	
    /**
     * Default constructor. 
     */
    public EJBConsultaCursoNombre() {
        // TODO Auto-generated constructor stub
    }
    
//    public List<DTOConsultaCurso> consultarCurso(String cadena){
//    		
//    	List<DTOConsultaCurso> lstDto = new ArrayList<DTOConsultaCurso>();   
////    	TypedQuery<Curso> query= em.createQuery("SELECT c FROM curso c", Curso.class);
//////      List<Department> resultList = query.getResultList();
//    	Query query = em.createNamedQuery("Curso.findAll");   
//    	query.setParameter("cadena","%"+cadena+"%");    	          
//    	
//    	List<Curso> lstConsultaCurso = query.getResultList();
//    	
//    	
//    	
//    	for( Curso cu : lstConsultaCurso ) 
//    	{
//    		DTOConsultaCurso dto = new DTOConsultaCurso();
//    		dto.setIdCurso(cu.getId());
//    		dto.setNombreCurso(cu.getNombre());
//    		dto.setPrecioCurso(cu.getPrecio());
//    		dto.setDescripcion(cu.getDescripcion());
//            dto.setNombreCategoria(cu.getCategoria().getNombre());
//            dto.setUrlTemario(cu.getTemario().getUrl());
//    		
//    		lstDto.add(dto);
//    	}
//   	
//    	
////    	
//    	return lstDto;
//    	
//    }
//
}
