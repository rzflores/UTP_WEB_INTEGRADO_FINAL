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
import utp.webIntegrado.dto.DTOConsultaTemario;
import utp.webIntegrado.ejb.EJBCursoCrud;
import utp.webIntegrado.ejb.EJBTemarioCrud;
import utp.webIntegrado.proc.Consulta.EJBConsultaCursoNombre;
import utp.webIntegrado.proc.Consulta.EJBConsultaTemarioNombre;

/**
 * Servlet implementation class ServletTemarioController
 */
@WebServlet("/ServletTemarioController")
public class ServletTemarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	private EJBConsultaTemarioNombre ejb;
	@EJB
	private EJBTemarioCrud ejbTemarioCrud;
    public ServletTemarioController() {
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
		// TODO Auto-generated method stub
		String vistaNombre = request.getParameter("vista");
		String idTemario = request.getParameter("idTemario");
		boolean result = false;
		
		switch(vistaNombre ) {
				case "agregarTemario":
					request.getRequestDispatcher("jsp/agregarTemario.jsp").forward(request, response);
				case "editarTemario":
					request.getRequestDispatcher("jsp/editarTemario.jsp").forward(request, response);	
				case "eliminarTemario":
					String cadena = "";									
					result = ejbTemarioCrud.eliminarTemario(Integer.parseInt(idTemario));
					List<DTOConsultaTemario> lstConsultaCurso =ejb.consultarCurso(cadena);									
					request.getSession().setAttribute("listaTemario", lstConsultaCurso);
					request.getRequestDispatcher("jsp/pageTemario.jsp").forward(request, response);	
		}
	}

}
