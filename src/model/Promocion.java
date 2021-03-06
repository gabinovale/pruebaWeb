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
import javax.persistence.Table;

@Entity
@Table(name="promocion")
public class Promocion {

	public Promocion() {

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
	
	@ManyToOne
	@JoinColumn(name="tipo_promo_id")
	private TipoPromo tipoPromo;

	@Column(name = "disponible")
	private int disponible;
	
	
    @JoinTable(
        name = "promocion_atraccion", 
        joinColumns = @JoinColumn(name = "promocion_id ", nullable = false), 
        inverseJoinColumns = @JoinColumn(name = "atraccion_id", nullable = false)
    )
    @ManyToMany(cascade = { CascadeType.ALL })
	private List<Atraccion> atracciones;
	
	

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

	public TipoPromo getTipoPromo() {
		return tipoPromo;
	}

	public void setTipoPromo(TipoPromo tipoPromo) {
		this.tipoPromo = tipoPromo;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}
	
	

}
