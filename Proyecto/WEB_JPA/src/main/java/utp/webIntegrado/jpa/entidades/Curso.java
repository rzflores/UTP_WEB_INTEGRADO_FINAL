package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c  FROM Curso c JOIN c.temario t JOIN c.categoria a WHERE c.nombre LIKE  :cadena")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descripcion;

	private String nombre;

	private double precio;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Temario
	@ManyToOne
	@JoinColumn(name="id_temario")
	private Temario temario;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="curso")
	private List<Horario> horarios;

	//bi-directional many-to-one association to Matricula
	@OneToMany(mappedBy="curso")
	private List<Matricula> matriculas;

	public Curso() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Temario getTemario() {
		return this.temario;
	}

	public void setTemario(Temario temario) {
		this.temario = temario;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setCurso(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setCurso(null);

		return horario;
	}

	public List<Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Matricula addMatricula(Matricula matricula) {
		getMatriculas().add(matricula);
		matricula.setCurso(this);

		return matricula;
	}

	public Matricula removeMatricula(Matricula matricula) {
		getMatriculas().remove(matricula);
		matricula.setCurso(null);

		return matricula;
	}

}