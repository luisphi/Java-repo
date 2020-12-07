package entities;

/**
 * 
 * Clase detalle de un documento FACTURA
 *
 */
public class Detalle {
	private Double porcentaje_iva;
	private Double cantidad;
	private Double base_no_gravable;
	private Double precio;
	private String producto_id;
	private Double base_cero;
	private Double base_gravable;
	
	public Detalle() {
		super();
	}

	public Double getPorcentaje_iva() {
		return porcentaje_iva;
	}

	public void setPorcentaje_iva(Double porcentaje_iva) {
		this.porcentaje_iva = porcentaje_iva;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getBase_no_gravable() {
		return base_no_gravable;
	}

	public void setBase_no_gravable(Double base_no_gravable) {
		this.base_no_gravable = base_no_gravable;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(String producto_id) {
		this.producto_id = producto_id;
	}

	public Double getBase_cero() {
		return base_cero;
	}

	public void setBase_cero(Double base_cero) {
		this.base_cero = base_cero;
	}

	public Double getBase_gravable() {
		return base_gravable;
	}

	public void setBase_gravable(Double base_gravable) {
		this.base_gravable = base_gravable;
	}
	
}
