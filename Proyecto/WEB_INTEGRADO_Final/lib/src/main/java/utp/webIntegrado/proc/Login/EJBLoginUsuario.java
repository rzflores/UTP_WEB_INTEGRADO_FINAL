package utp.webIntegrado.proc.Login;

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
import utp.webIntegrado.jpa.entidades.Curso;
import utp.webIntegrado.jpa.entidades.Usuario;
import utp.webIntegrado.jpa.entidades.UsuariosMenus;
import utp.webIntegrado.proc.gestionCursos.dto.DTOConsultaCurso;

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
  	
    	return lstDto;
    	
    }
    
    
    public String UsuarioLogin(DTOUsuarioLogin usuarioLogin){
		
    	Query query = em.createNamedQuery("Usuario.loginUsuario");   
    	query.setParameter("correo",usuarioLogin.getCorreo());
    	query.setParameter("contrasenia",usuarioLogin.getPassword());
    	
    	
    	
    	
    	  long result  =  query.getResultStream().count();
    	
    	  System.out.println(result);
    	  
    	if(result > 0) {
    		return "pageLayout";
    	}
    	
    	return "login";
    	
    }
    
    
    public DTOUsuarioLogeado obtenerUsuarioLogeado(DTOUsuarioLogin usuarioLogin){
		
    	DTOUsuarioLogeado dtoUsuarioLogeado = new DTOUsuarioLogeado();       	
    	Query query = em.createNamedQuery("Usuario.loginUsuario");   
    	query.setParameter("correo",usuarioLogin.getCorreo());
    	query.setParameter("contrasenia",usuarioLogin.getPassword());
    	
    	Usuario ususuarioLogin = new Usuario();
    	
    	Usuario user = (Usuario)query.getSingleResult();
    	
    	
    	dtoUsuarioLogeado.setIdRol(user.getRole().getId());
    	dtoUsuarioLogeado.setIdUsuario(user.getId());
    	
    	return dtoUsuarioLogeado;
    	
    }
    
    
    
    	public DTOObtenerUsuarioMenu obtenerUsuarioMenu(DTOUsuarioLogeado  dtoUsuarioLogeado){
		
    	
    	List<Menu> lstMe = new ArrayList<Menu>();
    	Query query = em.createNamedQuery("UsuariosMenus.obtenerMenusUsuario");   
    	query.setParameter("idUsuario",dtoUsuarioLogeado.getIdUsuario());    	
    	
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
