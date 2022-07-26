package utp.webIntegrado.proc.gestionCursos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import utp.webIntegrado.dto.DTOSelectItem;
import utp.webIntegrado.jpa.entidades.Categoria;
import utp.webIntegrado.jpa.entidades.Curso;
import utp.webIntegrado.jpa.entidades.Temario;
import utp.webIntegrado.proc.gestionCategoria.dto.DTOConsultaCategoria;
import utp.webIntegrado.proc.gestionCursos.dto.DTOAgregarCurso;
import utp.webIntegrado.proc.gestionCursos.dto.DTOConsultaCurso;
import utp.webIntegrado.proc.gestionCursos.dto.DTOEditarCurso;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOConsultaTemario;

/**
 * Session Bean implementation class EJBCursoCrud
 */
@Path("EJBGestionCursos")
@Stateless
@LocalBean
public class EJBGestionCursos {

	
	  @PersistenceContext(unitName = "web-integrado-jpa")
		private EntityManager em;	
    /**
     * Default constructor. 
     */
    public EJBGestionCursos() {
        // TODO Auto-generated constructor stub
    }
    
    
    public boolean eliminarCurso(int idCurso){    		
   

    	Query query = em.createNamedQuery("Curso.eliminarCurso");   
    	query.setParameter("idCurso",idCurso);    	          
    	query.executeUpdate();   	       	
    	return true;
    	
    }
    
    
  public boolean insertarCurso(DTOAgregarCurso obj) {
    	
	 
    	em.createNativeQuery("INSERT INTO Curso  "
    			+ "	 (nombre, precio, descripcion, id_categoria, id_temario) "
    			+ "	VALUES (?, ?, ?, ?, ?);")
    	.setParameter(1, obj.getNombreCurso()  )
    	.setParameter(2, obj.getPrecioCurso() )
    	.setParameter(3, obj.getDescripcion() )
    	.setParameter(4, obj.getIdCategoria() )
    	.setParameter(5, obj.getIdTemario())
    	.executeUpdate();
    	
	  
	  
    	return true;
    }
    
    
    
    public boolean editarCurso(DTOEditarCurso obj) {
    	

    	em.createNativeQuery("UPDATE Curso  "
    			+ "	SET nombre = ? ,"
    			+ " precio = ? ,"
    			+ " descripcion = ?, "
    			+ " id_categoria = ?, "
    			+ " id_temario = ? "
    			+ "	WHERE id =  ?")   
    	.setParameter(1,obj.getNombreCurso())
    	.setParameter(2,obj.getPrecioCurso())
    	.setParameter(3,obj.getDescripcion())
    	.setParameter(4,obj.getIdCategoria())
    	.setParameter(5,obj.getIdTemario())
    	.setParameter(6,obj.getIdCurso())
    	.executeUpdate();
    	return true;
    }
    
    @GET
    @Path("listarCursos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOConsultaCurso> listarCursos(){
		
    	List<DTOConsultaCurso> lstResult = new ArrayList<DTOConsultaCurso>();
    	Query query = em.createNamedQuery("Curso.findAll");       	         
    	List<Curso> lst  =  query.getResultList();
    	
    	lst.stream().forEach((item) -> {    		
    		lstResult.add(new DTOConsultaCurso(item.getId() , item.getNombre() , item.getPrecio() , item.getDescripcion() , item.getCategoria().getNombre() , item.getTemario().getUrl()  ));
    	}); 
    
    	return lstResult.stream().sorted(Comparator.comparingInt( DTOConsultaCurso::getIdCurso)).toList();
    }
    
    

    public DTOEditarCurso obtenerCursoPorId(int idCurso){
		
    	DTOEditarCurso result = new DTOEditarCurso();
    	Query query = em.createNamedQuery("Curso.obtenerCursoPorId"); 
    	query.setParameter("idCurso",idCurso);  
    	
    	Curso obj  =  (Curso) query.getSingleResult();
    	
    	result.setIdCurso(obj.getId());
    	result.setNombreCurso(obj.getNombre());
    	result.setPrecioCurso(obj.getPrecio());    	
    	result.setDescripcion(obj.getDescripcion());
    	result.setNombreCategoria(obj.getCategoria().getNombre());
    	result.setUrlTemario(obj.getTemario().getUrl());
    
    	return result;
    }
  

    public List<DTOSelectItem> lstCategoria (){
    	
    	List<DTOSelectItem> lstResult = new ArrayList<DTOSelectItem>();
    	Query query = em.createNamedQuery("Categoria.listarCategorias");       	         
    	List<Categoria> lst  =  query.getResultList();
    	
    	lst.stream().forEach((item) -> {    		
    		lstResult.add(new DTOSelectItem(item.getId()  , item.getNombre()));
    	}); 
    
    	return lstResult.stream().sorted(Comparator.comparingInt( DTOSelectItem::getId)).toList();
    	
    	
    }
    
    public List<DTOSelectItem> lstTemario (){
    	
    	List<DTOSelectItem> lstResult = new ArrayList<DTOSelectItem>();
    	Query query = em.createNamedQuery("Temario.listarTemarios");       	         
    	List<Temario> lst  =  query.getResultList();
    	
    	lst.stream().forEach((item) -> {    		
    		lstResult.add(new DTOSelectItem(item.getId()  , item.getUrl()));
    	}); 
    
    	return lstResult.stream().sorted(Comparator.comparingInt( DTOSelectItem::getId)).toList();
    	
    	
    }
    
    
}
