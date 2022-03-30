package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.RegistroUsuarioImpl;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.RegistroUsuario;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;

@WebServlet("/LregistroServlet")
public class LregistroServlet extends HttpServlet {
	
	RegistroUsuarioImpl saveUsuario=new RegistroUsuarioImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
		ArrayList<RegistroUsuario> listado = saveUsuario.listarSQL();

			//guardar el listado en  "request"
			req.setAttribute("Listado", listado);
			//continuar a la otra pagina y entregar la lista de articulos
			getServletContext().getRequestDispatcher("/listarRegistro.jsp").forward(req, resp);
		
		} catch (GenericException e) {
			
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/RegistroDatos.html").forward(req, resp);
		}

	}
}
