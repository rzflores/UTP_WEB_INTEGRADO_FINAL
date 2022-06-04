package utp.webIntegrado.proc.registrarNotas;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import utp.webIntegrado.dto.DTOObtenerUsuarioMenu;
import utp.webIntegrado.dto.DTOParticipanteEvaluar;
import utp.webIntegrado.entidades.Menu;
import utp.webIntegrado.jpa.entidades.Matricula;
import utp.webIntegrado.jpa.entidades.UsuariosMenus;

/**
 * Session Bean implementation class EJBRegistrarNotas
 */
@Stateless
@LocalBean
public class EJBRegistrarNotas {

    /**
     * Default constructor. 
     */
    public EJBRegistrarNotas() {
        // TODO Auto-generated constructor stub
    }
	@PersistenceContext(unitName = "web-integrado-jpa")
	private EntityManager em;
    

    public List<DTOParticipanteEvaluar> obtenerParticipanteEvaluar(String cadena){
  		
      	
      	List<DTOParticipanteEvaluar> lstPa = new ArrayList<DTOParticipanteEvaluar>();
      	Query query = em.createNamedQuery("Matricula.obtenerParcipantesEvaluar");   
      	query.setParameter("cadena","%"+cadena+"%");    	
      	
      	List<Matricula> lstMatricula = query.getResultList();
      	
      	
      	
      	for( Matricula ma : lstMatricula ) 
      	{
      		DTOParticipanteEvaluar dto = new DTOParticipanteEvaluar();
      		dto.setIdParticipante(ma.getUsuario().getId());
      		dto.setParticipante(ma.getUsuario().getPrimerNombre() + ma.getUsuario().getApellidoPaterno() + ma.getUsuario().getApellidoMaterno());
      		dto.setCursoNombre(ma.getCurso().getNombre());
      		dto.setEsHabilitado(false);
      		
      		lstPa.add(dto);    		    		    		    		    		    		
      		
      	}
     

      	return lstPa;
      	
      }
}
