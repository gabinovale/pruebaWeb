package model;

import java.util.HashSet;
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
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "promocion_atraccion", 
        joinColumns = { @JoinColumn(name = "atraccion_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "promocion_id") }
    )
    Set<Promocion> promociones = new HashSet<>();

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

	public Set<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Set<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
}
