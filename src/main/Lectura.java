package main;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

class Lectura <T> {
	private String nombreArchivo;
	private FileInputStream archivo;
	private ObjectInputStream lectura;
	
	// constructor para inicializar el nombre del archivo
	public Lectura(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}
	
	// metodo para abrir el archivo y crear el flujo de lectura
	public void abrir() throws IOException {
		archivo = new FileInputStream(nombreArchivo);
		lectura = new ObjectInputStream(archivo);
	}
	
	// Metodo para leer un dato del archivo, devuelve null si se llega al final del archivo
	@SuppressWarnings("unchecked")
	public T leer() throws ClassNotFoundException, IOException {
		try {
			if(lectura != null)
				return (T) lectura.readObject();
			else
				return null;
		}
		catch(EOFException eof) {
			return null;
		}
	}
	
	// Metodo para cerrar el flujo de lectura y el archivo
	public void cerrar() throws IOException {
		if(lectura != null)
			lectura.close();
	}
}
