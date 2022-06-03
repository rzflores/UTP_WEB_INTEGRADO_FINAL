package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Curso.findAll", query="SELECT c  FROM Curso c JOIN c.temario t JOIN c.categoria a WHERE c.nombre LIKE  :cadena"),
	@NamedQuery(name="Curso.eliminarCurso" , query="DELETE FROM Curso c WHERE c.id=:idCurso")
})



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

}