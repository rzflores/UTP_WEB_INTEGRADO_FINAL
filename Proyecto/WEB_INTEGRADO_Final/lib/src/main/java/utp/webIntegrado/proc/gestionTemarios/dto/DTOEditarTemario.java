package utp.webIntegrado.proc.gestionTemarios.dto;

import java.io.Serializable;

public class DTOEditarTemario extends DTOAgregarTemario implements Serializable {
	private int idTemario;
	public int getIdTemario() {
		return idTemario;
	}
	public void setIdTemario(int idTemario) {
		this.idTemario = idTemario;
	}
	public DTOEditarTemario() {		
	}
	
	
}
