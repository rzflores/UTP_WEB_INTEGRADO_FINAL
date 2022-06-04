package utp.webIntegrado.proc.obtenerMenus;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import utp.webIntegrado.dto.DTOLoginUsuario;
import utp.webIntegrado.dto.DTOObtenerUsuarioMenu;
import utp.webIntegrado.entidades.Menu;
import utp.webIntegrado.jpa.entidades.Usuario;
import utp.webIntegrado.jpa.entidades.UsuariosMenus;

/**
 * Session Bean implementation class EJBObtenerMenus
 */
@Stateless
@LocalBean
public class EJBObtenerMenus {

	
	
	@PersistenceContext(unitName = "web-integrado-jpa")
	private EntityManager em;	
    /**
     * Default constructor. 
     */
    public EJBObtenerMenus() {
        // TODO Auto-generated constructor stub
    }
    
    
  public DTOObtenerUsuarioMenu obtenerUsuarioMenu(int  idUsuario){
		
    	
    	List<Menu> lstMe = new ArrayList<Menu>();
    	Query query = em.createNamedQuery("UsuariosMenus.obtenerMenusUsuario");   
    	query.setParameter("idUsuario",idUsuario);    	
    	
    	List<UsuariosMenus> lstUsuarioMenu = query.getResultList();
    	
    	
    	DTOObtenerUsuarioMenu dto = new DTOObtenerUsuarioMenu();
    	for( UsuariosMenus um : lstUsuarioMenu ) 
    	{
    		
    		dto.setNombreUsuario(um.getUsuario().getPrimerNombre());
    		dto.setNombreRol(um.getUsuario().getRole().getNombre());
    		Menu me = new Menu();
    		me.setNombre(um.getMenus().getNombre());
    		me.setLink(um.getMenus().getLink());
    		lstMe.add(me);    		    		    		    		    		    		
    		
    	}
    	dto.setLstMenu(lstMe);

    	return dto;
    	
    }

}
