package servletLucha;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conector.Conector;
import modelo.bean.Caballero;
import modelo.dao.ModeloCaballero;

/**
 * Servlet implementation class luchaPanel2
 */
@WebServlet("/luchaPanel2")
public class luchaPanel2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public luchaPanel2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int caballeroPrime = Integer.parseInt(request.getParameter("caballeroPrime"));
		ModeloCaballero mdC = new ModeloCaballero();
		mdC.setConector(new Conector());
		ArrayList<Caballero> caballeros = mdC.getCaballeros();
	
		
		
		request.setAttribute("caballeros", caballeros);
		request.setAttribute("caballeroPrime", caballeroPrime);
		request.getRequestDispatcher("luchaPanel2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
