package utp.webIntegrado.proc.Login.dto;

import java.io.Serializable;

public class DTOUsuarioLogin implements Serializable {
	
	private String correo;
	private String password;
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
