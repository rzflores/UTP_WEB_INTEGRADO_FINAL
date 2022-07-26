package utp.webIntegrado.proc.gestionTemarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.gestionTemarios.dto.DTOConsultaTemario;

@Named
@SessionScoped
public class BeanTemarios implements Serializable {


	private List<DTOConsultaTemario> lstTemario;
	
	private DTOConsultaTemario objTemario;
	
	@EJB
	private EJBTemarioCrud ejb;

	@Inject
	private BeanEditarTemario beanEditarTemario;
	
	@Inject 
	private BeanEliminarTemario beanEliminarTemario;
	
	public BeanTemarios() {
		
	}
	

	@PostConstruct
	public void inicializar() {
		lstTemario = ejb.listarTemarios();		
	}
	
	
	
	
	public String EliminarTemario() {
		
		Map<String,String> mapParam  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		   int idParam = Integer.parseInt( mapParam.get("idTemario"));
		  
		return beanEliminarTemario.eliminarTemario(idParam);
	}
	
	
	public List<DTOConsultaTemario> getLstTemario() {
		return lstTemario;
	}

	public void setLstTemario(List<DTOConsultaTemario> lstTemario) {
		this.lstTemario = lstTemario;
	}
	
	
	
	public String RedirecionarEditarTemario() {
		
		Map<String,String> mapParam  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		
		int idParam = Integer.parseInt( mapParam.get("idTemario"));
		return beanEditarTemario.obtenerTemario(idParam);
	}
	
}
