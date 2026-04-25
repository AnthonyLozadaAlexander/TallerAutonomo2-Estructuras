package main;

import java.util.Scanner;

public class Main {
	// Interfaz Consola - Brian
	public static void main(String[] args) {
		Escritura<Vehiculo> escritor = new Escritura<>("Vehiculos.dat"); 
		Scanner input = new Scanner(System.in);
		int n;
		
		
		
		
		// Ingreso Del Numero De Vehiculos A Registrar
		System.out.println("  Ingrese El Numero De Vehiculos A Registrar: ");
		if(!input.hasNextInt()) {
			throw new NumberFormatException("Error: Formato Invalido, Se Espera Un Entero Positivo");
		}
			n = input.nextInt();
			if(n <= 0) {
				System.out.println("Error: El Tamaño Del Vector Debe Ser Un Entero Positivo");
			}
			
		input.nextLine(); // Limpiar el buffer de entrada
		
		TADVector<Vehiculo> vectorVehiculos = new TADVector<>(n, "Vector Vehiculos");
		
	
	
	for(int i = 0; i < vectorVehiculos.getLongitud(); i++) {
String numeroIdentificacion, nombre;
		
		System.out.println(" Registro Del Vehiculo [" +(i+1)+"]" );

		System.out.println("Ingrese Sus Datos Personales: ");
		System.out.println("Ingrese Su Numero De Identificacion: ");
		numeroIdentificacion = input.nextLine();
		System.out.println("Ingrese su Nombre Completo: ");
		nombre = input.nextLine();
		
		Propietario dueño = new Propietario(numeroIdentificacion, nombre);
		
		System.out.println("Ingrese Los Datos Del Vehiculo");
		System.out.println("Ingrese El VIN Del Vehiculo");
		String vin = input.nextLine();
		System.out.println("Ingrese La Marca Del Vehiculo");
		String marca = input.nextLine();
		System.out.println("Ingrese El Modelo Del Vehiculo");
		String modelo = input.nextLine();
		System.out.println("Ingrese El Numero De Pasajeros Del Vehiculo");
		int numPasajeros = input.nextInt();
		System.out.println("Ingrese El Precio Del Vehiculo");
		double precio = input.nextDouble();
		System.out.println("Ingrese El Año Del Vehiculo");
		int año = input.nextInt();
		
		Vehiculo v = new Vehiculo(vin, marca, numPasajeros, dueño, año);
		
		if(vectorVehiculos.insertarElemento(v, i)) {
			System.out.println("Vehiculo ["+(i+1)+"] registrado exitosamente.");
		}else {
			System.out.println("Error: No se pudo registrar el vehiculo ["+(i+1)+"].");
			i--; // Decrementar el contador para intentar registrar nuevamente
		}
		
		// utilizar los metodos del TADVector para insertar los vehiculos en el vector, imprimir el vector
		
	}
	
	
	}
}
