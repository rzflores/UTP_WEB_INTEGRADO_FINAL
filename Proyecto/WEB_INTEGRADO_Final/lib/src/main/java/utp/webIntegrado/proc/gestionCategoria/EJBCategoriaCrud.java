package utp.webIntegrado.proc.gestionCategoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import utp.webIntegrado.jpa.entidades.Categoria;
import utp.webIntegrado.proc.gestionCategoria.dto.DTOAgregarCategoria;
import utp.webIntegrado.proc.gestionCategoria.dto.DTOConsultaCategoria;
import utp.webIntegrado.proc.gestionCategoria.dto.DTOEditarCategoria;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOAgregarTemario;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOConsultaTemario;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOEditarTemario;

/**
 * Session Bean implementation class EJBCategoriaCrud
 */
@Stateless
@LocalBean
public class EJBCategoriaCrud {

	

	@PersistenceContext(unitName = "web-integrado-jpa")
	private EntityManager em;	
	 	  
    /**
     * Default constructor. 
     */
    public EJBCategoriaCrud() {
        // TODO Auto-generated constructor stub
    }
    
    
    public boolean insertarCategoria(DTOAgregarCategoria obj) {
    	
    	em.createNativeQuery("INSERT INTO  categoria (nombre, descripcion, nombre_corto)  "
    			+ "	VALUES (?, ?, ?);")
    	.setParameter(1, obj.getNombre())
    	.setParameter(2, obj.getDescripcion() )
    	.setParameter(3, obj.getNombreCorto()).executeUpdate();
    	return true;
    }
    
    
    public boolean eliminarCategoria(int idCategoria){
		
    	Query query = em.createNamedQuery("Categoria.eliminarCategoria");   
    	query.setParameter("idCategoria",idCategoria);    	          
    	query.executeUpdate(); 	
    	return true;
    	
    	
    }
    
    public boolean editarCategoria(DTOEditarCategoria obj) {
    	

    	em.createQuery("UPDATE Categoria c SET c.nombre =:nombreCategoria , c.descripcion =:descripcion  , c.nombreCorto  =: nombreCorto  WHERE c.id =:idCategoria")   
    	.setParameter("nombreCategoria",obj.getNombre())
    	.setParameter("descripcion",obj.getDescripcion())
    	.setParameter("nombreCorto",obj.getNombreCorto())
    	.setParameter("idCategoria",obj.getIdCategoria())
    	.executeUpdate();
    	return true;
    }
    
    public List<DTOConsultaCategoria> listarCategorias(){
		
    	List<DTOConsultaCategoria> lstResult = new ArrayList<DTOConsultaCategoria>();
    	Query query = em.createNamedQuery("Categoria.listarCategorias");       	         
    	List<Categoria> lst  =  query.getResultList();
    	
    	lst.stream().forEach((item) -> {    		
    		lstResult.add(new DTOConsultaCategoria(item.getId()  , item.getDescripcion() , item.getNombre() , item.getNombreCorto()));
    	}); 
    
    	return lstResult.stream().sorted(Comparator.comparingInt( DTOConsultaCategoria::getIdCategoria)).toList();
    }

    public DTOEditarCategoria obtenerCategoriaPorId(int idCategoria){
		
    	DTOEditarCategoria result = new DTOEditarCategoria();
    	Query query = em.createNamedQuery("Categoria.obtenerCategoriaPorId"); 
    	query.setParameter("idCategoria",idCategoria);  
    	
    	Categoria obj  =  (Categoria) query.getSingleResult();
    	
    	result.setIdCategoria(obj.getId());
    	result.setNombre(obj.getNombre());
    	result.setDescripcion(obj.getDescripcion());    	
    	result.setNombreCorto(obj.getNombreCorto());    	
    
    	return result;
    }

}
