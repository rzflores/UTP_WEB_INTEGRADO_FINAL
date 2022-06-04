package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;


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

	private String link;

	private String nombre;

	public Menus() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}