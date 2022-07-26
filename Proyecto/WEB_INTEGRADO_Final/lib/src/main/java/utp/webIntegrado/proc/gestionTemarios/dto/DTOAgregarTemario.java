package utp.webIntegrado.proc.gestionTemarios.dto;

import java.io.Serializable;

public class DTOAgregarTemario implements Serializable {

	private String nombreArchivo;
	private String urlTemario;
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public String getUrlTemario() {
		return urlTemario;
	}
	public void setUrlTemario(String urlTemario) {
		this.urlTemario = urlTemario;
	}
	
	
	
	
}
