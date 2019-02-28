package PracticaURJC.SSII;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="solicitud")
public class Solicitud {
	
	private int id;
	private Usuario cliente;
	private Servicio servicio;
	private java.sql.Date fecha_solicitud, fecha_servicio;
	private String direccion;
	private Double importe_cobrado;
	private String estado, descripcion_estado;
	
	public Solicitud() {}
	
	public Solicitud(Usuario cliente, Servicio servicio, Date fecha_solicitud, Date fecha_servicio,
			Double importe_cobrado, String direccion) {
		this.cliente = cliente;
		this.servicio = servicio;
		this.fecha_solicitud = fecha_solicitud;
		this.fecha_servicio = fecha_servicio;
		this.importe_cobrado = importe_cobrado;
		this.estado = "Pendiente";
		this.direccion = direccion;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@ManyToOne
	@JoinColumn(name="cliente_id")
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	@ManyToOne
	@JoinColumn(name = "servicio_id")
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public java.sql.Date getFecha_solicitud() {
		return fecha_solicitud;
	}
	public void setFecha_solicitud(java.sql.Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}
	public java.sql.Date getFecha_servicio() {
		return fecha_servicio;
	}
	public void setFecha_servicio(java.sql.Date fecha_servicio) {
		this.fecha_servicio = fecha_servicio;
	}
	public Double getImporte_cobrado() {
		return importe_cobrado;
	}
	public void setImporte_cobrado(Double importe_cobrado) {
		this.importe_cobrado = importe_cobrado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion_estado() {
		return descripcion_estado;
	}
	public void setDescripcion_estado(String descripcion_estado) {
		this.descripcion_estado = descripcion_estado;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
