package utp.webIntegrado.proc.gestionCategoria;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.gestionCategoria.dto.DTOEditarCategoria;

@Named
@SessionScoped
public class BeanEditarCategoria implements Serializable{

	
    private DTOEditarCategoria dtoEditarCategoria;
	
	
	@EJB
	private EJBCategoriaCrud ejb;
	
	
	@Inject
	private BeanCategorias  beanTemarios;
	
	public BeanEditarCategoria() {
		dtoEditarCategoria = new DTOEditarCategoria();
	}
	
	
	public DTOEditarCategoria getDtoEditarCategoria() {
		return dtoEditarCategoria;
	}


	public void setDtoEditarCategoria(DTOEditarCategoria dtoEditarCategoria) {
		this.dtoEditarCategoria = dtoEditarCategoria;
	}


	public String editarCategoria() {

		ejb.editarCategoria(dtoEditarCategoria);
		beanTemarios.inicializar();
		return "pageCategoria";
		
	}
	
	public String obtenerCategoria(int id) {
		
		dtoEditarCategoria =   ejb.obtenerCategoriaPorId(id);
		
		return "editarCategoria";
	}
	
	
}
