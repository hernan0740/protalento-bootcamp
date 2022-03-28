package ar.com.educacionit.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ar.com.educacionit.domain.RegistroUsuario;

public class RegistroUsuarioImpl extends RegistroUsuario {
	
	Map<Integer, RegistroUsuario> listado = new HashMap<Integer, RegistroUsuario>();
	ArrayList<RegistroUsuario> usuarios=new ArrayList<RegistroUsuario>();
	
	public void save(RegistroUsuario usuario) {

	
		listado.put(usuario.getDocumento(), usuario);
												
	}
	
	
	public Map<Integer, RegistroUsuario> getListado() {
		return listado;
	}


	public void  listar() {
	
		
		Iterator it = listado.keySet().iterator();
		while(it.hasNext()){
		  Integer key = (Integer) it.next();
		 
		  System.out.println("Clave: " + key + " -> Valor: " + listado.get(key));
	
		
		}
	
}

}
