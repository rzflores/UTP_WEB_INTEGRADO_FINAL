package utp.webIntegrado.dto;

import java.io.Serializable;



public class DTOConsultaParticipante  implements Serializable{
	
	
	private int idParticipante;
	private String nombreParticipante;
	private String apellidopaternoParticipante;
	private String apellidomaternoParticipante;
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
	public String getApellidopaternoParticipante() {
		return apellidopaternoParticipante;
	}
	public void setApellidopaternoParticipante(String apellidopaternoParticipante) {
		this.apellidopaternoParticipante = apellidopaternoParticipante;
	}
	public String getApellidomaternoParticipante() {
		return apellidomaternoParticipante;
	}
	public void setApellidomaternoParticipante(String apellidomaternoParticipante) {
		this.apellidomaternoParticipante = apellidomaternoParticipante;
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
