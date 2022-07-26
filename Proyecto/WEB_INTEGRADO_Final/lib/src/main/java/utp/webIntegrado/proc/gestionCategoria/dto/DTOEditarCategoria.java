package utp.webIntegrado.proc.gestionCategoria.dto;

import java.io.Serializable;


public class DTOEditarCategoria extends DTOAgregarCategoria  implements Serializable {
	private Integer idCategoria;

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}
