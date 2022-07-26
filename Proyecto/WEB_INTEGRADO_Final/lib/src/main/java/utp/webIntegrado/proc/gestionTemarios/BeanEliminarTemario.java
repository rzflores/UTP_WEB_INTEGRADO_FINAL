package utp.webIntegrado.proc.gestionTemarios;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.dto.DTOIdParam;


@Named
@SessionScoped
public class BeanEliminarTemario implements Serializable {

	
	@EJB
	private EJBTemarioCrud ejb;
	
	@Inject
	private BeanTemarios  beanTemarios;
	
	public BeanEliminarTemario() {
		
	}
	
	public String eliminarTemario(int idTemario) {

		ejb.eliminarTemario(idTemario);
		beanTemarios.inicializar();
		return "pageTemario";
		
	}
}
