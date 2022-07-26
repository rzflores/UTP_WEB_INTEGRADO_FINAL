package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the matricula database table.
 * 
 */
@Entity
 @NamedQueries({
	 @NamedQuery(name="Matricula.obtenerParcipantesEvaluar", query="SELECT m FROM Matricula m JOIN m.usuario u JOIN m.curso c WHERE u.primerNombre LIKE :cadena"),
	 @NamedQuery(name="Matricula.obtenerParcipantesEvaluarPorId", query="SELECT m FROM Matricula m JOIN m.usuario u JOIN m.curso c WHERE m.id = :idParticipanteMatricula"),
	 @NamedQuery(name="Matricula.obtenerListaParcipantesEvaluar", query="SELECT m FROM Matricula m JOIN m.usuario u JOIN m.curso c"),
 })

public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double nota;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Matricula() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}