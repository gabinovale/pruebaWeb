package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private double costo;

	@Column(name = "tiempo")
	private int tiempo;

	@Column(name = "cupo")
	private int cupo;

	@Column(name = "tipo_de_atraccion_id")
	private int tipoAtraccion;

	@Column(name = "disponible")
	private int disponible;

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

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public int getTipoAtraccion() {
		return tipoAtraccion;
	}

	public void setTipoAtraccion(int tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}
	
	
	
}
