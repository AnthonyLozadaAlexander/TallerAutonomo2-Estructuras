
package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	// Interfaz Consola - Brian
	public static void main(String[] args) {
		Escritura<Vehiculo> escritor = new Escritura<>("Vehiculos.dat"); 
		Scanner input = new Scanner(System.in);
		int n;
		
		
		
		
		// Ingreso Del Numero De Vehiculos A Registrar
		System.out.println("______________________________________________");
		System.out.println(" Ingrese El Numero De Vehiculos A Registrar: ");
		if(!input.hasNextInt()) {
			throw new NumberFormatException("Error: Formato Invalido, Se Espera Un Entero Positivo");
		}
			n = input.nextInt();
			if(n <= 0) {
				System.out.println("Error: El Tamaño Del Vector Debe Ser Un Entero Positivo");
			}
			
		input.nextLine(); // Limpiar el buffer de entrada
		
		TADVector<Vehiculo> vectorVehiculos = new TADVector<>(n, "Vector Vehiculos");
		
		// Abrir archivo para guardar vehiculos
		try {
			escritor.abrir();
		} catch (IOException e) {
			System.err.println("Error: No se pudo abrir el archivo Vehiculos.dat");
			return;
		}
	
	
	for(int i = 0; i < vectorVehiculos.getLongitud(); i++) {
		String numeroIdentificacion, nombre;
		System.out.println("     Registro Del Vehiculo [" +(i+1)+"]" );

		System.out.println("  --Ingreso De Datos Personales--");
		System.out.println("Ingrese Su Numero De Identificacion: ");
		numeroIdentificacion = input.nextLine();
		System.out.println("______________________________________________");
		System.out.println("Ingrese su Nombre Completo: ");
		nombre = input.nextLine();
		System.out.println("______________________________________________");
		
		Propietario dueño = new Propietario(numeroIdentificacion, nombre);
		
		System.out.println("  --Ingreso De Los Datos Del Vehiculo--");
		System.out.println("Ingrese El VIN Del Vehiculo:");
		String vin = input.nextLine();
		System.out.println("______________________________________________");
		System.out.println("Ingrese La Marca Del Vehiculo:");
		String marca = input.nextLine();
		System.out.println("______________________________________________");
		System.out.println("Ingrese El Modelo Del Vehiculo:");
		String modelo = input.nextLine();
		System.out.println("______________________________________________");
		System.out.println("Ingrese El Numero De Pasajeros Del Vehiculo:");
		int numPasajeros = input.nextInt();
		input.nextLine(); // Limpiar el buffer
		System.out.println("______________________________________________");
		System.out.println("Ingrese El Precio Del Vehiculo:");
		double precio = input.nextDouble();
		input.nextLine(); // Limpiar el buffer
		System.out.println("______________________________________________");
		System.out.println("Ingrese El Año Del Vehiculo:");
		int año = input.nextInt();
		input.nextLine(); // Limpiar el buffer
		System.out.println("______________________________________________");
		
		Vehiculo v = new Vehiculo(vin, marca, numPasajeros, dueño, año);
		
		if(vectorVehiculos.insertarElemento(v, i)) {
			System.out.println("El Vehiculo ["+(i+1)+"] ha sido registrado exitosamente.");
			System.out.println("______________________________________________");
			
			
			// Guardar vehiculo en el archivo
			try {
				escritor.escribir(v);
			} catch (IOException e) {
				System.err.println("Error: No se pudo guardar el vehiculo en el archivo.");
			}
		}else {
			System.out.println("Error: No se pudo registrar el vehiculo ["+(i+1)+"].");
			i--; // Decrementar el contador para intentar registrar nuevamente
		}
		
		// utilizar los metodos del TADVector para insertar los vehiculos en el vector, imprimir el vector
		
	}
	
	// Cerrar archivo
	try {
		escritor.cerrar();
	} catch (IOException e) {
		System.err.println("Error: No se pudo cerrar el archivo.");
	}
	
	input.close();
	}
}
