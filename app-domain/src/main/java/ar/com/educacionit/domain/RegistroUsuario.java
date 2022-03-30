package ar.com.educacionit.domain;

import java.time.LocalDate;
import java.util.Date;

public class RegistroUsuario {

	
	@Override
	public String toString() {
		return " [Nombre= " + nombre+" "+apellido + "   _Documento= " + documento + "   _Edad= " + edad
				+ "   _Ocupacion= " + ocupacion + "   _FechaNacimiento= " + fechaNacimiento + "]";
	}

	private String nombre;
	private String apellido;
	private int documento;
	private int edad;
	private String ocupacion;
	private LocalDate fechaNacimiento;
	
	public RegistroUsuario() {}
	
	public RegistroUsuario(String nombre, String apellido, int documento, int edad, String ocupacion,
			LocalDate fechaNacimiento) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.edad = edad;
		this.ocupacion = ocupacion;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
	
}
