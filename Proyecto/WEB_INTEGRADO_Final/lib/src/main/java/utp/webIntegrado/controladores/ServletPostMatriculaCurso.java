package utp.webIntegrado.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.webIntegrado.dto.DTOParticipanteMatricula;
import utp.webIntegrado.proc.gestionCursos.dto.DTOConsultaCurso;

/**
 * Servlet implementation class ServletPostMatriculaCurso
 */
@WebServlet("/ServletPostMatriculaCurso")
public class ServletPostMatriculaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPostMatriculaCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		List<DTOConsultaCurso> lstCursoOfertados = (List<DTOConsultaCurso>) request.getSession().getAttribute("lstMatriculasCursos");
		List<DTOConsultaCurso> lstCursoMatricula = (List<DTOConsultaCurso>) request.getSession().getAttribute("lstMatricula");
		if(lstCursoMatricula == null) {
			lstCursoMatricula = new ArrayList<DTOConsultaCurso>();
		}
		
		
		
		//////Agrtegar objeto
		DTOConsultaCurso cursoAMatricular=new DTOConsultaCurso();
		for(DTOConsultaCurso  c : lstCursoOfertados) {
			if(c.getIdCurso() == idCurso) {
				cursoAMatricular = c;				
			}
		}
		
		lstCursoMatricula.add(cursoAMatricular);
		
		
		
		int indiceObjetoELiminar = 0 ;
		for(int i= 0 ; i< lstCursoOfertados.size() ; i++ ) 
		{			
			if(lstCursoOfertados.get(i).getIdCurso() == idCurso) {
				indiceObjetoELiminar = i;
			}		
		}
		
		lstCursoOfertados.remove(indiceObjetoELiminar);
				
		
		
	
		
		request.getSession().setAttribute("lstMatriculasCursos", lstCursoOfertados);
		request.getSession().setAttribute("lstMatricula", lstCursoMatricula);		
		request.getRequestDispatcher("jsp/pageMatriculaCurso.jsp").forward(request, response);
	}
	

}

