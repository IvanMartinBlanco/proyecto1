package com.proyecto.domain;

import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.HydrogenTank;
import com.proyecto.domain.pieces.Tire;

/**
 * Clase que crea objetos coches híbridos.
 * 
 * @author Iván Martín Blanco
 *
 */
public class Hybrid extends Vehicle {

	private HydrogenTank hydrogenTank;

	/**
	 * Constructor que crea un coche híbrido sin parámetros.
	 */
	public Hybrid() {
	}

	/**
	 * Constructor que crea un coche híbrido con parámetros.
	 * 
	 * @param id           del coche híbrido.
	 * @param model        del coche híbrido.
	 * @param tire         del coche híbrido.
	 * @param battery      del coche híbrido.
	 * @param bodywork     del coche híbrido.
	 * @param engine       del coche híbrido.
	 * @param air          del coche híbrido.
	 * @param hydrogenTank del coche híbrido.
	 */
	public Hybrid(Long id, String model, Tire tire, Battery battery, Bodywork bodywork, Engine engine, Air air,
			HydrogenTank hydrogenTank) {
		super(id, model, tire, battery, bodywork, engine, air);
		this.hydrogenTank = hydrogenTank;
	}

	/**
	 * Método que devuelve el tanque de hidrógeno.
	 * 
	 * @return tanque de hidrógeno.
	 */
	public HydrogenTank getHydrogenTank() {
		return hydrogenTank;
	}

	/**
	 * Método que modifica el tanque de hidrógeno.
	 * 
	 * @param hydrogenTank que va a tener el coche.
	 */
	public void setHydrogenTank(HydrogenTank hydrogenTank) {
		this.hydrogenTank = hydrogenTank;
	}

	/**
	 * Método que devuelve los datos del coche híbrido.
	 */
	@Override
	public String toString() {
		return "Hybrid [hydrogenTank=" + hydrogenTank + ", toString()=" + super.toString() + "]";
	}

}
