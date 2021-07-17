package com.proyecto.domain.pieces;

/**
 * Clase que crea objetos motor de batería.
 * 
 * @author Iván Martín Blanco
 *
 */
public class EngineBattery {

	Long capacity;

	/**
	 * Constructor que crea una batería de motor sin parámetros.
	 */
	public EngineBattery() {
		this.capacity = 500L;
	}

	/**
	 * Constructor que crea una batería de motor con parámetros.
	 * 
	 * @param capacity del motor.
	 */
	public EngineBattery(Long capacity) {
		this.capacity = capacity;
	}

	/**
	 * Método que devuelve la capacidad de la batería de motor.
	 * 
	 * @return capacidad del motor.
	 */
	public Long getCapacity() {
		return capacity;
	}

	/**
	 * Método que modifica la capacidad de la batería.
	 * 
	 * @param capacity que va a tener el batería de motor.
	 */
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	/**
	 * Método que devuelve los datos de la batería de motor.
	 */
	@Override
	public String toString() {
		return "HydrogenTank [capacity=" + capacity + "]";
	}

}
