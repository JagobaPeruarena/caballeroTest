package servletLucha;

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
 * Servlet implementation class luchaPanelPelea
 */
@WebServlet("/luchaPanelPelea")
public class luchaPanelPelea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public luchaPanelPelea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int caballeroPrimeId = Integer.parseInt(request.getParameter("caballeroPrime"));
		int caballeroSecondId = Integer.parseInt(request.getParameter("caballeroSecond"));
		
		ModeloCaballero mdCaballero = new ModeloCaballero();
		mdCaballero.setConector(new Conector());
		
		Caballero caballeroPrime = mdCaballero.select(caballeroPrimeId);
		Caballero caballeroSecond = mdCaballero.select(caballeroSecondId);
		
		request.setAttribute("caballeroPrime", caballeroPrime);
		request.setAttribute("caballeroSecond", caballeroSecond);
		
		request.getRequestDispatcher("luchaPanelPelea.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
