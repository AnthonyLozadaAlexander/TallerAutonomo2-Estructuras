package TAD;

import java.util.Arrays;

public class TADVector <T> {
	
	// Atributos de un vector
	private T[] vector;
	private int longitud;
	private String nombre;
	
	public TADVector(int longitud, String nombre) {
		super();
		this.longitud = longitud;
		this.nombre = nombre;
		vector =  (T[]) new Object[longitud]; // inicializa el vector con una longitud dada y se castea a un arreglo de tipo Generico
	}
	
	@Override
	public String toString() {
		return "Vector "+ nombre + "\n" +
	    "Tamaño: " + longitud + "\n" +
		"Elementos: " + Arrays.toString(vector);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getLongitud() {
		return longitud;
	}
	
	public void imprimirVector() {
		for(int i=0; i<=vector.length-1; ++i) {
			if(i==0) 
				System.out.print("[");
			
			if(i <= vector.length - 2){
			System.out.print(vector[i] + ", ");
			}else {
				System.out.print(vector[i]);
			}
			
			if(i==vector.length-1) 
				System.out.print("]\n");
		}
	}
	
	// metodo para imprimir solo los elementos existentes no nulos del vector
		public void imprimirVectorNoNulos() {
			for (int i = 0; i <= vector.length-1; i++) {
				if(vector[i] != null) {
					System.out.println("Pos["+i+"]" + vector[i]);
				}
			}
		}
		
		public boolean insertarElemento(T dato, int pos) {
			boolean resul = false;
			
			if(pos>=0 && pos<vector.length && vector[pos] == null) {
				vector[pos] = dato;
				resul = true;
			}
			
			return resul;		
		}
		
		public boolean modificarElemento(T datoNuevo, int pos) {
			boolean resul = false;
			
			if(pos>=0 && pos<vector.length && vector[pos] != null) {
				vector[pos] = datoNuevo;
				resul = true;
			}
			
			return resul;
		}
		
		public boolean modificarElemento(T datoNuevo, T dato) {
			boolean resul = false;
			
			for(int pos=0; pos<vector.length; ++pos) {		
				if(vector[pos].equals(dato)) {
					vector[pos] = datoNuevo;
					resul = true;
					pos = vector.length;
				}
			}
			
			return resul;
		}
		
		public boolean eliminarElemento(int pos) {
			return modificarElemento(null, pos);
		}
			
		public boolean buscarElemento(T dato) {
			boolean resul = false;
			for(int pos=0; pos<vector.length; ++pos) {	
				if(vector[pos].equals(dato)) {
					resul = true;
					pos = vector.length;
				}
			}
			return resul;
		}
		
		/**
		 * Devuelve el elemento almacenado en la posición pos del vector
		 * @param pos Posición del elemento en el vector. Debe ser posición válida.
		 * @return El elemento almacenado en la posición pos del vector
		 */
		public T leerElemento(int pos) {
			if(pos >= 0 && pos < vector.length) {
				return vector[pos];
			}
			else {
			return null;
			}
		}
		
		/**
		 * Devuelve la posición de un elemento (dato) en el vector
		 * @param dato Elemento a buscar en el vector
		 * @return La posición del elemento en el vector o -1 si el elemento no existe
		 */

		public int buscarElemento2(T dato) {
			int index = 0;
		
			for (int i = 0; i <= vector.length-1; i++) {
				if(vector[i] != null && vector[i].equals(dato)) {
					index = i;
					i = vector.length;
					return index;
				}
			}
			
			return -1;
		}
		
		// Modificar Por Dato // Retorna Booleano
		public Boolean modificarPorDato(T datoNuevo, T datoAntiguo) {
			boolean result = false;
			if(datoNuevo == null) {
				throw new IllegalArgumentException("El dato nuevo no puede ser nulo");
			}
			
			for (int i = 0; i < vector.length; i++) {
				if(vector[i] != null && (vector[i].equals(datoAntiguo))) { // Si vector[i] es igual a datoAntiguo 
																		 //	y no es Nulo 																		
					vector[i] = datoNuevo;
					i = vector.length; // Salir del bucle después de modificar el primer elemento encontrado
					result = true;
				}
			}
			
			return result;
		}
		
		// Eliminar Elemento // Retorna Booleano
		public Boolean eliminarElementoPorDato(T dato) {
			boolean result = false;
			if(dato == null) {
				throw new IllegalArgumentException("El dato no puede ser nulo");
			}
			
			for (int i = 0; i < vector.length; i++) {
				if(vector[i] != null && vector[i].equals(dato)) { // si vector[i] no es nulo y es igual a dato
					vector[i] = null; // eliminar el elemento encontrado asignándole null
					i = vector.length; // Salir del bucle después de eliminar el primer elemento encontrado
					result = true;
				}
			}
			
			return result;
		}
}
