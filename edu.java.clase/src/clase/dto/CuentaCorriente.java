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

	public CuentaCorriente crearCuenta(String dni, String nombreTitular) {
		//1 forma
		CuentaCorriente cc = new CuentaCorriente(dni,nombreTitular);
		//2 forma
		CuentaCorriente ccc = new CuentaCorriente();
		ccc.setDni(dni);
		ccc.setNombreTitular(nombreTitular);
		ccc.setSaldo(0.0);
		return ccc;
	}

	public void mostrarInfo() {
		System.out.println("Datos");
		System.out.println("----------");
		System.out.println("Nombre: " + nombreTitular);
		System.out.println("DNI: " + dni);
		System.out.println("Saldo: " + saldo + "$");
	}

	public void ingresarDinero(double ingreso) {
		saldo = saldo + ingreso;
	}

	public ArrayList<CuentaCorriente> ingresoCuenta(ArrayList<CuentaCorriente> listaCuentas) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca su DNI:");
		String dni = sc.next();

		int cont = 0;
		for (CuentaCorriente cuenta : listaCuentas) {
			if (cuenta.getDni().equals(dni)) {
				System.out.print("Introduzca la cantidad a ingresar: ");
				double ingreso = sc.nextDouble();
				double saldoActual = listaCuentas.get(cont).getSaldo();
				double saldoNuevo = listaCuentas.get(cont).getSaldo() + ingreso;
				listaCuentas.get(cont).setSaldo(saldoNuevo);
				System.out.println("Saldo anterior: " + saldoActual + "Saldo nuevo" + saldoNuevo);
				break;
			} else {
				System.out.println("No existe cuenta para el dni indicado.");
			}
			cont++;
		}
		sc.close();
		return listaCuentas;
	}
	
	public void retirarDinero(double retirada) {
		if (saldo >= retirada)
			saldo = saldo - retirada;
	}

	public ArrayList<CuentaCorriente> mostrarCuentasUsuario(String dni) {
		return null;
	}

}