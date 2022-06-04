package utp.webIntegrado.dto;

import java.io.Serializable;

public class DTOParticipanteMatricula  implements Serializable {
	
	private int idParticipante;
	private String nombreParticipante;
	private String correoParticipante;
	private String telefonoParticipante;
	public int getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}
	public String getNombreParticipante() {
		return nombreParticipante;
	}
	public void setNombreParticipante(String nombreParticipante) {
		this.nombreParticipante = nombreParticipante;
	}
	
	public String getCorreoParticipante() {
		return correoParticipante;
	}
	public void setCorreoParticipante(String correoParticipante) {
		this.correoParticipante = correoParticipante;
	}
	public String getTelefonoParticipante() {
		return telefonoParticipante;
	}
	public void setTelefonoParticipante(String telefonoParticipante) {
		this.telefonoParticipante = telefonoParticipante;
	}
	
	
	
	
	
	
}
