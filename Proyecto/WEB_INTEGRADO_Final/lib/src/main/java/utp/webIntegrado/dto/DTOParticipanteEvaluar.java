package utp.webIntegrado.dto;

public class DTOParticipanteEvaluar {
	private int idMatriculaParticipante;
	public int getIdMatriculaParticipante() {
		return idMatriculaParticipante;
	}
	public void setIdMatriculaParticipante(int idMatriculaParticipante) {
		this.idMatriculaParticipante = idMatriculaParticipante;
	}
	private int idParticipante;
	private boolean esHabilitado;
	public boolean getEsHabilitado() {
		return esHabilitado;
	}
	public void setEsHabilitado(boolean esHabilitado) {
		this.esHabilitado = esHabilitado;
	}
	public int getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}
	private String participante;
	private String cursoNombre;
	private double nota;
	public String getParticipante() {
		return participante;
	}
	public void setParticipante(String participante) {
		this.participante = participante;
	}
	public String getCursoNombre() {
		return cursoNombre;
	}
	public void setCursoNombre(String cursoNombre) {
		this.cursoNombre = cursoNombre;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
}
