package servletCaballero;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import conector.Conector;
import modelo.bean.Arma;
import modelo.bean.Caballero;
import modelo.bean.Escudo;
import modelo.dao.ModeloCaballero;

/**
 * Servlet implementation class storeCaballero
 */
@WebServlet("/storeCaballero")
@MultipartConfig
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
 // Ruta a la carpeta donde se guardarán las fotos
    private static final String UPLOAD_DIR = "fotos";
    private static final String APLICATIN_LOCAL_PATH = "C:\\Users\\plaiaundi\\Desktop\\Jagoba\\jee_workspace\\PruebasExam\\src\\main\\webapp\\imagenes";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener la parte del formulario con el archivo
        Part filePart = request.getPart("addfoto");
        String fileName = "";
        // Comprobar si se ha seleccionado un archivo
        if (filePart != null && filePart.getSize() > 0) {
            // Obtener el nombre del archivo
             fileName = getFileName(filePart);
            
            // Obtener la ruta completa de la carpeta de fotos
//            String applicationPath = request.getServletContext().getRealPath("");
//            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
            String uploadFilePath = APLICATIN_LOCAL_PATH + File.separator + UPLOAD_DIR;
            
            // Crear la carpeta de destino si no existe
            File uploadDir = new File(uploadFilePath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            
            // Ruta completa del archivo a guardar
            String filePath = uploadFilePath + File.separator + fileName;
            
            // Guardar el archivo en la ruta especificada
            try (InputStream inputStream = filePart.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(filePath)) {
                
                int read;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            }
        }
		
		
		String nombre = request.getParameter("addNombre");
		try {
			
		
		int fuerza = Integer.parseInt(request.getParameter("addFuerza"));
		int experiencia = Integer.parseInt(request.getParameter("addExperiencia"));
		String foto = fileName;
		int arma_id = Integer.parseInt(request.getParameter("addArma"));
		int escudo_id= Integer.parseInt(request.getParameter("addEscudo"));
		if (nombre.equals("")) {
			System.out.println("error");
			response.sendRedirect("agregarCaballero?msg=errorNombre");
		}
		
		else if (fuerza<0 || fuerza>100 || experiencia<0 || experiencia > 100) {
			System.out.println("error");
			response.sendRedirect("agregarCaballero?msg=errorValores");
		}
		
		else if (arma_id == 0) {
			System.out.println("error");
			response.sendRedirect("agregarCaballero?msg=error");
		}
	
		else if (escudo_id ==0) {
			System.out.println("error");
			response.sendRedirect("agregarCaballero?msg=error");
		}
		else {
			Escudo escudo = new Escudo();
			escudo.setId(escudo_id);
			Arma arma = new Arma();
			arma.setId(arma_id);
			
			Caballero caballero = new Caballero(escudo_id, nombre, fuerza, experiencia, foto, arma, escudo);
			
			ModeloCaballero mdCaballero = new ModeloCaballero();
			mdCaballero.setConector(new Conector());
			
			if (mdCaballero.insert(caballero)) {
				response.sendRedirect("verCaballeros?msg=correcto");
				System.out.println("success");
			}else {
				System.out.println("error");
				response.sendRedirect("agregarCaballero?msg=error");
			}
		}
		} catch (Exception e) {
			System.out.println("error");
			response.sendRedirect("agregarCaballero?msg=errorInsert");
		}
		
	}
	// Método para obtener el nombre del archivo
    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
