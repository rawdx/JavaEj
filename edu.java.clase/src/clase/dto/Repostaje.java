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
		return "Repostaje [fecha=" + fecha + ", litros=" + litros + ", importe=" + importe + "$, dni=" + dni
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
	
	public void mostrarRepostajes(ArrayList<Repostaje> listaRepos) {
		
		System.out.println("Repostajes: ");
		for(int i = 0; i < listaRepos.size(); i++) {
			System.out.println(i+1 + ". " + listaRepos.get(i).toString());
		}
	}
}
