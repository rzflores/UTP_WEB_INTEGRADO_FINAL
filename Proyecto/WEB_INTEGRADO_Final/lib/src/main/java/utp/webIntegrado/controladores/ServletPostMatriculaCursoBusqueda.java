package utp.webIntegrado.controladores;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utp.webIntegrado.proc.registrarMatricula.EJBMatriculaEstudiante;
import utp.webIntegrado.dto.*;
/**
 * Servlet implementation class ServletPostMatriculaCursoBusqueda
 */
@WebServlet("/ServletPostMatriculaCursoBusqueda")
public class ServletPostMatriculaCursoBusqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private EJBMatriculaEstudiante ejb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPostMatriculaCursoBusqueda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cadena = request.getParameter("cadena");
		List<DTOConsultaCurso> lst = ejb.consultaCursoPorNombre(cadena);
		request.getSession().setAttribute("lstMatriculasCursos", lst);
		request.getRequestDispatcher("jsp/pageMatriculaCurso.jsp").forward(request, response);
	}

}
