package utp.webIntegrado.proc.registrarNotas.dto;

public class DTOParticipanteEvaluar {
	private int idMatriculaParticipante;
	private String participante;
	private String cursoNombre;
	private double nota;
	
	
	
	public int getIdMatriculaParticipante() {
		return idMatriculaParticipante;
	}
	public void setIdMatriculaParticipante(int idMatriculaParticipante) {
		this.idMatriculaParticipante = idMatriculaParticipante;
	}
	
	
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
