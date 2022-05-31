package utp.webIntegrado.entidades;

import utp.webIntegrado.entidades.Categoria;
import utp.webIntegrado.entidades.Temario;

public class Curso {
	private int idCurso;
	private String nombre;
	private double precio;
	private String descripcion;
	private Categoria categoria;
	private Temario temario;
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Temario getTemario() {
		return temario;
	}
	public void setTemario(Temario temario) {
		this.temario = temario;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
