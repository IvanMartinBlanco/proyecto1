package com.proyecto.domain.pieces;

/**
 * Clase que crea objetos motor.
 * 
 * @author Iván Martín Blanco
 *
 */
public class Engine {

	Long id;
	Boolean on = true;
	Integer power;

	/**
	 * Constructor que crea un motor sin parámetros.
	 */
	public Engine() {
		on = true;
		power = 120;
	}

	/**
	 * Constructor que crea un motor con parámetros.
	 * 
	 * @param id    del motor.
	 * @param on    sí el motor está o no encendido.
	 * @param power de la batería.
	 */
	public Engine(Long id, Boolean on, Integer power) {
		this.id = id;
		this.on = on;
		this.power = power;
	}

	/**
	 * Método que devuelve el id del motor.
	 * 
	 * @return id del motor.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que modifica el id del motor.
	 * 
	 * @param id que va a tener el motor.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que devuelve si el motor está encendido o no.
	 * 
	 * @return true o false.
	 */
	public Boolean getOn() {
		return on;
	}

	/**
	 * Método que modifica si está encendido el motor.
	 * 
	 * @param on valor sobre si está o no encendido.
	 */
	public void setOn(Boolean on) {
		this.on = on;
	}

	/**
	 * Método que devuelve la potencia del motor.
	 * 
	 * @return potencia del motor.
	 */
	public Integer getPower() {
		return power;
	}

	/**
	 * Método que modifica la potencia del motor.
	 * 
	 * @param power que va a tener el motor.
	 */
	public void setPower(Integer power) {
		this.power = power;
	}

	/**
	 * Método que devuelve los datos del motor.
	 */
	@Override
	public String toString() {
		return "Engine [id=" + id + ", on=" + on + ", power=" + power + "]";
	}

}
