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

import utp.webIntegrado.dto.DTOConsultaParticipante;
import utp.webIntegrado.dto.DTOParticipanteEvaluar;
import utp.webIntegrado.proc.gestionCursos.dto.DTOConsultaCurso;
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
		boolean result = false;

		List<DTOParticipanteEvaluar> lst = new ArrayList<DTOParticipanteEvaluar>();
		switch(vistaNombre) {
				
				case "grabar":
					String idParticipanteMatricula = request.getParameter("idParticipanteMatricula");
					String nota = request.getParameter("nota");
//					
					lst = (List<DTOParticipanteEvaluar>) request.getSession().getAttribute("lstParticipantesEvaluar");
				
					System.out.println(nota);
					System.out.println(idParticipanteMatricula);
					result = ejb.registrarNota( Integer.parseInt(idParticipanteMatricula), Integer.parseInt(nota));
					lst = ejb.obtenerParticipanteEvaluar("");
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
