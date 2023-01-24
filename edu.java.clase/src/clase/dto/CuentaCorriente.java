package clase.dto;

import java.util.ArrayList;

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

	// Este constructor se podría utilizar por defecto.
	public CuentaCorriente() {
		super();
	}

	public CuentaCorriente(String dni, String nombreTitular) {
		super();
		this.dni = dni;
		this.nombreTitular = nombreTitular;
		this.saldo = 0.0;
	}

	// Métodos

	public void crearCuenta(String dni, String nombreTitular) {
		this.dni = dni;
		this.nombreTitular = nombreTitular;
		this.saldo = 0.0;
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

	public void retirarDinero(double retirada) {
		if (saldo >= retirada)
			saldo = saldo - retirada;
	}

	public ArrayList<CuentaCorriente> mostrarCuentasUsuario(String dni) {
		return null;
	}

}