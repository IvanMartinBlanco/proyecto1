package com.proyecto.domain.pieces;

/**
 * Clase que crea objetos carrocería.
 * 
 * @author Iván Martín Blanco
 *
 */
public class Bodywork {

	String color;
	int puertas;

	/**
	 * Constructor que crea una carrocería sin parámetros.
	 */
	public Bodywork() {
		this.color = "rojo";
		this.puertas = 5;
	}

	/**
	 * Constructor que crea una batería con parámetros.
	 * 
	 * @param color   de la carrocería.
	 * @param puertas que tiene la carrocería.
	 */
	public Bodywork(String color, int puertas) {
		super();
		this.color = color;
		this.puertas = puertas;
	}

	/**
	 * Método que devuelve el color de la carrocería.
	 * 
	 * @return color de la carrocería.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Método que modifica el color de la carrocería.
	 * 
	 * @param color que va a tener la carrocería.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Método que devuelve el número de puertas que tiene la carrocería.
	 * 
	 * @return número de puertas de la carrocería.
	 */
	public int getPuertas() {
		return puertas;
	}

	/**
	 * Método que modifica el número de puertas que tiene la carrocería.
	 * 
	 * @param puertas que va a tener la carrocería.
	 */
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	/**
	 * Método que devuelve los datos de la batería.
	 */
	@Override
	public String toString() {
		return "Bodywork [color=" + color + ", puertas=" + puertas + "]";
	}

}
