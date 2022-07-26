package utp.webIntegrado.proc.gestionTemarios;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.gestionTemarios.dto.DTOAgregarTemario;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOEditarTemario;

@Named
@SessionScoped
public class BeanEditarTemario implements Serializable{

	private DTOEditarTemario dtoEditarTemario;
	
	
	@EJB
	private EJBTemarioCrud ejb;
	
	
	@Inject
	private BeanTemarios  beanTemarios;
	
	
	public BeanEditarTemario() {
		dtoEditarTemario = new DTOEditarTemario();
	}

	public DTOEditarTemario getDtoEditarTemario() {
		return dtoEditarTemario;
	}

	public void setDtoEditarTemario(DTOEditarTemario dtoEditarTemario) {
		this.dtoEditarTemario = dtoEditarTemario;
	}
	
	public String editarTemario() {

		ejb.editarTemario(dtoEditarTemario);
		beanTemarios.inicializar();
		return "pageTemario";
		
	}
	
	public String obtenerTemario(int id) {
		
		dtoEditarTemario =   ejb.obtenerTemarioPorId(id);
		return "editarTemario";
	}
	
	
	
	
}
