package utp.webIntegrado.entidades;

import java.sql.Date;

public class Temario {
	private int idTemario;
	private String url;
	private Date fechaSubida;
	private String nombreArchivo;
	
	
	

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Date getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	public int getIdTemario() {
		return idTemario;
	}

	public void setIdTemario(int idTemario) {
		this.idTemario = idTemario;
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
