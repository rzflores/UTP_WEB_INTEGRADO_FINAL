package utp.webIntegrado.proc.registrarNotas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.registrarNotas.dto.DTOParticipanteEvaluar;

@Named
@SessionScoped
public class BeanObtenerParticipanteEvaluar implements Serializable {

	private  List<DTOParticipanteEvaluar> lstParticipanteEvaluar;
	
	private DTOConsultaParticipanteEvaluar dtoConsultaParticipanteEvaluar ;
	
	

	public DTOConsultaParticipanteEvaluar getDtoConsultaParticipanteEvaluar() {
		return dtoConsultaParticipanteEvaluar;
	}


	public void setDtoConsultaParticipanteEvaluar(DTOConsultaParticipanteEvaluar dtoConsultaParticipanteEvaluar) {
		this.dtoConsultaParticipanteEvaluar = dtoConsultaParticipanteEvaluar;
	}

	@EJB
	private EJBRegistrarNotas ejb;
	
	@Inject
	private BeanRegistrarNotas beanRegistrarNotas;
	
	@PostConstruct
	public void inicializar() {
		dtoConsultaParticipanteEvaluar  = new DTOConsultaParticipanteEvaluar();
		dtoConsultaParticipanteEvaluar.setCadena("");
		lstParticipanteEvaluar = ejb.obtenerParticipanteEvaluar(dtoConsultaParticipanteEvaluar);	
	
	}


	public void ListarParticipantesEvaluarCadena() {
		lstParticipanteEvaluar = ejb.obtenerParticipanteEvaluar(dtoConsultaParticipanteEvaluar);	
	}
	
	public List<DTOParticipanteEvaluar> getLstParticipanteEvaluar() {
		return lstParticipanteEvaluar;
	}


	public void setLstParticipanteEvaluar(List<DTOParticipanteEvaluar> lstParticipanteEvaluar) {
		this.lstParticipanteEvaluar = lstParticipanteEvaluar;
	}
	
	public String RedirecionarEvaluarParticipante() {
		
		Map<String,String> mapParam  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		
		int idParam = Integer.parseInt( mapParam.get("idMatriculaParticipante"));
		
		return beanRegistrarNotas.ObtenerParticipante(idParam);
	}
	
	
}
