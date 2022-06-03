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
import utp.webIntegrado.proc.Consulta.EJBConsultaCursoNombre;
import utp.webIntegrao.ejb.EJBCursoCrud;

/**
 * Servlet implementation class ServletCursoController
 */
@WebServlet("/ServletCursoController")
public class ServletCursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	/*Inyeccion de ejb*/
	@EJB
	private EJBConsultaCursoNombre ejb;
	@EJB
	private EJBCursoCrud ejbCursoCrud;
	
	
    public ServletCursoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vistaNombre = request.getParameter("vista");
		String idCurso = request.getParameter("idCurso");
		boolean result = false;
		
		switch(vistaNombre ) {
				case "agregarCurso":
					request.getRequestDispatcher("jsp/agregarCurso.jsp").forward(request, response);
				case "editarCurso":
					request.getRequestDispatcher("jsp/editarCurso.jsp").forward(request, response);	
				case "eliminarCurso":
					String cadena = "";									
					result = ejbCursoCrud.eliminarCurso(Integer.parseInt(idCurso));
					List<DTOConsultaCurso> lstConsultaCurso =ejb.consultarCurso(cadena);									
					request.getSession().setAttribute("listaCurso", lstConsultaCurso);
					request.getRequestDispatcher("jsp/pageCurso.jsp").forward(request, response);	
		}
		
		
	}

}
