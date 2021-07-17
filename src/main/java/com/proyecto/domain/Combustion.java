package com.proyecto.domain;

import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.GasTank;
import com.proyecto.domain.pieces.Injection;
import com.proyecto.domain.pieces.Tire;

/**
 * Clase que crea objetos coches de combustión.
 * 
 * @author Iván Martín Blanco
 *
 */
public class Combustion extends Vehicle {

	private Injection injection;
	private GasTank gasTank;

	/**
	 * Constructor que crea un coche de combustión sin parámetros.
	 */
	public Combustion() {
	}

	/**
	 * Constructor que crea un coche de combustión con parámetros.
	 * 
	 * @param id        del coche de combustión.
	 * @param model     del coche de combustión.
	 * @param tire      del coche de combustión.
	 * @param battery   del coche de combustión.
	 * @param bodywork  del coche de combustión.
	 * @param engine    del coche de combustión.
	 * @param air       del coche de combustión.
	 * @param injection del coche de combustión.
	 * @param gasTank   del coche de combustión.
	 */
	public Combustion(Long id, String model, Tire tire, Battery battery, Bodywork bodywork, Engine engine, Air air,
			Injection injection, GasTank gasTank) {
		super(id, model, tire, battery, bodywork, engine, air);
		this.injection = injection;
		this.gasTank = gasTank;
	}

	/**
	 * Método que devuelve los inyectores del coche.
	 * 
	 * @return inyectores del coche.
	 */
	public Injection getInjection() {
		return injection;
	}

	/**
	 * Método que modifica los inyectores del coche.
	 * 
	 * @param injection que va a tener el coche.
	 */
	public void setInjection(Injection injection) {
		this.injection = injection;
	}

	/**
	 * Método que devuelve el tanque de gasolina del coche de combustión.
	 * 
	 * @return tanque de gasolina.
	 */
	public GasTank getGasTank() {
		return gasTank;
	}

	/**
	 * Método que modifica el tanque de gasolina del coche de combustión.
	 * 
	 * @param gasTank que va a tener el coche.
	 */
	public void setGasTank(GasTank gasTank) {
		this.gasTank = gasTank;
	}

	/**
	 * Método que devuelve los datos del coche de combustión.
	 */
	@Override
	public String toString() {
		return "Combustion [injection=" + injection + ", gasTank=" + gasTank + ", toString()=" + super.toString() + "]";
	}

}
