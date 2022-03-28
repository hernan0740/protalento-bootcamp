package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
@WebServlet("/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArticulosServices service=new ArticulosServicesImpl();
		
		try {
			List<Articulos> listado =service.findAll();
			req.setAttribute("Listado", listado);
			getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
			 
		} catch (ServiceException e) {
			//getServletContext().getRequestDispatcher("/loginSuccess.jsp").forward(req, resp);
			//o envairlo a una lsita vacia
			List<Articulos> listado=new ArrayList<>();
			req.setAttribute("Listado", listado);
			getServletContext().getRequestDispatcher("/loginSuccess.jsp").forward(req, resp);
		}
		
	
	}
}
