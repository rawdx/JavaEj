package clase.dto;

public class CuentaCorriente {
	
	String dni;
	String nombreTitular;
	double saldoCuenta;
	
	public CuentaCorriente(String dni, String nombreTitular, double saldo) {
		super();
		this.dni = dni;
		this.nombreTitular = nombreTitular;
		this.saldoCuenta = saldo;
	}
	
	public void crearCuenta(String dniCuenta, String nombreTitularCuenta) {
		new CuentaCorriente(dniCuenta, nombreTitularCuenta, 0.0);
	}
	public double ingresarDinero(double saldo, double ingreso) {
		System.out.println("Se ingresarán " + ingreso + "$.");
		return saldo + ingreso;
	}
	public void mostrarInfo(String nombreTitularCuenta, String dni, double saldoCuenta) {
		System.out.println("Nombre: " + nombreTitularCuenta);
		System.out.println("DNI: " + dni);
		System.out.println("saldo: " + saldoCuenta);
	}
	public double sacarDinero(double retirada, double saldo) {
		System.out.println("Se retirarán " + retirada + "$.");
		return saldo - retirada;
	}

}