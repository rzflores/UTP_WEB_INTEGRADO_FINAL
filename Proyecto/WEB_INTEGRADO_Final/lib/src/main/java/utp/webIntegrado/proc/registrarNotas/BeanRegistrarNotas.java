package utp.webIntegrado.proc.registrarNotas;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.proc.registrarNotas.dto.DTOParticipanteEvaluar;

@Named
@SessionScoped
public class BeanRegistrarNotas implements Serializable{

	private DTOParticipanteEvaluar  dtoParticipanteEvaluar;
	
	@EJB
	private EJBRegistrarNotas ejb;
	
	@Inject 
	private BeanObtenerParticipanteEvaluar beanObtenerParticipanteEvaluar;
	
	public DTOParticipanteEvaluar getDtoParticipanteEvaluar() {
		return dtoParticipanteEvaluar;
	}


	public void setDtoParticipanteEvaluar(DTOParticipanteEvaluar dtoParticipanteEvaluar) {
		this.dtoParticipanteEvaluar = dtoParticipanteEvaluar;
	}


	public BeanRegistrarNotas() {
		dtoParticipanteEvaluar = new DTOParticipanteEvaluar();
	}
	
	
	public String registrarNota() {
		
		
		boolean result = ejb.registrarNota(dtoParticipanteEvaluar);
		
		beanObtenerParticipanteEvaluar.inicializar();
		
		return "pageEvaluar";
	}
	
	
	public String ObtenerParticipante(int idParticipante) {
		
		dtoParticipanteEvaluar = ejb.obtenerParticipanteEvaluarPorId(idParticipante);
		
		return "pageEvaluarParticipante";
	}
}
