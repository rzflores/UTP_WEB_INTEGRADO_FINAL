package utp.webIntegrado.proc.Login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import utp.webIntegrado.dto.DTOLoginUsuario;
import utp.webIntegrado.dto.DTOObtenerUsuarioMenu;
import utp.webIntegrado.entidades.Menu;



@Named
@SessionScoped
public class BeanLoginUsuario implements Serializable{

	
	private DTOUsuarioLogin dtoUsuarioLogin;
	
	private DTOUsuarioLogeado dtoUsuarioLogeado;
	
	private DTOObtenerUsuarioMenu dtoUsuarioMenu ;
	
	@EJB
	private EJBLoginUsuario ejb;
	
	public BeanLoginUsuario() {
		dtoUsuarioLogin = new DTOUsuarioLogin();
		dtoUsuarioLogeado = new DTOUsuarioLogeado();
		dtoUsuarioMenu = new DTOObtenerUsuarioMenu();
	}
	
	public void inicializar() {
		dtoUsuarioLogeado = ejb.obtenerUsuarioLogeado(dtoUsuarioLogin);
		dtoUsuarioMenu = ejb.obtenerUsuarioMenu(dtoUsuarioLogeado);
	}
	
	
	
	
	public String RedirecionarLogin() {
		
		String pageResult = ejb.UsuarioLogin(dtoUsuarioLogin);
		if(pageResult.equals("pageLayout")) {
			System.out.println(pageResult);
			this.inicializar();
		}
		return pageResult;
					
	}

	public DTOUsuarioLogeado getDtoUsuarioLogeado() {
		return dtoUsuarioLogeado;
	}

	public void setDtoUsuarioLogeado(DTOUsuarioLogeado dtoUsuarioLogeado) {
		this.dtoUsuarioLogeado = dtoUsuarioLogeado;
	}

	public DTOObtenerUsuarioMenu getDtoUsuarioMenu() {
		return dtoUsuarioMenu;
	}

	public void setDtoUsuarioMenu(DTOObtenerUsuarioMenu dtoUsuarioMenu) {
		this.dtoUsuarioMenu = dtoUsuarioMenu;
	}

	public DTOUsuarioLogin getDtoUsuarioLogin() {
		return dtoUsuarioLogin;
	}

	public void setDtoUsuarioLogin(DTOUsuarioLogin dtoUsuarioLogin) {
		this.dtoUsuarioLogin = dtoUsuarioLogin;
	}
	
	
}
