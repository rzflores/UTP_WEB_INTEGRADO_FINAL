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
import utp.webIntegrado.proc.gestionCursos.dto.DTOEditarCurso;

@Named
@SessionScoped
public class BeanEditarCurso implements Serializable{

	
	private DTOEditarCurso dtoEditarCurso;
	private List<DTOSelectItem> dtoConsultaCategoria;
	private List<DTOSelectItem> dtoConsultaTemario;
	private List<SelectItem>  lstCategorias;
	private List<SelectItem>  lstTemarios;
	
	
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


	public DTOEditarCurso getDtoEditarCurso() {
		return dtoEditarCurso;
	}


	public void setDtoEditarCurso(DTOEditarCurso dtoEditarCurso) {
		this.dtoEditarCurso = dtoEditarCurso;
	}

	@EJB
	private EJBGestionCursos ejb;
	
	@Inject
	private BeanCursos beanCursos;
	
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
	
	
	public String editarCurso() {

		ejb.editarCurso(dtoEditarCurso);
		beanCursos.inicializar();
		return "pageCurso";
		
	}
	
	public String obtenerCurso(int id) {
		
		dtoEditarCurso =   ejb.obtenerCursoPorId(id);
		
		return "editarCurso";
	}
	
}
