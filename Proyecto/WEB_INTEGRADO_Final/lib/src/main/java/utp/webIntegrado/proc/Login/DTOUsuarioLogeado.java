package utp.webIntegrado.proc.Login;

import java.io.Serializable;

public class DTOUsuarioLogeado implements Serializable {

	private int idUsuario;
	private int idRol;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
}
