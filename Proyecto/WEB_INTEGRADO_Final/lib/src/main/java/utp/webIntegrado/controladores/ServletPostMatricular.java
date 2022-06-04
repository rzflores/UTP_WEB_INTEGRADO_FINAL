package utp.webIntegrado.controladores;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.webIntegrado.dto.DTOConsultaCurso;
import utp.webIntegrado.dto.DTOParticipanteMatricula;
import utp.webIntegrado.proc.registrarMatricula.EJBMatriculaEstudiante;

/**
 * Servlet implementation class ServletPostMatricular
 */
@WebServlet("/ServletPostMatricular")
public class ServletPostMatricular extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EJBMatriculaEstudiante ejb;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPostMatricular() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DTOParticipanteMatricula dto = (DTOParticipanteMatricula) request.getSession().getAttribute("dtoMatriculaParticipante");
		List<DTOConsultaCurso> lst = (List<DTOConsultaCurso>) request.getSession().getAttribute("lstMatricula");
		ejb.matricular(dto, lst);
		request.getSession().setAttribute("lstMatricula", null);
		request.getSession().setAttribute("DTOEstudianteMatricula", null);
		request.getSession().setAttribute("lstMatriculasCursos", null);
		request.getSession().setAttribute("lstMatriculasEstudiantes", null);
		request.getRequestDispatcher("jsp/pageMatriculasParticipante.jsp").forward(request, response);
	}
	

}
