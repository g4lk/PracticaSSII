package PracticaURJC.SSII;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="servicio")
public class Servicio {
	
	private int id;
	private String nombre, categoria, descripcion;
	private Double horas, precioxhora;
	private Usuario profesional;
	private List<Solicitud> solicitudes;
	
	public Servicio() {}
	
	public Servicio(String nombre, String categoria, String descripcion, Double horas, Double precioxhora,
			Usuario profesional) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.horas = horas;
		this.precioxhora = precioxhora;
		this.profesional = profesional;
	}
	@ManyToOne
	@JoinColumn(name = "profesional_id")
	public Usuario getProfesional() {
		return profesional;
	}

	public void setProfesional(Usuario profesional) {
		this.profesional = profesional;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
		this.horas = horas;
	}

	public Double getPrecioxhora() {
		return precioxhora;
	}

	public void setPrecioxhora(Double precioxhora) {
		this.precioxhora = precioxhora;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
	@OneToMany(mappedBy= "servicio", cascade = CascadeType.ALL)
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
}
