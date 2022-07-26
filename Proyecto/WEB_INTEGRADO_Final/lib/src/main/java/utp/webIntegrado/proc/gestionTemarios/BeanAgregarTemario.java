package utp.webIntegrado.proc.gestionTemarios;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.gestionTemarios.dto.DTOAgregarTemario;


@Named
@SessionScoped
public class BeanAgregarTemario implements Serializable {

	private DTOAgregarTemario dtoAgregarTemario;
	

	@EJB
	private EJBTemarioCrud ejb;
	
	@Inject
	private BeanTemarios  beanTemarios;
	
	public BeanAgregarTemario() {
		dtoAgregarTemario = new DTOAgregarTemario();
		
	}
	
	@PostConstruct
	public void inicializar() {
	}
	
	
	public DTOAgregarTemario getDtoAgregarTemario() {
		return dtoAgregarTemario;
	}
	
	public void setDtoAgregarTemario(DTOAgregarTemario dtoAgregarTemario) {
		this.dtoAgregarTemario = dtoAgregarTemario;
	}
	
	
	public String agregarTemario() {

		ejb.insertarTemario(dtoAgregarTemario);
		beanTemarios.inicializar();
		return "pageTemario";
		
	}
	
}
