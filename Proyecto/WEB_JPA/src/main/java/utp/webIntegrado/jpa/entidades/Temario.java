package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the temario database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Temario.listarTemarios", query="SELECT t FROM Temario t"),
	@NamedQuery(name="Temario.findAll", query="SELECT t FROM Temario t where t.id=:cadena"),
	@NamedQuery(name="Temario.eliminarTemario", query="Delete FROM Temario t where t.id=:idTemario"),
	@NamedQuery(name="Temario.obtenerTemarioPorId", query="SELECT t FROM Temario t  where t.id=:idTemario"),
})


public class Temario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_subida")
	private Date fechaSubida;

	@Column(name="nombre_archivo")
	private String nombreArchivo;

	private String url;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="temario")
	private List<Curso> cursos;

	public Temario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaSubida() {
		return this.fechaSubida;
	}

	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setTemario(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setTemario(null);

		return curso;
	}

}