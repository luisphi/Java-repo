import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Obtener variables entre #, en una cadena de texto
 *
 */
public class SacarTexto {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String mensaje = "PRUEBA. Estimado #cliente#, su transaccion de ha sido efectuada exitosamente por #valor#.";
		int totalParameter = 0;
		List<String> valor = new ArrayList<String>();

		// Verificar los Parámetros que contiene el mensaje
		String[] token = mensaje.split("");
		List<Integer> posiciones = new ArrayList<Integer>();
		for (int i = 0; i < token.length; i++) {
			if (token[i].equalsIgnoreCase("#")) {
				posiciones.add(i);
			}
		}
		int i = 0;
		while (true) {
			if (i >= posiciones.size()) {
				break;
			} else {
				String tmp = RemoveAccent(mensaje.substring(posiciones.get(i) + 1, posiciones.get(++i)).trim());
				totalParameter += tmp.length();
				valor.add(URLEncoder.encode(tmp, "UTF-8"));
				i++;
			}
		}

		System.out.println(valor);
		System.out.println(totalParameter);
		System.out.println(valor.size());

	}

	/* Eliminar caracteres especiales a una cadena de texto */
	private static String RemoveAccent(String input) {
		// Cadena de caracteres original a sustituir.
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		// Cadena de caracteres ASCII que reemplazarán los originales.
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		String output = input;
		for (int i = 0; i < original.length(); i++) {
			// Reemplazamos los caracteres especiales.
			output = output.replace(original.charAt(i), ascii.charAt(i));
		} // for
		return output;
	}// End function
}
