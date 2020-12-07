package entities;

/**
 * 
 * Clase de personas o clientes
 *
 */
public class Persona {
	private String adicional1_cliente;
	private String direccion;
	private String id;
	private char tipo;
	private String razon_social;
	private String ruc;
	private String email;
	private String adicional2_cliente;
	private String adicional3_cliente;
	private String telefonos;
	private String cedula;

	public Persona() {
		super();
	}

	//Getter and Setter
	public String getAdicional1_cliente() {
		return adicional1_cliente;
	}

	public void setAdicional1_cliente(String adicional1_cliente) {
		this.adicional1_cliente = adicional1_cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdicional2_cliente() {
		return adicional2_cliente;
	}

	public void setAdicional2_cliente(String adicional2_cliente) {
		this.adicional2_cliente = adicional2_cliente;
	}

	public String getAdicional3_cliente() {
		return adicional3_cliente;
	}

	public void setAdicional3_cliente(String adicional3_cliente) {
		this.adicional3_cliente = adicional3_cliente;
	}

	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}	
	
}
