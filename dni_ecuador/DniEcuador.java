/**
 * 
 * @author Luis Paz y Miño.
 * @description Regla de validación para DNI (Cédula o RUC) Ecuador.
 */

public class DniEcuador {
	private String cedula;
	//Constructor
	public DniEcuador(String cedula) {
		super();
		this.cedula = cedula;
	}
	
	//Validación del dato ingresado
	protected String validation() {
		int suma = 0;
		int residuo = 0;
		boolean pri = false;
		boolean pub = false;
		boolean nat = false;
		int cedulaProvincias = 24;
		int modulo = 11;
		int p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0, p7 = 0, p8 = 0, p9 = 0;

		// Verificar que la cédula no esté vacia
		if (cedula.isEmpty()) {
			return "La cédula o ruc ingresado no puede ser nulo o dato vacio";
		}
		// Verificar que no tenga letras
		if (!cedula.matches("\\d*")) {
			return "La cédula o ruc ingresado no debe contener letras";
		}
		// Verificar la longitud mínima, máxima y promedio para comparación
		if (cedula.length() < 10) {
			return "La longitud de la cédula ingresada no es válido";
		} else if ((cedula.length() > 10 && cedula.length() < 13) || cedula.length() > 13) {
			return "La longitud del Ruc ingresado no es válido"; 
		}
		/* Verificar que la provincia exista */
		if (Integer.parseInt(cedula.substring(0, 2)) > cedulaProvincias) {
			return "Los dos primeros digitos de la cédula estan incorrectos.";
		}

		/* Aqui almacenamos los digitos de la cedula en variables. */
		int d1 = Integer.parseInt(cedula.substring(0, 1));
		int d2 = Integer.parseInt(cedula.substring(1, 2));
		int d3 = Integer.parseInt(cedula.substring(2, 3));
		int d4 = Integer.parseInt(cedula.substring(3, 4));
		int d5 = Integer.parseInt(cedula.substring(4, 5));
		int d6 = Integer.parseInt(cedula.substring(5, 6));
		int d7 = Integer.parseInt(cedula.substring(6, 7));
		int d8 = Integer.parseInt(cedula.substring(7, 8));
		int d9 = Integer.parseInt(cedula.substring(8, 9));
		int d10 = Integer.parseInt(cedula.substring(9, 10));

		/* El tercer digito es: */
		/* 9 para sociedades privadas y extranjeros */
		/* 6 para sociedades publicas */
		/* menor que 6 (0,1,2,3,4,5) para personas naturales */
		if (d3 == 7 || d3 == 8) {
			return "El tercer dígito ingresado es inválido.";
		}
		/* Solo para personas naturales (modulo 10) */
		if (d3 < 6) {
			nat = true;
			p1 = d1 * 2;
			if (p1 >= 10) p1 -= 9; p2 = d2 * 1;
			if (p2 >= 10) p2 -= 9; p3 = d3 * 2;
			if (p3 >= 10) p3 -= 9; p4 = d4 * 1;
			if (p4 >= 10) p4 -= 9; p5 = d5 * 2;
			if (p5 >= 10) p5 -= 9; p6 = d6 * 1;
			if (p6 >= 10) p6 -= 9; p7 = d7 * 2;
			if (p7 >= 10) p7 -= 9; p8 = d8 * 1;
			if (p8 >= 10) p8 -= 9; p9 = d9 * 2;
			if (p9 >= 10) p9 -= 9; modulo = 10;
		} /*
			 * Solo para sociedades publicas (modulo 11) Aqui el digito
			 * verficador esta en la posicion 9, en las otras 2 en la pos. 10
			 */
		else if (d3 == 6) {
			pub = true;
			p1 = d1 * 3;
			p2 = d2 * 2;
			p3 = d3 * 7;
			p4 = d4 * 6;
			p5 = d5 * 5;
			p6 = d6 * 4;
			p7 = d7 * 3;
			p8 = d8 * 2;
			p9 = 0;
		} /* Solo para entidades privadas (modulo 11) */
		else if (d3 == 9) {
			pri = true;
			p1 = d1 * 4;
			p2 = d2 * 3;
			p3 = d3 * 2;
			p4 = d4 * 7;
			p5 = d5 * 6;
			p6 = d6 * 5;
			p7 = d7 * 4;
			p8 = d8 * 3;
			p9 = d9 * 2;
		}
		suma = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
		residuo = suma % modulo;
		/* Si residuo=0, dig.ver.=0, caso contrario 10 - residuo */
		int digitoVerificador = residuo == 0 ? 0 : modulo - residuo;
		/* ahora comparamos el elemento de la posicion 10 con el dig. ver. */
		if (pub == true) {
			if (digitoVerificador != d9) {
				return "El ruc de la empresa del sector público es incorrecto.";
			}
			/* El ruc de las empresas del sector publico terminan con 0001 */
			if (!(cedula.substring(9, cedula.length()).equals("0001"))) {
				return "El ruc de la empresa del sector público debe terminar con 0001.";
			}
		} else if (pri == true) {
			if (digitoVerificador != d10) {
				return "El ruc de la empresa del sector privado es incorrecto.";
			}
			if (!(cedula.substring(10, cedula.length()).equals("001"))) {
				return "El ruc de la empresa del sector privado debe terminar con 001.";
			}
		} else if (nat == true) {
			if (digitoVerificador != d10) {
				return "El número de cédula de la persona natural es incorrecto.";
			}
			if (cedula.length() > 10) {
				if (!(cedula.substring(10, cedula.length()).equals("001"))) {
					return "El ruc de la persona natural debe terminar con 001.";
				}
			}
		}

		return "===>> CORRECTO <<===";
	}
}
