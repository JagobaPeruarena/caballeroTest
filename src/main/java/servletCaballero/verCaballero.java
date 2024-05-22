package servletCaballero;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conector.Conector;
import modelo.bean.Caballero;
import modelo.dao.ModeloCaballero;

/**
 * Servlet implementation class verCaballero
 */
@WebServlet("/verCaballero")
public class verCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ModeloCaballero mdCaballero = new ModeloCaballero();
		mdCaballero.setConector(new Conector());		
		
		int caballero_id = Integer.parseInt( request.getParameter("caballeroId"));
		
		Caballero caballero = mdCaballero.select(caballero_id);
		
		request.setAttribute("caballero", caballero);
		
		request.getRequestDispatcher("verCaballero.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
