package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escritura <T>{
	private String nombreArchivo;
	private FileOutputStream archivo;
	private ObjectOutputStream escritura;
	
	// constructor para inicializar el nombre del archivo
	public Escritura(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}
	
	// metodo para abrir el archivo y crear el flujo de escritura
	void abrir() throws IOException {
		archivo = new FileOutputStream(nombreArchivo);
		escritura = new ObjectOutputStream(archivo);
	}
	
	// metodo para escribir un dato en el archivo
	void escribir(T dato) throws IOException {
		if(escritura != null) { // si el flujo de escritura no es null
			escritura.writeObject(dato);
		}
	}
	
	// metodo para cerrar el flujo de escritura y el archivo
	void cerrar() throws IOException {
		if(escritura != null) { // si el flujo de escritura no es null
			escritura.close();
		}
	}

}
