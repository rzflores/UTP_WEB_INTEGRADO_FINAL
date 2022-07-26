package utp.webIntegrado.proc.gestionTemarios.dto;

import java.io.Serializable;

public class DTOConsultaTemario implements Serializable{
	private int idTemario;
	private String nombreArchivo;
	private String urlTemario;
	public int getIdTemario() {
		return idTemario;
	}
	public void setIdTemario(int idTemario) {
		this.idTemario = idTemario;
	}
	public String getUrlTemario() {
		return urlTemario;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public void setUrlTemario(String urlTemario) {
		this.urlTemario = urlTemario;
	}
	public DTOConsultaTemario() {		
	}
	public DTOConsultaTemario(int idTemario, String nombreArchivo, String urlTemario) {
		super();
		this.idTemario = idTemario;
		this.nombreArchivo = nombreArchivo;
		this.urlTemario = urlTemario;
	}
	
	
}
