package clase.dto;

import java.util.ArrayList;
import java.util.Scanner;

public class Gasolinera {

	public static void main(String[] args) {
		
		ArrayList<Repostaje> listaRepos = new ArrayList<>();
		Repostaje miRepo = new Repostaje();
		int opcion;
		
		do {
			mostrarMenu();
			opcion = capturaOpcion();
			
			switch(opcion) {
			case 1:
				listaRepos.add(miRepo.RepostajeNormal());
				break;
			case 2:
				listaRepos.add(miRepo.RepostajeFactura());
				break;
			case 3:
				miRepo.mostrarRepostajes(listaRepos);
				break;
			}
		}while(opcion != 4);
	}
	
	static void mostrarMenu() {
		System.out.println("\n--- Gasolinera ---");
		System.out.println("1. Repostaje normal");
		System.out.println("2. Repostaje factura");
		System.out.println("3. Mostrar repostajes");
		System.out.println("4. Salir");
	}
	
	static int capturaOpcion() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nIntroduce una opción:");
		int opcion = sc.nextInt();
		
		while (opcion < 1 || opcion > 4) {
			System.err.println("Error. No has introducido una opción válida.");
			System.out.print("Vuelva a introducir una opción: ");
			opcion = sc.nextInt();
		}
		return opcion;
	}

}
