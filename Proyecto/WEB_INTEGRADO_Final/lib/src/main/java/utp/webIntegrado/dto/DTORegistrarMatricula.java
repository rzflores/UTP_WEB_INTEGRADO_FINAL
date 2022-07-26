package utp.webIntegrado.dto;

import java.io.Serializable;

public class DTORegistrarMatricula implements Serializable {
	private Integer idCurso ;
	private Integer idUsuario ;
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}
