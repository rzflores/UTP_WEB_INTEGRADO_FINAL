package utp.webIntegrado.proc.gestionCursos.dto;

import java.io.Serializable;

public class DTOAgregarCurso implements Serializable {
	private String nombreCurso;
	private double precioCurso;
	private String descripcion;
	private int idCategoria;
	private int idTemario;
	
	
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public double getPrecioCurso() {
		return precioCurso;
	}
	public void setPrecioCurso(double precioCurso) {
		this.precioCurso = precioCurso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getIdTemario() {
		return idTemario;
	}
	public void setIdTemario(int idTemario) {
		this.idTemario = idTemario;
	}
	
	
}
