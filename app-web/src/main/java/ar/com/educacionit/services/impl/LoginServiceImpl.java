package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.SocioDaoImpl;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class LoginServiceImpl implements LoginService {	
	//Va a enlzar dos Daos User y Socios
	private UserDao userDao;
	private SociosDao socioDao;
	
	
	
	public LoginServiceImpl() {
	
		this.userDao = new UserDaoImpl();
		this.socioDao = new SocioDaoImpl();
	}

	@Override
	public Users getUserByUserNameAndPassword(String username, String passwordFrontHtml) throws ServiceException {
		try {
			Users users=this.userDao.getUserByUserName(username);
			//Valido password
			BCrypt.Result result= BCrypt.verifyer().verify(passwordFrontHtml.getBytes(), users.getPassword().getBytes());
			//Realizar el hash de password que viene de htmk y compararlo con  le del request
			if(!result.verified) {
				throw new ServiceException("creddenciales invalidas", null);
			}
			if(users !=null) {
				
				Socios socio=this.socioDao.getSociosByUserId(users.getId());
				users.setSocio(socio);
			}
			return users;
		} catch (GenericException e) {
			
			throw new ServiceException(e.getMessage(), e);
		}
		
	}

}
