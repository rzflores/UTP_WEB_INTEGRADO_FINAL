package utp.webIntegrado.dto;

import java.io.Serializable;

public class DTOConsultaTemario implements Serializable{
	private int idTemario;
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
	public void setUrlTemario(String urlTemario) {
		this.urlTemario = urlTemario;
	}
}
