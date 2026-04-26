package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	// Interfaz Consola - Brian
	public static void main(String[] args) {
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>(); // ArrayList para almacenar los vehiculos              																		   registrados
		Escritura<Vehiculo> escritor = new Escritura<>("Vehiculos.dat");
		Lectura<Vehiculo> lector = new Lectura<Vehiculo>("Vehiculos.dat");
		Scanner input = new Scanner(System.in).useLocale(Locale.US);
		int n = 0, numPasajeros = 0, año = 0;
		double precio = 0.0;
		String opc = "", marca = "", modelo = "";
		String vin = "";
		boolean esValido = false;
		Vehiculo v;

		do {
			System.out.println("----------------------------------------------");
			System.out.println("Bienvenido Al Sistema De Registro De Vehiculos");
			System.out.println("----------------------------------------------");
			System.out.println("1. Ingrese El Numero De Vehiculos A Registrar");
			System.out.println("2. Generar Reporte De Vehiculos Registrados");
			System.out.println("3. Salir");
			System.out.println("---------------------------------------------");
			opc = input.nextLine();

			switch (opc) {
			case "1":
				do {
				// Ingreso Del Numero De Vehiculos A Registrar
				System.out.println("______________________________________________");
				System.out.println(" Ingrese El Numero De Vehiculos A Registrar: ");
				System.out.println("______________________________________________");
				if (!input.hasNextInt()) {
					throw new NumberFormatException("Error: Formato Invalido, Se Espera Un Entero Positivo");
				}
				n = input.nextInt();
				if (n <= 0) {
					System.out.println("Error: El Tamaño Del Vector Debe Ser Un Entero Positivo");
				}
				}while(n <= 0);

				input.nextLine(); // Limpiar el buffer de entrada

				TADVector<Vehiculo> vectorVehiculos = new TADVector<>(n, "Vector Vehiculos");

				// Abrir archivo para guardar vehiculos
				try {
					escritor.abrir();
				} catch (IOException e) {
					System.err.println("Error: No se pudo abrir el archivo Vehiculos.dat");
					return;
				}

				for (int i = 0; i < vectorVehiculos.getLongitud(); i++) {
					String numeroIdentificacion, nombre;
					System.out.println("     Registro Del Vehiculo [" + (i + 1) + "]");

					System.out.println("  --Ingreso De Datos Personales--  ");
					System.out.println("Ingrese Su Numero De Identificacion: ");
					numeroIdentificacion = input.nextLine();
					System.out.println("______________________________________________");
					System.out.println("Ingrese su Nombre Completo: ");
					nombre = input.nextLine();
					System.out.println("______________________________________________");

					Propietario dueño = new Propietario(numeroIdentificacion, nombre);
					do {
						System.out.println("  --Ingreso De Los Datos Del Vehiculo--");
						System.out.println("Ingrese El VIN Del Vehiculo:");
						vin = input.nextLine();
						System.out.println("______________________________________________");
						System.out.println("Ingrese La Marca Del Vehiculo:");
						marca = input.nextLine();
						System.out.println("______________________________________________");
						System.out.println("Ingrese El Modelo Del Vehiculo:");
						modelo = input.nextLine();
						System.out.println("______________________________________________");
						System.out.println("Ingrese El Numero De Pasajeros Del Vehiculo:");
						numPasajeros = input.nextInt();
						input.nextLine(); // Limpiar el buffer
						do {
							esValido = true;
							System.out.println("______________________________________________");
							System.out.println("Ingrese El Precio Del Vehiculo:");
							try {
								if (!input.hasNextDouble()) {
									System.out.println("Error: Formato Invalido");
									input.nextLine(); // Limpiar toda la línea
									esValido = false;
									continue;
								}
								precio = input.nextDouble();
								input.nextLine(); // Limpiar el buffer
								System.out.println("______________________________________________");
								System.out.println("Ingrese El Año Del Vehiculo:");
								if (!input.hasNextInt()) {
									System.out.println("Error: Formato Invalido");
									input.nextLine(); // Limpiar toda la línea
									esValido = false;
									continue;
								}
								año = input.nextInt();
								esValido = true;
							} catch (Exception e) {
								System.out.println("Error: Formato Invalido");
								input.nextLine(); // Limpiar toda la línea
								esValido = false;
							}
						} while (esValido == false);
						input.nextLine(); // Limpiar el buffer
						System.out.println("______________________________________________");

					} while (numPasajeros <= 0 || precio <= 0 || año <= 0 || numPasajeros <= 0 || precio <= 0
							|| año <= 0);
					v = new Vehiculo(vin, marca, numPasajeros, dueño, año);

					if (vectorVehiculos.insertarElemento(v, i)) {
						System.out.println("El Vehiculo [" + (i + 1) + "] ha sido registrado exitosamente.");
						System.out.println("______________________________________________");

						// Guardar vehiculo en el archivo
						try {
							escritor.escribir(v);
						} catch (IOException e) {
							System.err.println("Error: No se pudo guardar el vehiculo en el archivo.");
						}
					} else {
						System.out.println("Error: No se pudo registrar el vehiculo [" + (i + 1) + "].");
						i--; // Decrementar el contador para intentar registrar nuevamente
					}
					// Cerrar archivo
					try {
						escritor.cerrar();
					} catch (IOException e) {
						System.err.println("Error: No se pudo cerrar el archivo.");
					}
					// Leer contactos del archivo para verificar que se guardaron correctamente
					try {
						lector.abrir(); 
						do {
							v = lector.leer();
							if(v != null) { // si v no es null, agregarlo a lista de Vehiculos
								listaVehiculos.add(v);
							}
						}while(v != null);
						lector.cerrar();
					}catch(IOException e) {
						System.out.println("Error: No se pudo leer el archivo de vehiculos.");
					}catch(ClassNotFoundException e) {
						System.out.println("Error: El formato del archivo de vehiculos es incorrecto.");
					}

				}


				break;
			case "2":
				System.out.println("Generando Reporte De Vehiculos Registrados");
				System.out.println("______________________________________________");
				StringBuilder reporte = new StringBuilder();
				for(Vehiculo veh: listaVehiculos) {
					reporte.append(veh.toString()).append("\n");
				}
				System.out.println("----------------------------------------------");
				System.out.println("       Reporte De Vehiculos Registrados");
				System.out.println("----------------------------------------------");
				System.out.println(reporte.toString());
				
				break;
			case "3":
				System.out.println("Saliendo Del Sistema...");

				break;
			default:
				System.out.println("Opcion Invalida, Por Favor Ingrese Una Opcion Valida (1, 2 o 3)");
			}

		} while (!opc.equals("1") && !opc.equals("2") && !opc.equals("3"));

		input.close();
	}
}