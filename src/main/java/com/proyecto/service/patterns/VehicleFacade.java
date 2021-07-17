package com.proyecto.service.patterns;

import com.proyecto.domain.Combustion;
import com.proyecto.domain.Electric;
import com.proyecto.domain.Hybrid;
import com.proyecto.domain.Vehicle;
import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.EngineBattery;
import com.proyecto.domain.pieces.GasTank;
import com.proyecto.domain.pieces.HydrogenTank;
import com.proyecto.domain.pieces.Injection;
import com.proyecto.domain.pieces.Tire;

/**
 * Clase fachada para crear los objetos complejos y arrancar su funcionamiento.
 * 
 * @author Iván Martín Blanco
 *
 */
public class VehicleFacade {

	/**
	 * Constructor que crea una fachada sin parámetros.
	 */
	private VehicleFacade() {
	}

	/**
	 * Constructor que crea un coche de combustión con parámetros.
	 * 
	 * @return coche eléctrico.
	 */
	public static Vehicle createElectric() {

		String model = "Default Electric";
		Tire tire = new Tire();
		Battery battery = new Battery(1L, 12);
		Bodywork bodywork = new Bodywork();
		Engine engine = new Engine();
		Air air = new Air();
		EngineBattery engineBattery = new EngineBattery();
		Vehicle electrico = new Electric(1L, model, tire, battery, bodywork, engine, air, engineBattery);

		// Arrancado del vehículo
		air.setOn(true);
		engine.setOn(true);
		battery.setOn(true);
		electrico.setStarted(true);

		return electrico;
	}

	/**
	 * Constructor que crea un coche de combustión con parámetros.
	 * 
	 * @return coche de combustión.
	 */
	public static Vehicle createCombustion() {
		String model = "Default Combustion";
		Tire tire = new Tire();
		Battery battery = new Battery(1L, 12);
		Bodywork bodywork = new Bodywork();
		Engine engine = new Engine();
		Air air = new Air();
		GasTank gasTank = new GasTank();
		Injection injection = new Injection();

		Vehicle combustion = new Combustion(2L, model, tire, battery, bodywork, engine, air, injection, gasTank);

		// Arrancado del vehículo
		air.setOn(true);
		engine.setOn(true);
		battery.setOn(true);
		combustion.setStarted(true);

		return combustion;
	}

	/**
	 * Constructor que crea un coche híbrido con parámetros.
	 * 
	 * @return coche híbrido.
	 */
	public static Vehicle createHybrid() {
		String model = "Default Hybrid";
		Tire tire = new Tire();
		Battery battery = new Battery(1L, 12);
		Bodywork bodywork = new Bodywork();
		Engine engine = new Engine();
		Air air = new Air();
		HydrogenTank tanque = new HydrogenTank();

		Vehicle hybrid = new Hybrid(1L, model, tire, battery, bodywork, engine, air, tanque);

		// Arrancado del vehículo
		air.setOn(true);
		engine.setOn(true);
		battery.setOn(true);
		hybrid.setStarted(true);

		return hybrid;
	}
}
