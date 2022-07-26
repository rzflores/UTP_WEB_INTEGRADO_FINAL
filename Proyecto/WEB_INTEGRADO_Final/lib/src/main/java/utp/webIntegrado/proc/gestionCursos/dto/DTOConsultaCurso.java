package utp.webIntegrado.proc.gestionCursos.dto;

import java.io.Serializable;



public class DTOConsultaCurso  implements Serializable{
	
	
	private int idCurso;
	private String nombreCurso;
	private double precioCurso;
	private String descripcion;
	private String nombreCategoria;
	private String urlTemario;
	
	public  DTOConsultaCurso() {
		
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
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
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public DTOConsultaCurso(int idCurso, String nombreCurso, double precioCurso, String descripcion,
			String nombreCategoria, String urlTemario) {
		this.idCurso = idCurso;
		this.nombreCurso = nombreCurso;
		this.precioCurso = precioCurso;
		this.descripcion = descripcion;
		this.nombreCategoria = nombreCategoria;
		this.urlTemario = urlTemario;
	}
	public String getUrlTemario() {
		return urlTemario;
	}
	public void setUrlTemario(String urlTemario) {
		this.urlTemario = urlTemario;
	} 
	
	
	
	
	
}
