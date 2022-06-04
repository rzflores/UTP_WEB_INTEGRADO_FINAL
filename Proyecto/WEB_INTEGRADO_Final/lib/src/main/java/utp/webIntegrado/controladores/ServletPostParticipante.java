package utp.webIntegrado.controladores;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import utp.webIntegrado.dto.DTOConsultaParticipante;
import utp.webIntegrado.proc.registrarMatricula.*;

/**
 * Servlet implementation class ServletPostEstudiante
 */
@WebServlet("/ServletPostParticipante")
public class ServletPostParticipante extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	private EJBMatriculaEstudiante ejb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPostParticipante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cadena = request.getParameter("cadena");
		List<DTOConsultaParticipante> lst = ejb.consultarEstudiantes(cadena);
		request.getSession().setAttribute("lstMatriculasEstudiantes", lst);
		request.getRequestDispatcher("jsp/pageMatriculasParticipante.jsp").forward(request, response);
	}

	
	

}
