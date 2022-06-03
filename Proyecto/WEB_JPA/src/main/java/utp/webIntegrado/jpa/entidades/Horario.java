package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the horarios database table.
 * 
 */
@Entity
@Table(name="horarios")
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer dia;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="hora_fin")
	private Integer horaFin;

	@Column(name="hora_inicio")
	private Integer horaInicio;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;

	public Horario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Integer getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Integer horaFin) {
		this.horaFin = horaFin;
	}

	public Integer getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}