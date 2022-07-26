package utp.webIntegrado.proc.gestionCursos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import utp.webIntegrado.dto.DTOSelectItem;
import utp.webIntegrado.proc.gestionCategoria.EJBCategoriaCrud;
import utp.webIntegrado.proc.gestionCategoria.dto.DTOConsultaCategoria;
import utp.webIntegrado.proc.gestionCursos.dto.DTOAgregarCurso;
import utp.webIntegrado.proc.gestionTemarios.EJBTemarioCrud;
import utp.webIntegrado.proc.gestionTemarios.dto.DTOConsultaTemario;

@Named
@SessionScoped
public class BeanAgregarCurso implements Serializable{

	
	public List<SelectItem> getLstCategorias() {
		return lstCategorias;
	}

	public void setLstCategorias(List<SelectItem> lstCategorias) {
		this.lstCategorias = lstCategorias;
	}

	public List<SelectItem> getLstTemarios() {
		return lstTemarios;
	}

	public void setLstTemarios(List<SelectItem> lstTemarios) {
		this.lstTemarios = lstTemarios;
	}



	private DTOAgregarCurso  dtoAgregarCurso;
	private List<DTOSelectItem> dtoConsultaCategoria;
	private List<DTOSelectItem> dtoConsultaTemario;
	private List<SelectItem>  lstCategorias;
	private List<SelectItem>  lstTemarios;
	
	@EJB
	private EJBGestionCursos ejb;
	
	
	public DTOAgregarCurso getDtoAgregarCurso() {
		return dtoAgregarCurso;
	}

	public void setDtoAgregarCurso(DTOAgregarCurso dtoAgregarCurso) {
		this.dtoAgregarCurso = dtoAgregarCurso;
	}


	
	@Inject
	private BeanCursos beanCursos;
	
	
	public BeanAgregarCurso() {
		dtoAgregarCurso = new DTOAgregarCurso();
	}
	
	@PostConstruct
	public void  Inicializar() {
		
		dtoConsultaCategoria = ejb.lstCategoria();
		lstCategorias = new  ArrayList<SelectItem>();
		
		for(DTOSelectItem c : dtoConsultaCategoria) {
			SelectItem sc = new SelectItem();
			sc.setLabel(c.getValor());
			sc.setValue(c.getId());
			lstCategorias.add(sc);
		}
		
		
		
		dtoConsultaTemario = ejb.lstTemario();
		lstTemarios = new  ArrayList<SelectItem>();
		
		for(DTOSelectItem t : dtoConsultaTemario) {
			SelectItem sc = new SelectItem();
			sc.setLabel(t.getValor());
			sc.setValue(t.getId());
			lstTemarios.add(sc);
		}
		
		
	}
	
	
	public String agregarCurso() {

		ejb.insertarCurso(dtoAgregarCurso);
		beanCursos.inicializar();
		return "pageCurso";
		
	}
}
