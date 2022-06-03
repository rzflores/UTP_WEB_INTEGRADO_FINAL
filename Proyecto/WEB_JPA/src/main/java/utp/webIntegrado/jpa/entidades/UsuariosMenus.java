package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios_menus database table.
 * 
 */
@Entity
@Table(name="usuarios_menus")
@NamedQuery(name="UsuariosMenus.obtenerMenusUsuario", query="SELECT m FROM UsuariosMenus m JOIN m.menus e JOIN m.usuario u  WHERE u.id = :idUsuario")
public class UsuariosMenus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuarios_menus")
	private Integer idUsuariosMenus;

	@Column(name="es_permitido")
	private Boolean esPermitido;

	//bi-directional many-to-one association to Menus
	@ManyToOne
	@JoinColumn(name="menusid")
	private Menus menus;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuariosid")
	private Usuario usuario;

	public UsuariosMenus() {
	}

	public Integer getIdUsuariosMenus() {
		return this.idUsuariosMenus;
	}

	public void setIdUsuariosMenus(Integer idUsuariosMenus) {
		this.idUsuariosMenus = idUsuariosMenus;
	}

	public Boolean getEsPermitido() {
		return this.esPermitido;
	}

	public void setEsPermitido(Boolean esPermitido) {
		this.esPermitido = esPermitido;
	}

	public Menus getMenus() {
		return this.menus;
	}

	public void setMenus(Menus menus) {
		this.menus = menus;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}