package utp.webIntegrado.proc.gestionCategoria.dto;

import java.io.Serializable;

public class DTOAgregarCategoria implements Serializable {
	

	private String descripcion;

	private String nombre;

	private String nombreCorto;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	
	

}
