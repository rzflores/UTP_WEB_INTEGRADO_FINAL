package utp.webIntegrado.proc.Login;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import utp.webIntegrado.dto.DTOConsultaCurso;
import utp.webIntegrado.dto.DTOLoginUsuario;
import utp.webIntegrado.jpa.entidades.Curso;
import utp.webIntegrado.jpa.entidades.Usuario;

/**
 * Session Bean implementation class EJBLoginUsuario
 */
@Stateless
@LocalBean
public class EJBLoginUsuario {

	
	@PersistenceContext(unitName = "web-integrado-jpa")
	private EntityManager em;	
    /**
     * Default constructor. 
     */
    public EJBLoginUsuario() {
        // TODO Auto-generated constructor stub
    }
    
    public List<DTOLoginUsuario> loginUsuario(String correo , String contrasenia){
		
    	List<DTOLoginUsuario> lstDto = new ArrayList<DTOLoginUsuario>();       	
    	Query query = em.createNamedQuery("Usuario.loginUsuario");   
    	query.setParameter("correo",correo);
    	query.setParameter("contrasenia",contrasenia);
    	
    	List<Usuario> lstUser = query.getResultList();
    	
    	
    	
    	for( Usuario u : lstUser ) 
    	{
    		DTOLoginUsuario dto = new DTOLoginUsuario();
    		dto.setIdUsuario(u.getId());
    		dto.setIdRol(u.getRole().getId());
    		
    		
    		
    		lstDto.add(dto);
    	}
   	
    	
//    	
    	return lstDto;
    	
    }

}
