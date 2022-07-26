package utp.webIntegrado.proc.registrarMatricula.dto;

import java.io.Serializable;

public class DTOMensajeMatricula implements Serializable {
	
	private String tipoMensaje;
	private String visibleMensaje;
	private String textoMensaje;
	public String getTipoMensaje() {
		return tipoMensaje;
	}
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	public String getVisibleMensaje() {
		return visibleMensaje;
	}
	public void setVisibleMensaje(String visibleMensaje) {
		this.visibleMensaje = visibleMensaje;
	}
	public String getTextoMensaje() {
		return textoMensaje;
	}
	public void setTextoMensaje(String textoMensaje) {
		this.textoMensaje = textoMensaje;
	}

}
