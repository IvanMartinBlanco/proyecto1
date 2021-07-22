package com.proyecto.service.patterns;

import com.proyecto.domain.Vehicle;
import com.proyecto.service.InvalidVehicle;

/**
 * Clase factoría para poder seleccionar el tipo de vehículo que se creará.
 * 
 * @author Iván Martín Blanco
 *
 */
public class VehicleFactory {

	private static final String ELECTRIC = "electric";
	private static final String COMBUSTION = "combustion";
	private static final String HYBRID = "hybrid";

	/**
	 * Constructor que crea una fachada sin parámetros privada, para que no se pueda instanciar.
	 */


	/**
	 * Método que permite seleccionar el tipo de vehículo.
	 * 
	 * @param type de vehículo a crear.
	 * @return vehículo creado.
	 * @throws InvalidVehicle error si el vehículo no es seleccionable.
	 */
	public static Vehicle createByType(String type) throws InvalidVehicle {

		return switch (type) {
		case ELECTRIC -> VehicleFacade.createElectric();
		case COMBUSTION -> VehicleFacade.createCombustion();
		case HYBRID -> VehicleFacade.createHybrid();
		default -> throw new InvalidVehicle("404 Not found");
		};
	}

}

