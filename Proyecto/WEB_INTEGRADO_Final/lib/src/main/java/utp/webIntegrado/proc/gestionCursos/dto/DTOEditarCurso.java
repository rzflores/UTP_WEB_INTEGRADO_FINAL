package utp.webIntegrado.proc.gestionCursos.dto;

import java.io.Serializable;

public class DTOEditarCurso extends DTOAgregarCurso implements Serializable {
	private Integer idCurso;
	private String nombreCategoria;
	private String urlTemario;
	

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getUrlTemario() {
		return urlTemario;
	}

	public void setUrlTemario(String urlTemario) {
		this.urlTemario = urlTemario;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	
	
	
}	
