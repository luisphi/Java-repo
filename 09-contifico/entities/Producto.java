package entities;

/**
 * 
 * Clase para manejo de productos
 *
 */
public class Producto {
	private String codigo_barra;
	private Boolean para_pos;
	private Double porcentaje_iva;
	private String personalizado1;
	private String imagen;
	private String tipo;
	private String categoria_id;
	private String personalizado2;
	private String marca_id;
	private Double minimo;
	private String tipo_producto;
	private Double pvp3;
	private Double pvp1;
	private Boolean pvp_manual;
	private Double pvp2;
	private String descripcion;
	private String nombre;
	private String codigo;
	private char estado;
	private String id;
	private int cantidad_stock;
    
	public Producto() {
		super();
	}

	//Getter and Setter
	public String getCodigo_barra() {
		return codigo_barra;
	}

	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
	}

	public Boolean getPara_pos() {
		return para_pos;
	}

	public void setPara_pos(Boolean para_pos) {
		this.para_pos = para_pos;
	}

	public Double getPorcentaje_iva() {
		return porcentaje_iva;
	}

	public void setPorcentaje_iva(Double porcentaje_iva) {
		this.porcentaje_iva = porcentaje_iva;
	}

	public String getPersonalizado1() {
		return personalizado1;
	}

	public void setPersonalizado1(String personalizado1) {
		this.personalizado1 = personalizado1;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(String categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getPersonalizado2() {
		return personalizado2;
	}

	public void setPersonalizado2(String personalizado2) {
		this.personalizado2 = personalizado2;
	}

	public String getMarca_id() {
		return marca_id;
	}

	public void setMarca_id(String marca_id) {
		this.marca_id = marca_id;
	}

	public Double getMinimo() {
		return minimo;
	}

	public void setMinimo(Double minimo) {
		this.minimo = minimo;
	}

	public String getTipo_producto() {
		return tipo_producto;
	}

	public void setTipo_producto(String tipo_producto) {
		this.tipo_producto = tipo_producto;
	}

	public Double getPvp3() {
		return pvp3;
	}

	public void setPvp3(Double pvp3) {
		this.pvp3 = pvp3;
	}

	public Double getPvp1() {
		return pvp1;
	}

	public void setPvp1(Double pvp1) {
		this.pvp1 = pvp1;
	}

	public Boolean getPvp_manual() {
		return pvp_manual;
	}

	public void setPvp_manual(Boolean pvp_manual) {
		this.pvp_manual = pvp_manual;
	}

	public Double getPvp2() {
		return pvp2;
	}

	public void setPvp2(Double pvp2) {
		this.pvp2 = pvp2;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantidad_stock() {
		return cantidad_stock;
	}

	public void setCantidad_stock(int cantidad_stock) {
		this.cantidad_stock = cantidad_stock;
	}    
}
