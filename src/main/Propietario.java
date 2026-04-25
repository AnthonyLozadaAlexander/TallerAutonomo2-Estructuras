package main;

import java.io.Serializable;

class Propietario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String cedula;
	private String nombre;
	
	public Propietario(String cedula, String nombre) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
	}
	
	String getNombre() {
		return nombre;
	}
	
	String getCedula() {
		return cedula;
	}
	
	@Override
	public String toString() {
		return "Propietario: \n" +
				"Cedula: " + cedula + "\n" +
				"Nombre: " + nombre;
	}
	
	
}
