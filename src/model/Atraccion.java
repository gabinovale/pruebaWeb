package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="atraccion")
public class Atraccion {
	
	public Atraccion() {
		
	}
	
	@Id
	private int id;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "costo")
	private int costo;

	@Column(name = "tiempo")
	private double tiempo;

	@Column(name = "cupo")
	private int cupo;

	@ManyToOne
	@JoinColumn(name="tipo_de_atraccion_id")
	private TipoDeAtraccion tipoAtraccion;

	@Column(name = "disponible")
	private int disponible;
	
		
	@ManyToMany(mappedBy = "atracciones")
    private List<Promocion> promociones;
	
//	@ManyToMany(mappedBy = "atracciones")
//    private List<Itinerario> itinerarios = new LinkedList<>();
	
	@OneToMany(mappedBy="atraccion")
	private List<Compra> compras;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	

	public TipoDeAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	public void setTipoAtraccion(TipoDeAtraccion tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

//	public List<Itinerario> getItinerarios() {
//		return itinerarios;
//	}
//
//	public void setItinerarios(List<Itinerario> itinerarios) {
//		this.itinerarios = itinerarios;
//	}
	
	
	
}
