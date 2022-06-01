package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c"),
		@NamedQuery(name="Curso.consultaCursoPorNombre", query="SELECT c.id , c.nombre , c.descripcion , c.precio , ca.nombre as categoria , te.url as url FROM Curso c INNER JOIN Categoria ca on ca.id = c.`idCategoria`  INNER JOIN Temario te on te.id = c.\"idTemario\" where c.nombre like :cadena"),
		@NamedQuery(name="Curso.obtenerCursos", query="SELECT c FROM Curso c")			
})

public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="seq_curso")
	@SequenceGenerator(name="seq_cursos",sequenceName="seq_cursos", allocationSize=1)
	private Integer id;

	private String descripcion;

	@Column(name="\"idCategoria\"")
	private Integer idCategoria;

	@Column(name="\"idTemario\"")
	private Integer idTemario;
	
	
	private Temario temario;
	
	private Categoria categoria;
	

	public Temario getTemario() {
		return temario;
	}

	public void setTemario(Temario temario) {
		this.temario = temario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String nombre;

	private double precio;

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

	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getIdTemario() {
		return this.idTemario;
	}

	public void setIdTemario(Integer idTemario) {
		this.idTemario = idTemario;
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

}