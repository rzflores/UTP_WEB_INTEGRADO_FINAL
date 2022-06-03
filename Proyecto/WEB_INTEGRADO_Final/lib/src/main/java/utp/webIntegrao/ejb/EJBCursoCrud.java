package utp.webIntegrao.ejb;

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
 * Session Bean implementation class EJBCursoCrud
 */
@Stateless
@LocalBean
public class EJBCursoCrud {

	
	  @PersistenceContext(unitName = "web-integrado-jpa")
		private EntityManager em;	
    /**
     * Default constructor. 
     */
    public EJBCursoCrud() {
        // TODO Auto-generated constructor stub
    }
    
    

    public boolean eliminarCurso(int idCurso){
    		
   

    	Query query = em.createNamedQuery("Curso.eliminarCurso");   
    	query.setParameter("idCurso",idCurso);    	          
    	query.executeUpdate();
    	
    
//    	
    	return true;
    	
    }
  

}
