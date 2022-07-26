package utp.webIntegrado.proc.gestionCategoria;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class BeanEliminarCategoria implements Serializable {
	
	
	@EJB
	private EJBCategoriaCrud ejb;
	
	@Inject
	private BeanCategorias  beanCategorias;
	
	
	
	public BeanEliminarCategoria() {
		
	}
	
	public String eliminarCategoria(int idCategoria) {

		ejb.eliminarCategoria(idCategoria);
		beanCategorias.inicializar();
		return "pageCategoria";
		
	}
}
