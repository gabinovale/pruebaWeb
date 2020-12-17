package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itinerario")
public class Itinerario {

	public Itinerario() {

	}

	@Id
	private int id;
	
	@Column(name = "costo_total")
	private int costoTotal;

	@Column(name = "tiempo_total")
	private double tiempoTotal;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
//	@ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//        name = "itinerario_atraccion", 
//        joinColumns = { @JoinColumn(name = "itinerario_id") }, 
//        inverseJoinColumns = { @JoinColumn(name = "atraccion_id") }
//    )
//	private List<Atraccion> atracciones = new LinkedList<>();
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}

	public double getTiempoTotal() {
		return tiempoTotal;
	}

	public void setTiempoTotal(double tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

//	public List<Atraccion> getAtracciones() {
//		return atracciones;
//	}
//
//	public void setAtracciones(List<Atraccion> atracciones) {
//		this.atracciones = atracciones;
//	}

	
	
	

}
