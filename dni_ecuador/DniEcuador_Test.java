/**
 * 
 * @author Luis Paz y Miño.
 * @description Llamada a clase para verificación de dni
 */

public class DniEcuador_Test {

	public static void main(String[] args) {
		// Instanciar la clase y llamar al método
		DniEcuador dni = new DniEcuador("1702082833");
		
		System.out.println(dni.validation());
	}

}
