package utp.webIntegrado.proc.gestionCategoria.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class DTOConsultaCategoria implements Serializable {

	private Integer idCategoria;
	
	private String descripcion;

	private String nombre;

	private String nombreCorto;

	
	public DTOConsultaCategoria() {}
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
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

	public DTOConsultaCategoria(Integer idCategoria, String descripcion, String nombre, String nombreCorto) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.nombreCorto = nombreCorto;
	}
	
	
	
}
