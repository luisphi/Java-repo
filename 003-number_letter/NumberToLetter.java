/**
 * @ @author luispazymino
 *
 */

public class NumberToLetter {
	Double doubleNumber;
	static String[] UNIDADES = { "", "UN ", "DOS ", "TRES ", "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ",
			"DIEZ ", "ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS ", "DIECISIETE ", "DIECIOCHO ",
			"DIECINUEVE ", "VEINTE " };
	static String[] DECENAS = { "VEINTE ", "TREINTA ", "CUARENTA ", "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ",
			"NOVENTA ", "CIEN " };
	static String[] CENTENAS = { "CIENTO ", "DOSCIENTOS ", "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ",
			"SEISCIENTOS ", "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS " };

	// Constructor de clase
	public NumberToLetter(Double doubleNumber) {
		super();
		this.doubleNumber = doubleNumber;
	}

	/**
	 * Método general para convertir el número en Letras
	 */
	public void converToLetter() {
		StringBuilder converted = new StringBuilder();
		String ast = "";

		// Validamos que sea un numero legal
		if (doubleNumber > 9999999)
			throw new NumberFormatException("El numero es mayor de 9'999.999, " + "no es posible convertirlo");

		if (doubleNumber < 0)
			throw new NumberFormatException("El numero debe ser positivo");

		String splitNumber[] = String.valueOf(doubleNumber).replace('.', '#').split("#");

		// Descompone el trio de millones
		int millon = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0], 8))
				+ String.valueOf(getDigitAt(splitNumber[0], 7)) + String.valueOf(getDigitAt(splitNumber[0], 6)));
		if (millon == 1)
			converted.append("UN MILLON ");
		else if (millon > 1)
			converted.append("** ").append(convertNumber(String.valueOf(millon))).append("MILLONES ");

		// Descompone el trio de miles
		int miles = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0], 5))
				+ String.valueOf(getDigitAt(splitNumber[0], 4)) + String.valueOf(getDigitAt(splitNumber[0], 3)));
		if (millon >= 1) {
			if (miles == 1)
				converted.append(convertNumber(String.valueOf(miles))).append("MIL ");
			else if (miles > 1)
				converted.append(convertNumber(String.valueOf(miles))).append("MIL ");
		} else {
			if (miles == 1)
				converted.append("** UN MIL ");

			if (miles > 1)
				converted.append("** ").append(convertNumber(String.valueOf(miles))).append("MIL ");
		}

		// Descompone el ultimo trio de unidades
		int cientos = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0], 2))
				+ String.valueOf(getDigitAt(splitNumber[0], 1)) + String.valueOf(getDigitAt(splitNumber[0], 0)));
		if (miles >= 1 || millon >= 1) {
			if (cientos >= 1)
				converted.append(convertNumber(String.valueOf(cientos)));
		} else {
			if (cientos == 1)
				converted.append("**UN ");
			if (cientos > 1)
				converted.append("** ").append(convertNumber(String.valueOf(cientos)));
		}

		if (millon + miles + cientos == 0)
			converted.append("**CERO ");

		// Descompone los centavos
		String valor = splitNumber[1];
		if (valor.length() == 1) {
			converted.append(splitNumber[1]).append("0").append("/100 ");
		} else {
			converted.append(splitNumber[1]).append("/100 ");
		}
		// Agregar asteriscos para llenar la parte blanca del cheque
		if (converted.length() < 80) {
			for (int i = 0; i < (80 - converted.length()) / 2; i++) {
				ast += "* ";
			}
		}
		System.out.println(converted.append(ast).toString());
	}

	/**
	 * Convierte los trios de numeros que componen las unidades, las decenas y las
	 * centenas del numero.
	 * 
	 * @param number
	 *            Numero a convetir en digitos
	 * @return Numero convertido en letras
	 */
	private static String convertNumber(String number) {

		if (number.length() > 3)
			throw new NumberFormatException("La longitud maxima debe ser 3 digitos");

		// Caso especial con el 100
		if (number.equals("100")) {
			return "CIEN ";
		}

		StringBuilder output = new StringBuilder();
		if (getDigitAt(number, 2) != 0)
			output.append(CENTENAS[getDigitAt(number, 2) - 1]);

		int k = Integer.parseInt(String.valueOf(getDigitAt(number, 1)) + String.valueOf(getDigitAt(number, 0)));

		if (k <= 20)
			output.append(UNIDADES[k]);
		else if (k > 20 && getDigitAt(number, 0) != 0)
			output.append(DECENAS[getDigitAt(number, 1) - 2]).append("Y ").append(UNIDADES[getDigitAt(number, 0)]);
		else
			output.append(DECENAS[getDigitAt(number, 1) - 2]).append(UNIDADES[getDigitAt(number, 0)]);

		return output.toString();
	}

	/**
	 * Retorna el digito numerico en la posicion indicada de derecha a izquierda
	 * 
	 * @param origin
	 *            Cadena en la cual se busca el digito
	 * @param position
	 *            Posicion de derecha a izquierda a retornar
	 * @return Digito ubicado en la posicion indicada
	 */
	private static int getDigitAt(String origin, int position) {
		if (origin.length() > position && position >= 0)
			return origin.charAt(origin.length() - position - 1) - 48;
		return 0;
	}

}