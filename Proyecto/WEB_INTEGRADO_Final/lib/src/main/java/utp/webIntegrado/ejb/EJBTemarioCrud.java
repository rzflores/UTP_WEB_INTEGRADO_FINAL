package utp.webIntegrado.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class EJBTemarioCrud
 */
@Stateless
@LocalBean
public class EJBTemarioCrud {

	
	
	  @PersistenceContext(unitName = "web-integrado-jpa")
			private EntityManager em;	
	    /**
    /**
     * Default constructor. 
     */
    public EJBTemarioCrud() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean eliminarTemario(int idTemario){
		
    	   

    	Query query = em.createNamedQuery("Temario.eliminarTemario");   
    	query.setParameter("idCurso",idTemario);    	          
    	query.executeUpdate();
    	
    
//    	
    	return true;
    	
    }

}
