import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * Suma o resta de años o meses a una fecha. Formateado
 *
 */
public class AddRemoveDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c1 = GregorianCalendar.getInstance();
		Calendar c2 = GregorianCalendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE, d MMMMMM yyyy h:mm:ss a");

		// Suma o resta anos a la fecha actual
		c1.add(Calendar.MONTH, 2);
		c2.add(Calendar.YEAR, -10);

		System.out.println("Fecha Formateada: " + sdf.format(c1.getTime()));
		System.out.println("Fecha Formateada: " + sdf.format(c2.getTime()));
	}

}
