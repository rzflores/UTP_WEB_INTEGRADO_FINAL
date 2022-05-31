package utp.webIntegrado.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usu = request.getParameter("usuario");
		String pwd = request.getParameter("password");		
		//request.setAttribute("message", usu);
		//request.getRequestDispatcher("vistas/layout/pageLayout.jsp").forward(request, response);
		if(usu.equals("jose")) 
		{
			request.getRequestDispatcher("/vistas/layout/pageLayout.jsp").forward(request, response);
		}
		else 
		{
			request.getRequestDispatcher("/vistas/login/login.jsp").forward(request, response);	
		}
		
		
	}

}
