package clase.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Repostaje {
	
	private String fecha;
	private float litros;
	private float importe;
	private String dni;
	private String matricula;
	
	
	public String toString() {
		return " [fecha=" + fecha + ", litros=" + litros + ", importe=" + importe + "$, dni=" + dni
				+ ", matricula=" + matricula + "]";
	}

	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getLitros() {
		return litros;
	}

	public void setLitros(float litros) {
		this.litros = litros;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
	
	public Repostaje() {
		super();
	}
	
	public Repostaje(String fecha, float litros, float importe) {
		super();
		this.fecha = fecha;
		this.litros = litros;
		this.importe = importe;
	}

	public Repostaje(String fecha, float litros, float importe, String dni, String matricula) {
		super();
		this.fecha = fecha;
		this.litros = litros;
		this.importe = importe;
		this.dni = dni;
		this.matricula = matricula;
	}

	
	public Repostaje RepostajeNormal(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce la fecha del repostaje: ");
		String fecha = sc.next();
		
		System.out.print("Introduce los litros: ");
		float litros = sc.nextFloat();
		
		//1 litro = 1.66$
		float importe = litros * 1.66F;
		
		Repostaje n = new Repostaje(fecha, litros, importe);
		return n;
	}
	
	public Repostaje RepostajeFactura() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce la fecha del repostaje: ");
		String fecha = sc.next();

		System.out.print("Introduce los litros: ");
		float litros = sc.nextFloat();

		// 1 litro = 1.66$
		float importe = litros * 1.66F;

		System.out.print("Introduce el DNI: ");
		String dni = sc.next();
		
		System.out.print("Introduce la matrícula del coche: ");
		String matricula = sc.next();
		
		Repostaje f = new Repostaje(fecha, litros, importe, dni, matricula);
		return f;
	}
	
	public void MostrarRepostajes(ArrayList<Repostaje> listaRepos) {
		
		System.out.println("\n1. Repostajes normales");
		System.out.println("2. Repostajes con factura");
		System.out.println("3. Todos los repostajes");
		
		int opcion = CapturaOpcion("\nIntroduce que quieres mostrar", 1, 3);
		
		switch(opcion) {
		case 1:
			System.out.println("Repostajes normales: ");
			for(int i = 0; i < listaRepos.size(); i++) {
				if(listaRepos.get(i).getDni() == null && listaRepos.get(i).getMatricula() == null)
					System.out.println(i+1 + ". " + listaRepos.get(i).toString());
			}
			break;
		case 2:
			System.out.println("Repostajes con factura: ");
			for(int i = 0; i < listaRepos.size(); i++) {
			if(listaRepos.get(i).getDni() != null && listaRepos.get(i).getMatricula() != null)
				System.out.println(i+1 + ". " + listaRepos.get(i).toString());
			}
			break;
		case 3:
			System.out.println("Repostajes: ");
			for (int i = 0; i < listaRepos.size(); i++) {
				System.out.println(i + 1 + ". " + listaRepos.get(i).toString());
			}
			break;
		}
	}
	
	public ArrayList<Repostaje> BorrarRepostaje(ArrayList<Repostaje> listaRepos){
		Scanner sc = new Scanner(System.in);
		
		if(listaRepos.size() != 0) {
			int registro = CapturaOpcion("Introduce que repostaje deseas borrar",1, listaRepos.size()) - 1;
			listaRepos.remove(registro);
			System.out.println("Repostaje borrado exitosamente.");
		}else
			System.out.println("No existen repostajes para borrar.");
		
		return listaRepos;
	}

	public ArrayList<Repostaje> ModificarRepostaje(ArrayList<Repostaje> listaRepos) {
		Scanner sc = new Scanner(System.in);

		if (listaRepos.size() != 0) {
			
			int registro = CapturaOpcion("Introduce que repostaje deseas modificar", 1, listaRepos.size()) - 1;
			
			System.out.println("\nCampos: ");
			System.out.println("1. Fecha");
			System.out.println("2. Litros");
			System.out.println("3. Importe");
			System.out.println("4. DNI");
			System.out.println("5. Matrícula");
			System.out.println("6. No hacer cambios");

			int campo = CapturaOpcion("\nIntroduce el campo que deseas modificar", 1, 6);

			if (campo != 6)
				System.out.print("Introduce el nuevo valor: ");
			switch (campo) {
			case 1:
				listaRepos.get(registro).setFecha(sc.next());
				break;
			case 2:
				listaRepos.get(registro).setLitros(sc.nextFloat());
				break;
			case 3:
				listaRepos.get(registro).setImporte(sc.nextFloat());
				break;
			case 4:
				listaRepos.get(registro).setDni(sc.next());
				break;
			case 5:
				listaRepos.get(registro).setMatricula(sc.next());
				break;
			default:
				break;
			}
			if (campo != 6)
				System.out.println("Repostaje modificado exitosamente.");
		} else
			System.out.println("No existen repostajes para modificar.");
		return listaRepos;
	}

	public int CapturaOpcion(String mensaje, int min, int max) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(mensaje + " (" + min + ".." + max + "): ");
		int opcion = sc.nextInt();
		
		while (opcion < min || opcion > max) {
			System.out.println("No has introducido una opción válida.");
			System.out.print("Vuelve a introducir una opción" + " (" + min + ".." + max + "): ");
			opcion = sc.nextInt();
		}
		return opcion;
	}
}
