package clase.dto;

public class CuentaCorriente {

	String dni;
	String nombreTitular;
	double saldo;

	public CuentaCorriente() {
		super();
	}

	public void crearCuenta(String dni, String nombreTitular) {
		this.dni = dni;
		this.nombreTitular = nombreTitular;
		this.saldo = 0.0;
	}

	public void mostrarInfo() {

		if (nombreTitular != null && dni != null) {
			System.out.println("Nombre: " + nombreTitular);
			System.out.println("DNI: " + dni);
			System.out.println("saldo: " + saldo);
		}
	}

	public void ingresarDinero(double ingreso) {
		if (nombreTitular != null && dni != null) {
			System.out.println("Se ingresarán " + ingreso + "$.");
			saldo = saldo + ingreso;
		}
	}

	public void sacarDinero(double retirada) {
		if (nombreTitular != null && dni != null) {
			if (saldo > retirada) {
				System.out.println("Se retirarán " + retirada + "$.");
				saldo = saldo - retirada;
			} else
				System.out.println("Tu saldo actual es " + saldo + "$. No tienes suficientes fondos para retirar "
						+ retirada + "$.");
		}

	}

}