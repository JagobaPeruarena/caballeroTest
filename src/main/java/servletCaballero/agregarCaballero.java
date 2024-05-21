package servletCaballero;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conector.Conector;
import modelo.bean.Arma;
import modelo.bean.Escudo;
import modelo.dao.ModeloArma;
import modelo.dao.ModeloCaballero;
import modelo.dao.ModeloEscudo;

/**
 * Servlet implementation class agregarCaballero
 */
@WebServlet("/agregarCaballero")
public class agregarCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ModeloArma mdArma = new ModeloArma();
		ModeloEscudo mdEscudo = new ModeloEscudo();
		
		mdArma.setConector(new Conector());
		mdEscudo.setConector(new Conector());
		
		ArrayList<Escudo> escudos = mdEscudo.getEscudos();
		ArrayList<Arma> armas = mdArma.getArmas();
		
		request.setAttribute("armas", armas);
		request.setAttribute("escudos", escudos);
		
		request.getRequestDispatcher("agregarCaballero.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
