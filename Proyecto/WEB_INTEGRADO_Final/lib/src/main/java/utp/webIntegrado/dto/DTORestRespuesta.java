package utp.webIntegrado.dto;

import java.io.Serializable;

public class DTORestRespuesta implements Serializable {
	
	private Integer codigo ;
	private String mensaje;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	} 

}
