package servletCaballero;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conector.Conector;
import modelo.bean.Arma;
import modelo.bean.Caballero;
import modelo.bean.Escudo;
import modelo.dao.ModeloCaballero;

/**
 * Servlet implementation class storeCaballero
 */
@WebServlet("/storeCaballero")
public class storeCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public storeCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("addNombre");
		int fuerza = Integer.parseInt(request.getParameter("addFuerza"));
		int experiencia = Integer.parseInt(request.getParameter("addExperiencia"));
		String foto = request.getParameter("addFoto");
		int arma_id = Integer.parseInt(request.getParameter("addArma"));
		int escudo_id= Integer.parseInt(request.getParameter("addEscudo"));
		
		Escudo escudo = new Escudo();
		escudo.setId(escudo_id);
		Arma arma = new Arma();
		arma.setId(arma_id);
		
		Caballero caballero = new Caballero(escudo_id, nombre, fuerza, experiencia, foto, arma, escudo);
		
		ModeloCaballero mdCaballero = new ModeloCaballero();
		mdCaballero.setConector(new Conector());
		
		if (mdCaballero.insert(caballero)) {
			response.sendRedirect("verCaballeros");
			System.out.println("success");
		}else {
			System.out.println("error");
		}
	}

}
