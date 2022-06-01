package utp.webIntegrado.proc.Compra;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import utp.webIntegrado.dto.DTOConsultaCurso;
import utp.webIntegrado.jpa.entidades.Curso;


/**
 * Session Bean implementation class EJBCompraCurso
 */
@Stateless
@LocalBean
public class EJBCompraCurso {

	@PersistenceContext(unitName = "web-integrado-jpa")
	private EntityManager em;	
	
    /**
     * Default constructor. 
     */
    public EJBCompraCurso() {
        // TODO Auto-generated constructor stub
    }
    
    public List<DTOConsultaCurso> consultarCurso(String cadena){
    		
    	List<DTOConsultaCurso> lstDto = new ArrayList<DTOConsultaCurso>();      	    
    	Query query = em.createNamedQuery("Curso.consultaCursoPorNombre");
    	query.setParameter("cadena","%"+cadena+"%");    	          	   
    	List<Curso> lstConsultaCurso = query.getResultList();
    	
    	for( Curso cu : lstConsultaCurso ) 
    	{
    		DTOConsultaCurso dto = new DTOConsultaCurso();
    		dto.setIdCurso(cu.getId());
    		dto.setNombreCurso(cu.getNombre());
    		dto.setPrecioCurso(cu.getPrecio());
    		dto.setDescripcion(cu.getDescripcion());
            dto.setNombreCategoria(cu.getCategoria().getNombre());
            dto.setUrlTemario(cu.getTemario().getUrl());
    		
    		lstDto.add(dto);
    	}
   	
    	
//    	for(DTOConsultaCurso objCurso : lst) {
//    		DTOConsultaCurso objCursoDto = new DTOConsultaCurso();
//    		
//    	}    	    	
    	//List<DTOConsultaCurso> lst = null;
    	//curso  = em.con(Curso.class, cadena);    	
    	//DaoCurso  dao = new DaoCurso();
    	//lst = dao.consultaCursoPorNombre("%"+cadena+"%");
    	
    	return lstDto;
    	
    }

}
