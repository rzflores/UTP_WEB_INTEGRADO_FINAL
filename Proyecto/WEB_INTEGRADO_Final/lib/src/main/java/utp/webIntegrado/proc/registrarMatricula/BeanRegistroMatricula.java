package utp.webIntegrado.proc.registrarMatricula;

import java.io.Serializable;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import utp.webIntegrado.dto.DTORegistrarMatricula;
import utp.webIntegrado.dto.DTORestRespuesta;
import utp.webIntegrado.proc.registrarMatricula.dto.DTOMensajeMatricula;

@Named
@SessionScoped
public class BeanRegistroMatricula implements Serializable{

	private DTORegistrarMatricula dtoRegistrarMatricula;
	
	private DTOMensajeMatricula dtoMensajeMatricula;
	
	public DTOMensajeMatricula getDtoMensajeMatricula() {
		return dtoMensajeMatricula;
	}

	public void setDtoMensajeMatricula(DTOMensajeMatricula dtoMensajeMatricula) {
		this.dtoMensajeMatricula = dtoMensajeMatricula;
	}



	
	
	@EJB
	private EJBMatriculaEstudiante ejb;
	
	
	public BeanRegistroMatricula (){
		
		
		dtoMensajeMatricula = new DTOMensajeMatricula();		
		dtoRegistrarMatricula = new DTORegistrarMatricula();
		
	}
	
	public void  RegistrarMatricula() {
		
		
		Map<String,String> mapParam  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		int idCurso = Integer.parseInt( mapParam.get("idCurso"));
		int idUsuario = Integer.parseInt( mapParam.get("idUsuario"));
		
		dtoRegistrarMatricula.setIdCurso(idCurso);
		dtoRegistrarMatricula.setIdUsuario(idUsuario);
		
		
		DTORestRespuesta res = ejb.registrarMatricula(dtoRegistrarMatricula);
		
		if(res.getCodigo() == 200) {
			dtoMensajeMatricula.setTextoMensaje("Se matriculo Correctamente");
			dtoMensajeMatricula.setTipoMensaje("success");
			dtoMensajeMatricula.setVisibleMensaje("display:none;");
		}else {
			dtoMensajeMatricula.setTextoMensaje("Ocurrio un error en la matricula");
			dtoMensajeMatricula.setTipoMensaje("warning");
			dtoMensajeMatricula.setVisibleMensaje("display:none;");
		}
		
		
					
	}
	
	
}
