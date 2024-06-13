import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Empresa miEmpresa = new Empresa();
		List<Vehiculo> misV;
		boolean continuar = true;

		System.out.println("Bienvenido al sistema de gestión de vehiculos.");

		do {
			System.out.println("\nMenú:");
			System.out.println("A. Dar de alta a un vehiculo");
			System.out.println("B. Dar de alta un cliente");
			System.out.println("C. Alquilar un vehiculo para un cliente");
			System.out.println("D. Mostrar lista vehiculos");
			System.out.println("E. Cobro");
			System.out.println("Otra cosa. Salir");
			System.out.print("Ingrese su opción: ");
			String respuesta = sc.nextLine();

			if (respuesta.compareToIgnoreCase("A") == 0) {

				respuesta = tipoCoche(sc);

				if (respuesta.compareToIgnoreCase("Coche") == 0) {

					Coche v = crearCoche(sc);
					if (miEmpresa.addVehiculo(v)) {
						System.out.println("¡Coche creado correctamente!");
						System.out.println("Matrícula: " + v.getMatricula());
					} else {
						System.out.println("¡El coche no ha podido crearse!");
					}

				} else if (respuesta.compareToIgnoreCase("Furgón") == 0) {

					Furgon v = crearFurgon(sc);
					if (miEmpresa.addVehiculo(v)) {
						System.out.println("¡Furgón creado correctamente!");
						System.out.println("Matrícula: " + v.getMatricula());
					} else {
						System.out.println("¡El furgón no ha podido crearse!");
					}

				} else {

					Camion v = crearCamion(sc);
					if (miEmpresa.addVehiculo(v)) {
						System.out.println("¡Camión creado correctamente!");
						System.out.println("Matrícula: " + v.getMatricula());
					} else {
						System.out.println("¡El camión no ha podido crearse!");
					}

				}

			} else if (respuesta.compareToIgnoreCase("B") == 0) {

				Cliente c = crearCliente(sc);
				boolean b = miEmpresa.addCliente(c);
				if (b) {
					System.out.println("¡Cliente creado correctamente!");
					System.out.println("DNI: " + c.getDni());
				} else {
					System.out.println("¡El cliente no ha podido crearse!");
				}

			} else if (respuesta.compareToIgnoreCase("C") == 0) {

				String matricula = matriculaVehiculo(sc);
				String dni = dniCliente(sc);
				Reserva r = crearReserva(sc, matricula, dni);
				boolean b = miEmpresa.alquilarVehiculo(r);
				if (b) {
					System.out.println("¡Reserva realizada correctamente!");
					System.out.println("Matrícula: " + matricula);
					System.out.println("DNI: " + dni);
				} else {
					System.out.println("¡La reserva no ha podido realizarse!");
				}

			} else if (respuesta.compareToIgnoreCase("D") == 0) {

				respuesta = tipoCoche(sc);

				if (respuesta.compareToIgnoreCase("Coche") == 0) {

					System.out.println("Introduce el número de plazas");
					respuesta = sc.nextLine();
					int plazas = Integer.valueOf(respuesta);
					System.out.println("Introduce el tipo de motor");
					String motor = sc.nextLine();
					misV = miEmpresa.listaCoches(plazas, motor);

				} else if (respuesta.compareToIgnoreCase("Furgón") == 0) {

					System.out.println("Introduce la carga máxima");
					respuesta = sc.nextLine();
					float cargaMax = Float.valueOf(respuesta);
					System.out.println("Introduce el número de plazas");
					respuesta = sc.nextLine();
					int plazas = Integer.valueOf(respuesta);
					misV = (List<Vehiculo>) miEmpresa.listaFurgones(cargaMax, plazas);

				} else {

					System.out.println("Introduce la carga máxima");
					respuesta = sc.nextLine();
					float cargaMax = Float.valueOf(respuesta);
					System.out.println("Introduce la longitud");
					respuesta = sc.nextLine();
					float longi = Float.valueOf(respuesta);
					misV = (List<Vehiculo>) miEmpresa.listaCamiones(cargaMax, longi);

				}

				if (respuesta.compareTo("") != 0) {
					System.out.println("Lista de Vehículos");
					System.out.println("------------------------");
					System.out.println(misV);
				} else {
					System.out.println("¡Aún no hay ningún vehículo registrado!");
				}

			} else if (respuesta.compareToIgnoreCase("E") == 0) {

				String matricula = matriculaVehiculo(sc);
				String dni = dniCliente(sc);
				System.out.println("Introduce los KM recorridos");
				respuesta = sc.nextLine();
				Float kmRecorridos = Float.valueOf(respuesta);
				System.out.println("Introduce los días utilizados");
				respuesta = sc.nextLine();
				int dias = Integer.valueOf(respuesta);
				Reserva r = crearReserva(sc, matricula, dni);
				float precio = miEmpresa.devolverVehiculo(r, kmRecorridos, dias);
				if (precio > 0) {
					System.out.println("¡Devolución realizada correctamente!");
					System.out.println("Precio: " + precio);
				} else {
					System.out.println("¡La devolución no ha podido realizarse!");
				}

			} else {

				continuar = false;

			}

			if (continuar) {

				System.out.println("Pulse ENTER para continuar");
				respuesta = sc.nextLine();

			}

		}
		while (continuar)
			;

		sc.close();

	}

	public static Coche crearCoche(Scanner sc) {

		String matricula;
		String modelo;
		String marca;
		float km;
		float precio;
		String motor;
		String respuesta;
		int plazas;
		int puertas;
		float volumenM;
		String tipo;

		System.out.println("Introduce la matrícula");
		matricula = sc.nextLine();
		System.out.println("Introduce el modelo");
		modelo = sc.nextLine();
		System.out.println("Introduce la marca");
		marca = sc.nextLine();
		System.out.println("Introduce los KM recorridos");
		respuesta = sc.nextLine();
		km = Float.valueOf(respuesta);
		System.out.println("Introduce el precio al día");
		respuesta = sc.nextLine();
		precio = Float.valueOf(respuesta);
		System.out.println("Introduce el tipo de motor");
		motor = sc.nextLine();
		System.out.println("Introduce las plazas máximas");
		respuesta = sc.nextLine();
		plazas = Integer.valueOf(respuesta);
		System.out.println("Introduce las puertas");
		respuesta = sc.nextLine();
		puertas = Integer.valueOf(respuesta);
		System.out.println("Introduce el volumen del maletero");
		respuesta = sc.nextLine();
		volumenM = Float.valueOf(respuesta);
		System.out.println("Introduce el tipo");
		tipo = sc.nextLine();

		return new Coche(matricula, modelo, marca, motor, precio, km, plazas, puertas,
				volumenM, tipo);
		}

	public static Furgon crearFurgon(Scanner sc) {

		String matricula;
		String modelo;
		String marca;
		float km;
		float precio;
		String motor;
		String respuesta;
		float cargaMax;
		int plazas;

		System.out.println("Introduce la matrícula");
		matricula = sc.nextLine();
		System.out.println("Introduce el modelo");
		modelo = sc.nextLine();
		System.out.println("Introduce la marca");
		marca = sc.nextLine();
		System.out.println("Introduce los KM recorridos");
		respuesta = sc.nextLine();
		km = Float.valueOf(respuesta);
		System.out.println("Introduce el precio al día");
		respuesta = sc.nextLine();
		precio = Float.valueOf(respuesta);
		System.out.println("Introduce el tipo de motor");
		motor = sc.nextLine();
		System.out.println("Introduce la carga máxima");
		respuesta = sc.nextLine();
		cargaMax = Integer.valueOf(respuesta);
		System.out.println("Introduce las plazas máximas");
		respuesta = sc.nextLine();
		plazas = Integer.valueOf(respuesta);

		return new Furgon(matricula, modelo, marca, km, precio, motor, cargaMax, plazas);

	}

	public static Camion crearCamion(Scanner sc) {

		String matricula;
		String modelo;
		String marca;
		float kmRecorridos;
		float precioDia;
		String tipoMotor;
		String respuesta;
		float cargaMaxima;
		float longitud;

		System.out.println("Introduce la matrícula");
		matricula = sc.nextLine();
		System.out.println("Introduce el modelo");
		modelo = sc.nextLine();
		System.out.println("Introduce la marca");
		marca = sc.nextLine();
		System.out.println("Introduce los KM recorridos");
		respuesta = sc.nextLine();
		kmRecorridos = Float.valueOf(respuesta);
		System.out.println("Introduce el precio al día");
		respuesta = sc.nextLine();
		precioDia = Float.valueOf(respuesta);
		System.out.println("Introduce el tipo de motor");
		tipoMotor = sc.nextLine();
		System.out.println("Introduce la carga máxima");
		respuesta = sc.nextLine();
		cargaMaxima = Float.valueOf(respuesta);
		System.out.println("Introduce la longitud");
		respuesta = sc.nextLine();
		longitud = Float.valueOf(respuesta);

		return new Camion(matricula, modelo, marca, kmRecorridos, precioDia, tipoMotor, cargaMaxima, longitud);
	}

	public static Cliente crearCliente(Scanner sc) {

		String dni;
		String nombre;
		String apellidos;
		String email;
		String telefono;
		String numeroTarjeta;

		System.out.println("Introduce el dni");
		dni = sc.nextLine();
		System.out.println("Introduce el nombre");
		nombre = sc.nextLine();
		System.out.println("Introduce los apellidos");
		apellidos = sc.nextLine();
		System.out.println("Introduce el email");
		email = sc.nextLine();
		System.out.println("Introduce el teléfono");
		telefono = sc.nextLine();
		System.out.println("Introduce el número de tarjeta");
		numeroTarjeta = sc.nextLine();

		return new Cliente(dni, nombre, apellidos, email, telefono, numeroTarjeta);

	}

	public static String matriculaVehiculo(Scanner sc) {
		String matricula;
		System.out.println("Introduce la matrícula");
		matricula = sc.nextLine();
		return matricula;
	}

	public static String dniCliente(Scanner sc) {
		String dni;
		System.out.println("Introduce el dni");
		dni = sc.nextLine();
		return dni;
	}

	public static String tipoCoche(Scanner sc) {
		String tipoCoche;
		boolean seguir = true;
		System.out.println("Introduce el tipo de Coche");
		System.out.println("Coche / Furgón / Camión");
		tipoCoche = sc.nextLine();
		if (tipoCoche.compareToIgnoreCase("Coche") == 0 || tipoCoche.compareToIgnoreCase("Camión") == 0
				|| tipoCoche.compareToIgnoreCase("Furgón") == 0) {

			seguir = false;

		}
		while (seguir) {
			System.out.println("Introduce correctamente el tipo de Coche");
			System.out.println("Coche / Furgón / Camión");
			tipoCoche = sc.nextLine();
			if (tipoCoche.compareToIgnoreCase("Coche") == 0 || tipoCoche.compareToIgnoreCase("Camión") == 0
					|| tipoCoche.compareToIgnoreCase("Furgón") == 0) {

				seguir = false;

			}
		}
		return tipoCoche;
	}

	public static Reserva crearReserva(Scanner sc, String matricula, String dni) {

		System.out.println("Introduce la fecha de inicio dd/MM/yyyy");
		String respuesta;
		respuesta = sc.nextLine();
		LocalDate fechaInicio = LocalDate.parse(respuesta, DateTimeFormatter.ofPattern("d/M/yyyy"));
		System.out.println("Introduce los días alquilados");
		respuesta = sc.nextLine();
		int diasAlquilados = Integer.valueOf(respuesta);

		return new Reserva(matricula, dni, diasAlquilados, fechaInicio);

	}

}
