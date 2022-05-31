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
import utp.webIntegrado.proc.Compra.EJBCompraCurso;

/**
 * Servlet implementation class ServletPostCursos
 */
@WebServlet("/ServletPostCursos")
public class ServletPostCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	/*Inyeccion de ejb*/
	@EJB
	private EJBCompraCurso ejb;
	
	
    public ServletPostCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cadena = request.getParameter("cadena");	
		
		List<DTOConsultaCurso> lstConsultaCurso =ejb.consultarCurso(cadena);
		System.out.println(cadena);
		System.out.println(lstConsultaCurso);
		request.getSession().setAttribute("listaCurso", lstConsultaCurso);
		request.getRequestDispatcher("jsp/pageCurso.jsp").forward(request, response);		
	}

}
