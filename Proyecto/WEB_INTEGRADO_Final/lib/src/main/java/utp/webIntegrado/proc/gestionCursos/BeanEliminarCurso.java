package utp.webIntegrado.proc.gestionCursos;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.gestionTemarios.BeanTemarios;
import utp.webIntegrado.proc.gestionTemarios.EJBTemarioCrud;

@Named
@SessionScoped
public class BeanEliminarCurso implements Serializable {

	@EJB
	private EJBGestionCursos ejb;
	
	@Inject
	private BeanCursos  beanCursos;
	
	public BeanEliminarCurso() {
		
	}
	
	public String eliminarCurso(int idTemario) {

		ejb.eliminarCurso(idTemario);
		beanCursos.inicializar();
		return "pageCurso";
		
	}
	
	
}
