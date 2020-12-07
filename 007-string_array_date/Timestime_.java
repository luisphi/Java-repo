import java.sql.Time;

/**
 * 
 * Pruebas con la librería de Time, obteniendo horas y minutos
 *
 */

public class Timestime_ {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {			
		
		Time tiempo = new Time(1000000);
				
		System.out.println(tiempo);
		System.out.println(tiempo.getHours());
		System.out.println(tiempo.getMinutes());
		System.out.println("El tiempo es: " + (tiempo.getHours() * 60 + tiempo.getMinutes()));
		
	}

}
