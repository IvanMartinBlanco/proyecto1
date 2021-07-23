package com.proyecto.domain;

import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.EngineBattery;
import com.proyecto.domain.pieces.Tire;

/**
 * Clase que crea objetos coches eléctricos.
 * 
 * @author Iván Martín Blanco
 *
 */
public class Electric extends Vehicle {

	private EngineBattery engineBattery;

	/**
	 * Constructor que crea un coche eléctricos sin parámetros.
	 */
	public Electric() {
	}

	/**
	 * Constructor que crea un coche eléctricos con parámetros.
	 * 
	 * @param id            del coche eléctrico.
	 * @param model         del coche eléctrico.
	 * @param tire          del coche eléctrico.
	 * @param battery       del coche eléctrico.
	 * @param bodywork      del coche eléctrico.
	 * @param engine        del coche eléctrico.
	 * @param air           del coche eléctrico.
	 * @param engineBattery del coche eléctrico.
	 */
	public Electric(Long id, String model, Tire tire, Battery battery, Bodywork bodywork, Engine engine, Air air,
			EngineBattery engineBattery) {
		super(id, model, tire, battery, bodywork, engine, air);
		this.engineBattery = engineBattery;
	}

	/**
	 * Método que devuelve la batería de motor del coche.
	 * 
	 * @return batería del motor.
	 */
	public EngineBattery getEngineBattery() {
		return engineBattery;
	}

	/**
	 * Método que modifica la batería de motor del coche.
	 * 
	 * @param engineBattery que va a tener el coche.
	 */
	public void setEngineBattery(EngineBattery engineBattery) {
		this.engineBattery = engineBattery;
	}

	/**
	 * Método que devuelve los datos del coche eléctrico.
	 */
	@Override
	public String toString() {
		return "Electric [engineBattery=" + engineBattery + ", toString()=" + super.toString() + "]";
	}

}
