package utp.webIntegrado.dto;

import java.io.Serializable;

public class DTOSelectItem  implements Serializable{

	private int id;
	private String  valor;
	
	public DTOSelectItem() {}
	
	
	
	public DTOSelectItem(int id, String valor) {
		super();
		this.id = id;
		this.valor = valor;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}
