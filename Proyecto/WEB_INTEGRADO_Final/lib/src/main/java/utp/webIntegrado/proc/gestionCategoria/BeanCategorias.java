package utp.webIntegrado.proc.gestionCategoria;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.gestionCategoria.dto.DTOConsultaCategoria;


@Named
@SessionScoped
public class BeanCategorias  implements Serializable{

	private List<DTOConsultaCategoria> lstCategoria;
	
	
	@EJB
	private EJBCategoriaCrud ejb;

	@Inject
	private BeanEditarCategoria beanEditarCategoria;
	
	@Inject
	private BeanEliminarCategoria beanEliminarCategoria;
	
	public BeanCategorias() {
		
	}
	

	@PostConstruct
	public void inicializar() {
		lstCategoria = ejb.listarCategorias();		
	}
	
	
	
	
	public String EliminarCategoria() {
		
		Map<String,String> mapParam  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		int idParam = Integer.parseInt( mapParam.get("idCategoria"));
				  
		return beanEliminarCategoria.eliminarCategoria(idParam);
	}
	
	
	public List<DTOConsultaCategoria> getLstCategoria() {
		return lstCategoria;
	}

	public void setLstCategoria(List<DTOConsultaCategoria> lstCategoria) {
		this.lstCategoria = lstCategoria;
	}
	
	
	
	public String RedirecionarEditarCategoria() {
		
		Map<String,String> mapParam  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		
		int idParam = Integer.parseInt( mapParam.get("idCategoria"));
		return beanEditarCategoria.obtenerCategoria(idParam);
	}
}
