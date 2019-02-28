package PracticaURJC.SSII;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario{
    private int id;
    private String name, surname, email, pass, perfil, residence_city;
    private java.sql.Date born_date;
    private List<Solicitud> solicitudes;
    private List<Servicio> servicios;
    
    public Usuario() {}
    public Usuario(String email, String pass, String perfil) {
    	this.email = email;
    	this.pass = pass;
    	this.perfil = perfil;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public java.sql.Date getBorn_date() {
		return born_date;
	}
	public void setBorn_date(java.sql.Date born_date) {
		this.born_date = born_date;
	}
	public String getResidence_city() {
		return residence_city;
	}
	public void setResidence_city(String residence_city) {
		this.residence_city = residence_city;
	}
	@OneToMany( mappedBy="cliente", cascade = CascadeType.ALL)
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	@OneToMany( mappedBy="profesional", cascade = CascadeType.ALL)
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
}
    