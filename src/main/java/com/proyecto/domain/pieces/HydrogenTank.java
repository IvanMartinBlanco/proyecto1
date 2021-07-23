package com.proyecto.domain.pieces;

/**
 * Clase que crea objetos tanque de hidrógeno.
 * 
 * @author Iván Martín Blanco
 *
 */
public class HydrogenTank {

	Long capacity;

	/**
	 * Constructor que crea un tanque de hidrógeno sin parámetros.
	 */
	public HydrogenTank() {
		this.capacity = 500L;
	}

	/**
	 * Constructor que crea un tanque de hidrógeno con parámetros.
	 * 
	 * @param capacity del tanque de hidrógeno.
	 */
	public HydrogenTank(Long capacity) {
		super();
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
	 * @param capacity que tendrá el tanque.
	 */
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	/**
	 * Método que devuelve los datos del tanque de hidrógeno.
	 */
	@Override
	public String toString() {
		return "HydrogenTank [capacity=" + capacity + "]";
	}

}
