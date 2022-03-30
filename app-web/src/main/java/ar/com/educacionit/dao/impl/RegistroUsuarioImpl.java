package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.dao.jdbc.util.DTOUtils;
import ar.com.educacionit.domain.RegistroUsuario;

public class RegistroUsuarioImpl extends RegistroUsuario {
	
	Map<Integer, RegistroUsuario> listado = new HashMap<Integer, RegistroUsuario>();
	ArrayList<RegistroUsuario> usuarios=new ArrayList<RegistroUsuario>();
	RegistroUsuario usuario;

public void saveSQL(RegistroUsuario usuario) throws DuplicatedException, GenericException {
		
	String sql = "INSERT INTO taller (nombre,apellido,documento,edad,ocupacion,fechaNacimiento) "
			+ "VALUES ('"+ usuario.getNombre() + "','" +
			             usuario.getApellido() + "','"+
						usuario.getDocumento() + "','" +
						usuario.getEdad() + "','" +
						usuario.getOcupacion() + "','" +
						usuario.getFechaNacimiento() + "')";
	
	try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

		try (PreparedStatement st = con.prepareStatement(sql)) {
			
			st.execute();
		}
		}catch (Exception e) {			
			throw new GenericException("No se pudo insertar:" +sql, e);
					}
	}	


	
public ArrayList<RegistroUsuario>  listarSQL() throws GenericException {

	ArrayList<RegistroUsuario> list = new ArrayList<>();
	Map<Integer, RegistroUsuario> listadosql = new HashMap<Integer, RegistroUsuario>();
	String sql = "select * from taller";
	//connection
	try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

		try (Statement st = con.createStatement()) {

			try (ResultSet res = st.executeQuery(sql)) {
				while (res.next())
				{
					
					RegistroUsuario usuario=new RegistroUsuario();
					usuario.setNombre(res.getString("nombre"));
					usuario.setApellido(res.getString("apellido"));
					usuario.setDocumento(res.getInt("documento"));
					usuario.setEdad(res.getInt("edad"));
					usuario.setOcupacion(res.getString("ocupacion"));
					String datoFecha=res.getString("fechaNacimiento");
					DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
					LocalDate fechaNacimiento = LocalDate.parse(datoFecha, formato1); 
					usuario.setFechaNacimiento(fechaNacimiento);
					
					list.add(usuario);
					listado.put(usuario.getDocumento(), usuario);
					}
				}
			}
	}catch (Exception e) {			
				throw new GenericException("No se pudo consultar:" +sql , e);
			}

	return list;
	
}


}
