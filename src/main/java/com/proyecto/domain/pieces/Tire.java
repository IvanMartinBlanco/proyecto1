package com.proyecto.domain.pieces;

/**
 * Clase que crea objetos neumático.
 * 
 * @author Iván Martín Blanco
 *
 */
public class Tire {

	String brand;
	Float pressure;

	/**
	 * Constructor que crea un neumático sin parámetros.
	 */
	public Tire() {
		this.brand = "Pirelli";
		this.pressure = 2.5f;
	}

	/**
	 * Constructor que crea un neumático con parámetros.
	 * 
	 * @param brand               del neumático.
	 * @param recommendedPressure de los neumáticos.
	 */
	public Tire(String brand, Float recommendedPressure) {
		this.brand = brand;
		this.pressure = recommendedPressure;
	}

	/**
	 * Método que devuelve la marca de los neumáticos.
	 * 
	 * @return marca de los neumáticos.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Método que modifica la marca de los neumáticos.
	 * 
	 * @param brand que va a tener los neumáticos.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Método que devuelve la presión recomendada de los neumáticos.
	 * 
	 * @return presión de los neumáticos.
	 */
	public Float getPressure() {
		return pressure;
	}

	/**
	 * Método que modifica la presión de los neumáticos.
	 * 
	 * @param pressure que van a tener los neumáticos.
	 */
	public void setPressure(Float pressure) {
		this.pressure = pressure;
	}

	/**
	 * Método que devuelve los datos de los neumáticos.
	 */
	@Override
	public String toString() {
		return "Tire [brand=" + brand + ", pressure=" + pressure + "]";
	}

}
