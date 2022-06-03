package utp.webIntegrado.dto;

import java.io.Serializable;
import java.util.List;

import utp.webIntegrado.entidades.Menu;

public class DTOObtenerUsuarioMenu implements Serializable{
	
	
	private String nombreUsuario;
	private String nombreRol;
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	private List<Menu> lstMenu;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public List<Menu> getLstMenu() {
		return lstMenu;
	}
	public void setLstMenu(List<Menu> lstMenu) {
		this.lstMenu = lstMenu;
	}	
	
}
