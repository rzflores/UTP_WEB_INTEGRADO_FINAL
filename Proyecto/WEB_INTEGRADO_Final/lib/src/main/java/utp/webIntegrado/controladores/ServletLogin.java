package utp.webIntegrado.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utp.webIntegrado.dto.DTOLoginUsuario;
import utp.webIntegrado.dto.DTOObtenerUsuarioMenu;
import utp.webIntegrado.entidades.Menu;
import utp.webIntegrado.proc.Consulta.EJBConsultaCursoNombre;
import utp.webIntegrado.proc.Login.EJBLoginUsuario;
import utp.webIntegrado.proc.gestionCursos.dto.DTOConsultaCurso;
import utp.webIntegrado.proc.obtenerMenus.EJBObtenerMenus;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	private EJBLoginUsuario ejb;
	@EJB
	private EJBObtenerMenus ejbObtenerMenus;
	
	
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("usuario");
		String pwd = request.getParameter("password");	
		
		List<DTOLoginUsuario> lstLoginUsuario =ejb.loginUsuario(email,pwd);
		
		
		
		if(lstLoginUsuario.isEmpty()) 
		{
			request.getRequestDispatcher("/vistas/login/login.jsp").forward(request, response);
			
		}
		else 
		{
			int idUsuario = lstLoginUsuario.get(0).getIdUsuario();
			DTOObtenerUsuarioMenu dtoUsuarioMenu = ejbObtenerMenus.obtenerUsuarioMenu(idUsuario);	
						
			request.getSession().setAttribute("DTOObtenerUsuarioMenu", dtoUsuarioMenu);
			request.getRequestDispatcher("/vistas/layout/pageLayout.jsp").forward(request, response);	
		}
		
		
	}

}
