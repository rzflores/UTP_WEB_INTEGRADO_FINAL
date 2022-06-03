package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menus database table.
 * 
 */
@Entity
@NamedQuery(name="Menus.findAll", query="SELECT m FROM Menus m")
public class Menus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to UsuariosMenus
	@OneToMany(mappedBy="menus")
	private List<UsuariosMenus> usuariosMenuses;

	public Menus() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuariosMenus> getUsuariosMenuses() {
		return this.usuariosMenuses;
	}

	public void setUsuariosMenuses(List<UsuariosMenus> usuariosMenuses) {
		this.usuariosMenuses = usuariosMenuses;
	}

	public UsuariosMenus addUsuariosMenus(UsuariosMenus usuariosMenus) {
		getUsuariosMenuses().add(usuariosMenus);
		usuariosMenus.setMenus(this);

		return usuariosMenus;
	}

	public UsuariosMenus removeUsuariosMenus(UsuariosMenus usuariosMenus) {
		getUsuariosMenuses().remove(usuariosMenus);
		usuariosMenus.setMenus(null);

		return usuariosMenus;
	}

}