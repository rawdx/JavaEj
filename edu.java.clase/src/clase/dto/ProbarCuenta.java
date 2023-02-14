package clase.dto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProbarCuenta {

	public static void main(String[] args) {

		CuentaCorriente miCuenta = new CuentaCorriente();
		Scanner sc = new Scanner(System.in);
		ArrayList<CuentaCorriente> listaCuentas = new ArrayList<>();
		int opcion;

		do {
			mostrarMenu();
			System.out.print("\nIntroduzca la operación que desea realizar: ");
			opcion = sc.nextInt();

			while (opcion < 1 || opcion > 5) {
				System.err.println("Error. No has introducido una opción válida.");
				System.out.print("Vuelva a introducir una opción: ");
				opcion = sc.nextInt();
			}

			switch (opcion) {
			case 1:
				listaCuentas.add(miCuenta.crearCuenta());
				System.out.println("La cuenta se ha creado exitosamente: " + listaCuentas.get(listaCuentas.size() - 1).toString());
				break;

			case 2:
				listaCuentas = miCuenta.ingresoCuenta(listaCuentas);
				break;
			case 3:
				listaCuentas = miCuenta.retiroCuenta(listaCuentas);
				break;
			case 4:
				miCuenta.mostrarInfo(listaCuentas);
				break;
			}
		} while (opcion != 5);
		sc.close();
	}

	static void mostrarMenu() {
		System.out.println("\n--- Cuenta Bancaria ---");
		System.out.println("1. Crear cuenta");
		System.out.println("2. Ingresar dinero");
		System.out.println("3. Retirar dinero");
		System.out.println("4. Mostrar información");
		System.out.println("5. Salir");
	}

}
