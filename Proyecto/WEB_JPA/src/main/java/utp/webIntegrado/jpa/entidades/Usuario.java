package utp.webIntegrado.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.loginUsuario", query="SELECT u FROM Usuario u JOIN u.role r WHERE u.correo=:correo AND u.contrasenia=:contrasenia")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String contrasenia;

	private String correo;

	private Integer edad;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	//bi-directional many-to-one association to Matricula
	@OneToMany(mappedBy="usuario")
	private List<Matricula> matriculas;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Role role;

	//bi-directional many-to-one association to UsuariosMenus
	@OneToMany(mappedBy="usuario")
	private List<UsuariosMenus> usuariosMenuses;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public List<Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Matricula addMatricula(Matricula matricula) {
		getMatriculas().add(matricula);
		matricula.setUsuario(this);

		return matricula;
	}

	public Matricula removeMatricula(Matricula matricula) {
		getMatriculas().remove(matricula);
		matricula.setUsuario(null);

		return matricula;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<UsuariosMenus> getUsuariosMenuses() {
		return this.usuariosMenuses;
	}

	public void setUsuariosMenuses(List<UsuariosMenus> usuariosMenuses) {
		this.usuariosMenuses = usuariosMenuses;
	}

	public UsuariosMenus addUsuariosMenus(UsuariosMenus usuariosMenus) {
		getUsuariosMenuses().add(usuariosMenus);
		usuariosMenus.setUsuario(this);

		return usuariosMenus;
	}

	public UsuariosMenus removeUsuariosMenus(UsuariosMenus usuariosMenus) {
		getUsuariosMenuses().remove(usuariosMenus);
		usuariosMenus.setUsuario(null);

		return usuariosMenus;
	}

}