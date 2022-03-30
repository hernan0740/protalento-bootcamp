package ar.com.educacionit.servlet;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.RegistroUsuarioImpl;
import ar.com.educacionit.domain.RegistroUsuario;


@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

	RegistroUsuarioImpl saveUsuario=new RegistroUsuarioImpl();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String nombre=req.getParameter("nombre");
			String apellido=req.getParameter("apellido");
			int documento = Integer.parseInt(req.getParameter("documento"));
			int edad=Integer.parseInt(req.getParameter("edad"));
			String ocupacion=req.getParameter("ocupacion");
			String datoFecha=req.getParameter("fechaNacimiento");
			DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
			LocalDate fechaNacimiento = LocalDate.parse(datoFecha, formato1); 

			//LOGIN SERVICE
			RegistroUsuario usuario=new RegistroUsuario(nombre, apellido, documento, edad, ocupacion, fechaNacimiento);
			
			if(usuario !=null) {

				try {
							saveUsuario.saveSQL(usuario);
						} catch (DuplicatedException | GenericException e) {
							getServletContext().getRequestDispatcher("/fail.jsp").forward(req, resp);
							e.printStackTrace();
						}
			
					}
	
			//continuar a la otra pagina y entregar la lista de articulos
			
			getServletContext().getRequestDispatcher("/succes.jsp").forward(req, resp);
			
		}

	}
