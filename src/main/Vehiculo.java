package main;

import java.io.Serializable;

class Vehiculo implements Serializable {
	
	private String VIN;
	private String marca;
	private String modelo;
	private int NumPasajeros;
	private Propietario propietario;
	private double Precio;
	private int año;
	
	public Vehiculo(String vinString, String marcaString, int numPasajeros, Propietario propietario, int año) {
		super();
		this.VIN = vinString;
		this.marca = marcaString;
		this.NumPasajeros = numPasajeros;
		this.propietario = propietario; // referencia al objeto propietario
		this.año = año;
	}
	
	String getVIN() {
		return VIN;
	}
	
	String getMarca() {
		return marca;
	}
	
	int getNumPasajeros() {
		return NumPasajeros;
	}
	
	Propietario getPropietario() {
		return propietario;
	}
	
	int getAño() {
		return año;
	}
	
	@Override
	public String toString() {
		return "Vehiculo: \n" +
				"VIN: " + VIN + "\n" +
				"Marca: " + marca + "\n" +
				"Numero de Pasajeros: " + NumPasajeros + "\n" +
				"Propietario: " + propietario.getNombre() + "\n" +
				"Año: " + año;
	}

}
