package utp.webIntegrado.controladores;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import utp.webIntegrado.dto.DTOParticipanteMatricula;
import utp.webIntegrado.proc.registrarMatricula.*;

/**
 * Servlet implementation class ServletGetMatriculaEstudiante
 */
@WebServlet("/ServletGetMatriculaParticipante")
public class ServletGetMatriculaParticipante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	private EJBMatriculaEstudiante ejb;
    public ServletGetMatriculaParticipante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idParticipante = Integer.parseInt(request.getParameter("idParticipante"));
		DTOParticipanteMatricula dto = ejb.consultarParticipantePorId(idParticipante);
		request.getSession().setAttribute("dtoMatriculaParticipante", dto);
		request.getRequestDispatcher("jsp/pageMatriculaCurso.jsp").forward(request, response);}

}



