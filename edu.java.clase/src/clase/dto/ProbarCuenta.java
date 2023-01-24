package clase.dto;

import java.util.Scanner;

public class ProbarCuenta {

	public static void main(String[] args) {

		CuentaCorriente miCuenta = new CuentaCorriente();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n--- Cuenta Bancaria ---");
			System.out.println("1. Crear cuenta");
			System.out.println("2. Ingresar dinero");
			System.out.println("3. Retirar dinero");
			System.out.println("4. Mostrar información");
			System.out.println("5. Salir");

			System.out.print("\nIntroduzca la operación que desea realizar: ");
			opcion = sc.nextInt();

			while (opcion < 1 || opcion > 5) {
				System.err.println("Error. No has introducido una opción válida.");
				System.out.println("Vuelva a introducir una opción: ");
				opcion = sc.nextInt();
			}

			switch (opcion) {
			case 1:
				System.out.print("Introduzca su DNI:");
				String dni = sc.next();

				System.out.print("Introduzca su nombre:");
				String nombre = sc.next();

				miCuenta.crearCuenta(dni, nombre);
				System.out.println("La cuenta se ha creado exitosamente.");
				break;

			case 2:
				if (miCuenta.getDni() == null)
					System.out.println("Para ingresar dinero debes crear una cuenta.");
				else {
					System.out.print("Introduzca la cantidad a ingresar: ");
					double ingreso = sc.nextDouble();

					miCuenta.ingresarDinero(ingreso);
					System.out.println("Se ingresarán " + ingreso + "$.");
				}
				break;

			case 3:
				if (miCuenta.getDni() == null)
					System.out.println("Para retirar dinero debes crear una cuenta.");
				else {
					System.out.print("Introduzca la cantidad a retirar: ");
					double retirada = sc.nextDouble();

					if (miCuenta.getSaldo() >= retirada) {
						miCuenta.retirarDinero(retirada);
						System.out.println("Se retirarán " + retirada + "$. Tu saldo será " + miCuenta.getSaldo() + "$.");
					} else
						System.out.println("Tu saldo actual es " + miCuenta.getSaldo()
								+ "$. No tienes suficientes fondos para retirar " + retirada + "$.");
				}
				break;

			case 4:
				if (miCuenta.getDni() == null)
					System.out.println("Para mostrar información debes crear una cuenta.");
				else
					miCuenta.mostrarInfo();
				break;
			}
		} while (opcion != 5);
		sc.close();
	}
}
