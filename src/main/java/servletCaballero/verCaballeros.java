package servletCaballero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
@WebServlet("/verCaballeros")
public class verCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloCaballero mdC = new ModeloCaballero();
		mdC.setConector(new Conector());
		ArrayList<Caballero> caballeros = mdC.getCaballeros();
		String busqueda = request.getParameter("busqueda");
		try {
			
		
		if (!busqueda.isBlank()) {
			ArrayList<Caballero> toRemove = new ArrayList<Caballero>();
			for (Caballero caballero : caballeros) {
				if (caballero.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
					System.out.println(caballero.getNombre());
				}else {
					toRemove.add(caballero);
				}
					
				
			}
			for (Caballero caballero : toRemove) {
				caballeros.remove(caballero);
			}
		}
		} catch (Exception e) {
			// TODO: handle exception
		}

		request.setAttribute("caballeros", caballeros);
		
		request.getRequestDispatcher("verCaballeros.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
