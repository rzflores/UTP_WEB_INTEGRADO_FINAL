package utp.webIntegrado.proc.gestionCursos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.gestionCursos.dto.DTOConsultaCurso;


@Named
@SessionScoped
public class BeanCursos  implements Serializable {

	
	private List<DTOConsultaCurso> lstCursos;
	
	@EJB
	private EJBGestionCursos ejb;
	
	@Inject
	private BeanEditarCurso beanEditarCurso;
	
	@Inject
	private BeanEliminarCurso beanEliminarCurso;
	
	public BeanCursos() {
		
	}
	
	
	@PostConstruct
	public void inicializar() {
		lstCursos = ejb.listarCursos();		
	}


	public List<DTOConsultaCurso> getLstCursos() {
		return lstCursos;
	}


	public void setLstCursos(List<DTOConsultaCurso> lstCursos) {
		this.lstCursos = lstCursos;
	}
	
	public String EliminarCurso() {
		
		Map<String,String> mapParam  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		   int idParam = Integer.parseInt( mapParam.get("idCurso"));
		  
		return beanEliminarCurso.eliminarCurso(idParam);
	}
	
	
	
	public String RedirecionarEditarCurso() {
		
		Map<String,String> mapParam  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		int idParam = Integer.parseInt( mapParam.get("idCurso"));
		return beanEditarCurso.obtenerCurso(idParam);
	}
	
	
}
