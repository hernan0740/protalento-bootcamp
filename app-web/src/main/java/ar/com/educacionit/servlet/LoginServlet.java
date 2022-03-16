package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.LoginServiceImpl;
import ar.com.educacionit.web.enums.LoginViewEnum;
import ar.com.educacionit.web.enums.ViewEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//captura los parametros envaidos por el html/jsp
		
		String usernameFromHtml=req.getParameter(LoginViewEnum.USERNAME.getParam());
		String passwordFrontHtml=req.getParameter(LoginViewEnum.PASSWORD.getParam());
		
		//LOGIN SERVICE
		LoginService ls=new LoginServiceImpl();
		
		//Users user= ls.getUserByUserName(usernameFromHtml);
		ViewEnums target=ViewEnums.LOGIN_SUCCESS;
		Users user;
		try {
				user = ls.getUserByUserName(usernameFromHtml);
			
			if(user !=null) {
				//BCrypt encriptacion
				BCrypt.Result result= BCrypt.verifyer().
						verify(passwordFrontHtml.getBytes(), user.getPassword().getBytes());
				//Realizar el hash de password que viene de htmk y compararlo con  le del request
				if(!result.verified) {
					target=ViewEnums.LOGIN;
					//enviar al usuario loginSucces.jsp
				}
		
			}else {
				//login.jsp con algun mensaje de no existe usuario
				target=ViewEnums.LOGIN;
			}
		} catch (ServiceException e) {
			
			e.printStackTrace();
			target= ViewEnums.ERROR_GENERAL;
		}
		
		getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);;
	}
	
}
