package utp.webIntegrado.proc.Consulta;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import utp.webIntegrado.jpa.entidades.Curso;
import utp.webIntegrado.jpa.entidades.Temario;
import utp.webIntegrado.proc.gestionCursos.dto.DTOConsultaCurso;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOConsultaTemario;

/**
 * Session Bean implementation class EJBConsultaTemarioNombre
 */
@Stateless
@LocalBean
public class EJBConsultaTemarioNombre {
	@PersistenceContext(unitName = "web-integrado-jpa")
	private EntityManager em;	
    /**
     * Default constructor. 
     */
    public EJBConsultaTemarioNombre() {
        // TODO Auto-generated constructor stub
    }
    
    public List<DTOConsultaTemario> consultarCurso(String cadena){
		
    	List<DTOConsultaTemario> lstDto = new ArrayList<DTOConsultaTemario>();   

    	Query query = em.createNamedQuery("Temario.findAll");   
    	query.setParameter("cadena","%"+cadena+"%");    	          
    	
    	List<Temario> lstConsultaTemario = query.getResultList();
    	
    	
    	
    	for( Temario te : lstConsultaTemario ) 
    	{
    		DTOConsultaTemario dto = new DTOConsultaTemario();
    		dto.setIdTemario(te.getId());
    		dto.setUrlTemario(te.getUrl());
    		
    		
    		lstDto.add(dto);
    	}
   	
    	
//    	
    	return lstDto;
    	
    }


}
