package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escritura <T>{
	private String nombreArchivo;
	private FileOutputStream archivo;
	private ObjectOutputStream escritura;
	
	public Escritura(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}
	
	void abrir() throws IOException {
		archivo = new FileOutputStream(nombreArchivo);
		escritura = new ObjectOutputStream(archivo);
	}
	
	void escribir(T dato) throws IOException {
		if(escritura != null) { // si el flujo de escritura no es null
			escritura.writeObject(dato);
		}
	}
	
	void cerrar() throws IOException {
		if(escritura != null) { // si el flujo de escritura no es null
			escritura.close();
		}
	}

}
