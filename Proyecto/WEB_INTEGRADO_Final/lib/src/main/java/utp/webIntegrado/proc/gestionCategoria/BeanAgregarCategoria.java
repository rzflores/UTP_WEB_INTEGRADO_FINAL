package utp.webIntegrado.proc.gestionCategoria;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.gestionCategoria.dto.DTOAgregarCategoria;


@Named
@SessionScoped
public class BeanAgregarCategoria implements Serializable {
	
	private DTOAgregarCategoria dtoAgregarCategoria;
	
	
	
	@EJB
	private EJBCategoriaCrud ejb;
	
	@Inject
	private BeanCategorias beanCategorias;
	
	public BeanAgregarCategoria() {
		
		dtoAgregarCategoria = new DTOAgregarCategoria();
	}


	public DTOAgregarCategoria getDtoAgregarCategoria() {
		return dtoAgregarCategoria;
	}


	public void setDtoAgregarCategoria(DTOAgregarCategoria dtoAgregarCategoria) {
		this.dtoAgregarCategoria = dtoAgregarCategoria;
	}
	
	
	public String agregarCategoria() {

		ejb.insertarCategoria(dtoAgregarCategoria);
		beanCategorias.inicializar();
		return "pageCategoria";
		
	}
	
}
