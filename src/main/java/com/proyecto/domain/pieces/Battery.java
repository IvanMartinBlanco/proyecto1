package com.proyecto.domain.pieces;

/**
 * Clase que crea objetos batería.
 * 
 * @author Iván Martín Blanco
 *
 */
public class Battery {

	Long id;
	Boolean on = true;
	Integer capacity;

	/**
	 * Constructor que crea una batería sin parámetros.
	 */
	public Battery() {
	}

	/**
	 * Constructor que crea una batería con parámetros.
	 * 
	 * @param id       de la batería.
	 * @param capacity que tiene la batería.
	 */
	public Battery(Long id, Integer capacity) {
		this.id = id;
		this.capacity = capacity;
	}

	/**
	 * Método que devuelve el id de la batería.
	 * 
	 * @return id de la batería.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que modifica el id de la batería.
	 * 
	 * @param id que va a tener la batería.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que devuelve si la batería está encendida o no.
	 * 
	 * @return true o false.
	 */
	public Boolean getOn() {
		return on;
	}

	/**
	 * Método que modifica si está encendida la batería.
	 * 
	 * @param on valor sobre si está o no encendida.
	 */
	public void setOn(Boolean on) {
		this.on = on;
	}

	/**
	 * Método que devuelve la cantidad de batería posible.
	 * 
	 * @return cantidad de batería.
	 */
	public Integer getCapacity() {
		return capacity;
	}

	/**
	 * Método que modifica la capacidad de la batería.
	 * 
	 * @param capacity de la batería.
	 */
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	/**
	 * Método que devuelve los datos de la batería.
	 */
	@Override
	public String toString() {
		return "Battery [id=" + id + ", on=" + on + ", capacity=" + capacity + "]";
	}

}
