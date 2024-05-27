package servletCaballero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conector.Conector;
import modelo.bean.Caballero;
import modelo.dao.ModeloCaballero;

/**
 * Servlet implementation class ordenarCaballeros
 */
@WebServlet("/ordenarCaballeros")
public class ordenarCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ordenarCaballeros() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloCaballero mdC = new ModeloCaballero();
		mdC.setConector(new Conector());
		ArrayList<Caballero> caballeros = mdC.getCaballeros();
		
		caballeros.sort(new Comparador());
		
		request.setAttribute("caballeros", caballeros);

		request.getRequestDispatcher("verCaballeros.jsp").forward(request, response);
	}

}
