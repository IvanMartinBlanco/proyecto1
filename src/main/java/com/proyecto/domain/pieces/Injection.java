package com.proyecto.domain.pieces;

/**
 * Clase que crea objetos inyección.
 * 
 * @author Iván Martín Blanco
 *
 */
public class Injection {
	
	int number;
	boolean sequential;
	
	/**
	 * Constructor que crea una inyección sin parámetros.
	 */
	public Injection() {
		number=8;
		sequential=true;
		
	}
	
	/**
	 * Constructor que crea una inyección con parámetros.
	 * 
	 * @param number de inyectores.
	 * @param sequential si es secuencial o no.
	 */
	public Injection(int number, boolean sequential) {
		this.number = number;
		this.sequential = sequential;
	}

	/**
	 * Método que devuelve el número de inyectores.
	 * 
	 * @return número de inyectores.
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Método que cambia el número de inyectores.
	 * 
	 * @param number que va a tener de inyectores.
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Método que devuelve si los inyectores son secuenciales.
	 * 
	 * @return true o false.
	 */
	public boolean isSequential() {
		return sequential;
	}

	/**
	 * Método que modifica si los inyectores son secuenciales.
	 * 
	 * @param sequential valor sobre si es o no secuencial.
	 */
	public void setSequential(boolean sequential) {
		this.sequential = sequential;
	}

	/**
	 * Método que devuelve los datos de los inyectores.
	 */
	@Override
	public String toString() {
		return "Injection [number=" + number + ", sequential=" + sequential + "]";
	}
	
	
	
	

}
