package entities;

import java.util.Date;
import java.util.ArrayList;

/**
 * 
 * Clase de documentos FACTURAS
 *
 */
public class Documento {
	private Double iva;
	private Date fecha_vencimiento;
	private Boolean anulado;
	private String descripcion;
	private Double total;
	private String id;
	private String referencia;
	private String autorizacion;
	private String url_ride;
	private Date fecha_creacion;
	private Date fecha_emision;
	private String documento;
	private String adicional1;
	private String adicional2;
	private String url_xml;
	private char estado;
	private String tipo_documento;
	private Boolean electronico;
	private Double subtotal_12;
	private Double subtotal_0;
	
	private ArrayList<Detalle> detalles;
	private Persona persona;
	
	//Constructor Global
	public Documento () {
		super();
	}

	//Getter and setter
	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public Boolean getAnulado() {
		return anulado;
	}

	public void setAnulado(Boolean anulado) {
		this.anulado = anulado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getUrl_ride() {
		return url_ride;
	}

	public void setUrl_ride(String url_ride) {
		this.url_ride = url_ride;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getAdicional1() {
		return adicional1;
	}

	public void setAdicional1(String adicional1) {
		this.adicional1 = adicional1;
	}

	public String getAdicional2() {
		return adicional2;
	}

	public void setAdicional2(String adicional2) {
		this.adicional2 = adicional2;
	}

	public String getUrl_xml() {
		return url_xml;
	}

	public void setUrl_xml(String url_xml) {
		this.url_xml = url_xml;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public Boolean getElectronico() {
		return electronico;
	}

	public void setElectronico(Boolean electronico) {
		this.electronico = electronico;
	}

	public Double getSubtotal_12() {
		return subtotal_12;
	}

	public void setSubtotal_12(Double subtotal_12) {
		this.subtotal_12 = subtotal_12;
	}

	public Double getSubtotal_0() {
		return subtotal_0;
	}

	public void setSubtotal_0(Double subtotal_0) {
		this.subtotal_0 = subtotal_0;
	}

	public ArrayList<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
