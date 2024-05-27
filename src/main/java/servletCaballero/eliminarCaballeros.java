package servletCaballero;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conector.Conector;
import modelo.dao.ModeloCaballero;

/**
 * Servlet implementation class eliminarCaballeros
 */
@WebServlet("/eliminarCaballeros")
public class eliminarCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminarCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloCaballero modeloCaballero = new ModeloCaballero();
		modeloCaballero.setConector(new Conector());
		String eliminar = request.getParameter("eliminar");
		String[] eliminados = eliminar.split(",");
		boolean door = true;
		ArrayList<Integer> paraEliminar = new ArrayList<Integer>();
		for (int i = 0; i < (eliminados.length) && door; i++) {
			int valor = Integer.parseInt(eliminados[i]);
			if (modeloCaballero.select(valor)!=null) {
				paraEliminar.add(valor);
			}else {
				door=false;
			}
		}
		if (door) {
			modeloCaballero.deleteInGroup(paraEliminar);
			
			response.sendRedirect("verCaballeros?msg=succes");
		}else {
			response.sendRedirect("verCaballeros?msg=error");
		}

	}

	

}
