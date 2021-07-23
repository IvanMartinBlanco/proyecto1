package com.proyecto.domain.pieces;

/**
 * Clase que crea objetos tanque de gasolina.
 * 
 * @author Iván Martín Blanco
 *
 */
public class GasTank {

	Long capacity;

	/**
	 * Constructor que crea un aire sin parámetros.
	 */
	public GasTank() {
		this.capacity = 500L;
	}

	/**
	 * Constructor que crea un aire con parámetros.
	 * 
	 * @param capacity del tanque.
	 */
	public GasTank(Long capacity) {
		this.capacity = capacity;
	}

	/**
	 * Método que devuelve la capacidad del tanque.
	 * 
	 * @return capacidad del tanque.
	 */
	public Long getCapacity() {
		return capacity;
	}

	/**
	 * Método que modifica la capacidad del tanque.
	 * 
	 * @param capacity que va a tener el tanque.
	 */
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	/**
	 * Método que devuelve los datos del tanque de gasolina.
	 */
	@Override
	public String toString() {
		return "HydrogenTank [capacity=" + capacity + "]";
	}

}
