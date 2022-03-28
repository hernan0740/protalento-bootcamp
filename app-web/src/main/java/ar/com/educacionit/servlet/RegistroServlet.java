package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.dao.impl.RegistroUsuarioImpl;
import ar.com.educacionit.domain.RegistroUsuario;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.LoginServiceImpl;
import ar.com.educacionit.web.enums.LoginViewEnum;
import ar.com.educacionit.web.enums.ViewEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

	RegistroUsuarioImpl saveUsuario=new RegistroUsuarioImpl();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			//Map<Integer, RegistroUsuario> listado = new HashMap<Integer, RegistroUsuario>();			
			String nombre=req.getParameter("nombre");
			System.out.println("nombre listo");
			String apellido=req.getParameter("apellido");
			System.out.println("apellido ok");
			int documento = Integer.parseInt(req.getParameter("documento"));
			System.out.println("documento ok");
			int edad=Integer.parseInt(req.getParameter("edad"));
			System.out.println("edad ok");
			String ocupacion=req.getParameter("ocupacion");
			System.out.println("ocupacion ok");
			String datoFecha=req.getParameter("fechaNacimiento");
			//SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd"); 
			//Date fechaNacimiento=formato.parse(datoFecha);
			
			
			DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
			LocalDate fechaNacimiento = LocalDate.parse(datoFecha, formato1); 
			System.out.println("fecha ok");
			
			//LOGIN SERVICE
			RegistroUsuario usuario=new RegistroUsuario(nombre, apellido, documento, edad, ocupacion, fechaNacimiento);
			
			if(usuario !=null) {
				
				saveUsuario.save(usuario);
				saveUsuario.listar();
				
				}else {
					
					getServletContext().getRequestDispatcher("/fail.jsp").forward(req, resp);
				}
	
			//continuar a la otra pagina y entregar la lista de articulos
			
			getServletContext().getRequestDispatcher("/succes.jsp").forward(req, resp);
			
		}
		
	}
