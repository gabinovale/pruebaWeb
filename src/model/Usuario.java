package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	public Usuario() { }
	
	@Id
	private int id;
	
	@Column(name = "nombre")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_admin")
	private int admin;
	
	@Column(name = "presupuesto")
	private int presupuesto;
	
	@Column(name = "tiempo")
	private double tiempo;
	
	@ManyToOne
	@JoinColumn(name="preferencia_id")
	private TipoDeAtraccion preferencia;
	
	@OneToMany(mappedBy="usuario")
	private List<Itinerario> itinerarios;
	
	@OneToMany(mappedBy="usuario")
	private List<Compra> compras;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public TipoDeAtraccion getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(TipoDeAtraccion tipoAtraccion) {
		this.preferencia = tipoAtraccion;
	}

	public List<Itinerario> getItinerarios() {
		return itinerarios;
	}

	public void setItinerarios(List<Itinerario> itinerarios) {
		this.itinerarios = itinerarios;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	
	
	
}
