package com.proyecto.domain.pieces;

/**
 * Clase que crea objetos aire acondicionado.
 * 
 * @author Iván Martín Blanco
 *
 */
public class Air {

	Long gas;
	Boolean on = true;

	/**
	 * Constructor que crea un aire sin parámetros.
	 */
	public Air() {
		this.gas = 50L;
	}

	/**
	 * Constructor que crea un aire con parámetros.
	 * 
	 * @param gas que contiene el aire.
	 * @param on  encendido o apagado.
	 */
	public Air(Long gas, Boolean on) {
		this.gas = gas;
		this.on = on;
	}

	/**
	 * Método que devuelve la cantidad de gas que tiene el aire.
	 * 
	 * @return gas que tiene el aire.
	 */
	public Long getGas() {
		return gas;
	}

	/**
	 * Método que modifica la cantidad de gas que tiene el aire.
	 * 
	 * @param gas que va a tener el aire acondicionado.
	 */
	public void setGas(Long gas) {
		this.gas = gas;
	}

	/**
	 * Método que devuelve si el aire está encendido o no.
	 * 
	 * @return true o false.
	 */
	public Boolean getOn() {
		return on;
	}

	/**
	 * Método que modifica si está encendido el aire.
	 * 
	 * @param on valor sobre si está o no encendido.
	 */
	public void setOn(Boolean on) {
		this.on = on;
	}

	/**
	 * Método que devuelve los datos del aire acondicionado.
	 */
	@Override
	public String toString() {
		return "Air [gas=" + gas + ", on=" + on + "]";
	}

}
