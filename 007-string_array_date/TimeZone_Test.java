import java.sql.Time;
import java.util.TimeZone;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * Pruebas con calendarios y zonas horarios para aplicación de reservas
 *
 */
public class TimeZone_Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Time disHora1 = new Time(13, 30, 00);
		Time disHoraF1 = new Time(18, 00, 00);

		Time arrHoraReserva = new Time(13, 31, 00);
		Time arrHoraFReserva = new Time(19, 00, 00);

		if (disHora1.compareTo(arrHoraReserva) <= 0 && disHoraF1.compareTo(arrHoraFReserva) >= 0) {
			System.out.println("Disponible");
		}

		System.out.println(disHora1.compareTo(arrHoraReserva));
		System.out.println(disHoraF1.compareTo(arrHoraFReserva));

		System.out.println("//////");

		Date fecha = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.SUNDAY);
		calendar.setTimeZone(TimeZone.getTimeZone("GMT-4"));
		calendar.setTimeInMillis(fecha.getTime());

		System.out.println(calendar);
		//////

		Calendar cal = Calendar.getInstance();
		// print current time zone
		String name = cal.getTimeZone().getDisplayName();
		System.out.println("Current Time Zone: " + name);

		/////
		TimeZone tz = TimeZone.getTimeZone("GMT-3");
		// set the time zone with the given time zone value and print it
		cal.setTimeZone(tz);
		System.out.println(cal.getTimeZone().getDisplayName());

		/////////
		System.out.println("///////");

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTimeInMillis(fecha.getTime());

		System.out.println(calendar2.getTimeInMillis());

	}

}
