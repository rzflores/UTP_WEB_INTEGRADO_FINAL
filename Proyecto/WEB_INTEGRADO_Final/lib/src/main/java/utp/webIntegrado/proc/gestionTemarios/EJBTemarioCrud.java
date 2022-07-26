package utp.webIntegrado.proc.gestionTemarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import utp.webIntegrado.jpa.entidades.Temario;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOAgregarTemario;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOConsultaTemario;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOEditarTemario;

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
    
    public boolean insertarTemario(DTOAgregarTemario obj) {
    	
    	em.createNativeQuery("INSERT INTO temario (url, fecha_subida,nombre_archivo) VALUES (?,?,?)")
    	.setParameter(1, obj.getUrlTemario())
    	.setParameter(2, LocalDate.now() )
    	.setParameter(3, obj.getNombreArchivo()).executeUpdate();
    	return true;
    }
    
    
    public boolean eliminarTemario(int idTemario){
		
    	Query query = em.createNamedQuery("Temario.eliminarTemario");   
    	query.setParameter("idTemario",idTemario);    	          
    	query.executeUpdate(); 	
    	return true;
    	
    	
    }
    
    public boolean editarTemario(DTOEditarTemario obj) {
    	

    	em.createQuery("UPDATE Temario t SET t.nombreArchivo =:nombreArchivo , t.url =:url  WHERE t.id =:idTemario")   
    	.setParameter("nombreArchivo",obj.getNombreArchivo())
    	.setParameter("url",obj.getUrlTemario())
    	.setParameter("idTemario",obj.getIdTemario())
    	.executeUpdate();
    	return true;
    }
    
    public List<DTOConsultaTemario> listarTemarios(){
		
    	List<DTOConsultaTemario> lstResult = new ArrayList<DTOConsultaTemario>();
    	Query query = em.createNamedQuery("Temario.listarTemarios");       	         
    	List<Temario> lst  =  query.getResultList();
    	
    	lst.stream().forEach((item) -> {    		
    		lstResult.add(new DTOConsultaTemario(item.getId()  , item.getNombreArchivo() , item.getUrl()));
    	}); 
    
    	return lstResult.stream().sorted(Comparator.comparingInt( DTOConsultaTemario::getIdTemario)).toList();
    }

    public DTOEditarTemario obtenerTemarioPorId(int idTemario){
		
    	DTOEditarTemario result = new DTOEditarTemario();
    	Query query = em.createNamedQuery("Temario.obtenerTemarioPorId"); 
    	query.setParameter("idTemario",idTemario);  
    	
    	Temario obj  =  (Temario) query.getSingleResult();
    	
    	result.setIdTemario(obj.getId());
    	result.setNombreArchivo(obj.getNombreArchivo());
    	result.setUrlTemario(obj.getUrl());
    
    	return result;
    }
}
