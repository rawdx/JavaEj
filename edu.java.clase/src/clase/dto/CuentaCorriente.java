package clase.dto;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaCorriente {

	// Atributos

	private String dni;
	private String nombreTitular;
	private double saldo;

	// Getters y Setters
	// Utilizados para que clases externas tengan acceso a los atributos.

	// get para obtener el atributo
	public String getDni() {
		return dni;
	}

	// set para modificar el atributo
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Constructores

	// Este constructor se podría utilizar por defecto, 
	// hasta que se cree otro constructor no harí falta ponerlo.
	public CuentaCorriente() {
		super();
	}

	public CuentaCorriente(String dni, String nombreTitular) {
		super();
		this.dni = dni;
		this.nombreTitular = nombreTitular;
		this.saldo = 0.0;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [dni=" + dni + ", nombreTitular=" + nombreTitular + ", saldo=" + saldo + "]";
	}
	
	// Métodos

	public CuentaCorriente crearCuenta() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca su DNI:");
		String dni = sc.next();

		System.out.print("Introduzca su nombre:");
		String nombreTitular = sc.next();
		
		//1 forma
		//CuentaCorriente cc = new CuentaCorriente(dni,nombreTitular);
		//2 forma
		CuentaCorriente ccc = new CuentaCorriente();
		ccc.setDni(dni);
		ccc.setNombreTitular(nombreTitular);
		ccc.setSaldo(0.0);
		return ccc;
	}

	public void mostrarInfo(ArrayList<CuentaCorriente> listaCuentas) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca su DNI:");
		String dni = sc.next();
		boolean encontrado = false;
		for (CuentaCorriente cuenta : listaCuentas) {
			if (cuenta.getDni().equals(dni)) {
				System.out.println(cuenta.toString());
				encontrado = true;
				break;
			}
		}
		if(encontrado == false)
			System.out.println("No existe cuenta para el dni indicado.");
	}

	public ArrayList<CuentaCorriente> ingresoCuenta(ArrayList<CuentaCorriente> listaCuentas) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca su DNI:");
		String dni = sc.next();
		boolean encontrado = false;
		int cont = 0;
		for (CuentaCorriente cuenta : listaCuentas) {
			if (cuenta.getDni().equals(dni)) {
				encontrado = true;
				System.out.print("Introduzca la cantidad a ingresar: ");
				double ingreso = sc.nextDouble();
				double saldoActual = listaCuentas.get(cont).getSaldo();
				double saldoNuevo = listaCuentas.get(cont).getSaldo() + ingreso;
				listaCuentas.get(cont).setSaldo(saldoNuevo);
				System.out.println("Saldo anterior: " + saldoActual + "\nSaldo nuevo: " + saldoNuevo);
				break;
			}
			cont++;
		}
		if(encontrado == false)
			System.out.println("No existe cuenta para el dni indicado.");
		
		return listaCuentas;
	}
	
	public ArrayList<CuentaCorriente> retiroCuenta(ArrayList<CuentaCorriente> listaCuentas) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca su DNI:");
		String dni = sc.next();
		boolean encontrado = false;
		
		int cont = 0;
		for (CuentaCorriente cuenta : listaCuentas) {
			if (cuenta.getDni().equals(dni)) {
				encontrado = true;
				System.out.print("Introduzca la cantidad a retirar: ");
				double retirada = sc.nextDouble();
				double saldoActual = listaCuentas.get(cont).getSaldo();
				double saldoNuevo;
				if(saldoActual >= retirada) {
					saldoNuevo = saldoActual - retirada;
					listaCuentas.get(cont).setSaldo(saldoNuevo);
					System.out.println("Saldo anterior: " + saldoActual + " Saldo nuevo: " + saldoNuevo);
				} else {
					System.out.println("Tu saldo actual es " + saldoActual
							+ "$. No tienes suficientes fondos para retirar " + retirada + "$.");
				}
				break;
			}
			cont++;
		}
		if(encontrado == false)
			System.out.println("No existe cuenta para el dni indicado.");
		return listaCuentas;
	}

}