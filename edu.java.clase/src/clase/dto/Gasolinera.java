package clase.dto;

import java.util.ArrayList;

public class Gasolinera {

	public static void main(String[] args) {
		
		ArrayList<Repostaje> listaRepos = new ArrayList<>();
		Repostaje miRepo = new Repostaje();
		int opcion;
		
		do {
			mostrarMenu();
			opcion = miRepo.CapturaOpcion("\nIntroduce una opción", 1, 6);
			
			switch(opcion) {
			case 1:
				listaRepos.add(miRepo.RepostajeNormal());
				break;
			case 2:
				listaRepos.add(miRepo.RepostajeFactura());
				break;
			case 3:
				miRepo.MostrarRepostajes(listaRepos);
				break;
			case 4:
				listaRepos = miRepo.BorrarRepostaje(listaRepos);
				break;
			case 5:
				listaRepos = miRepo.ModificarRepostaje(listaRepos);
				break;
			}
		}while(opcion != 6);
	}
	
	static void mostrarMenu() {
		System.out.println("\n--- Gasolinera ---");
		System.out.println("1. Repostaje normal");
		System.out.println("2. Repostaje factura");
		System.out.println("3. Mostrar repostajes");
		System.out.println("4. Borrar repostaje");
		System.out.println("5. Modificar repostaje");
		System.out.println("6. Salir");
	}
	

}
