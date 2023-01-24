package clase.dto;

public class cuenta {

	public static void main(String[] args) {
		CuentaCorriente miCuenta = new CuentaCorriente();
		miCuenta.crearCuenta("237847289F", "Raúl Cordero");
		miCuenta.ingresarDinero(500);
		miCuenta.sacarDinero(600);
		miCuenta.sacarDinero(200);
		miCuenta.mostrarInfo();
		
	}

}
