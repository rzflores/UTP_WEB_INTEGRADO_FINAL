package utp.webIntegrado.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.webIntegrado.dto.DTOConsultaCurso;
import utp.webIntegrado.dto.DTOConsultaParticipante;
import utp.webIntegrado.dto.DTOParticipanteEvaluar;
import utp.webIntegrado.proc.registrarMatricula.EJBMatriculaEstudiante;
import utp.webIntegrado.proc.registrarNotas.EJBRegistrarNotas;

/**
 * Servlet implementation class ServletPostParticipanteEvaluar
 */
@WebServlet("/ServletPostParticipanteEvaluar")
public class ServletPostParticipanteEvaluar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	private EJBRegistrarNotas ejb;
	
    public ServletPostParticipanteEvaluar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vistaNombre = request.getParameter("vista");
		String idParticipante = request.getParameter("idParticipante");

		List<DTOParticipanteEvaluar> lst = new ArrayList<DTOParticipanteEvaluar>();
		switch(vistaNombre) {
				
				case "cambio":
					request.getRequestDispatcher("jsp/pageEvaluar.jsp").forward(request, response);	
					lst = (List<DTOParticipanteEvaluar>) request.getSession().getAttribute("lstParticipantesEvaluar");
					
					for(DTOParticipanteEvaluar pe : lst) {
						if(pe.getIdParticipante() == Integer.parseInt( idParticipante)) {
							pe.setEsHabilitado(true);
						}
					}
					
					
					request.getSession().setAttribute("lstParticipantesEvaluar", lst);
					request.getRequestDispatcher("jsp/pageEvaluar.jsp").forward(request, response);	
			    default:
			    	String cadena = request.getParameter("cadena");
					lst = ejb.obtenerParticipanteEvaluar(cadena);
					request.getSession().setAttribute("lstParticipantesEvaluar", lst);
					request.getRequestDispatcher("jsp/pageEvaluar.jsp").forward(request, response);
		}
		
	}
}
