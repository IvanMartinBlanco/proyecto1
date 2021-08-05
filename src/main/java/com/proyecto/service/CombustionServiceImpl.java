package com.proyecto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.proyecto.domain.Combustion;
import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.GasTank;
import com.proyecto.domain.pieces.Injection;
import com.proyecto.domain.pieces.Tire;

/**
 * Servicio para gestionar los datos de los vehículos de combustión.
 * 
 * @author Iván Martín Blanco
 */
@Service
public class CombustionServiceImpl implements CombustionService {
	
	private Map<Long, Combustion> vehiculosCombustion = new HashMap<>();
	
	/**
	 * Constructor sin parámetros.
	 */
	public CombustionServiceImpl() {
		/**
		 * Base de datos emulada
		 */
		
			Combustion coche1 = new Combustion(1L, "Mazda", new Tire("Pirelli", 2.5F), new Battery(1L, 8),
					new Bodywork("Blanco", 3), new Engine(1L, true, 120), new Air(50L, true), new Injection(8, true),
					new GasTank());

			Combustion coche2 = new Combustion(2L, "Seat", new Tire("Michelin", 2.5F), new Battery(1L, 8),
					new Bodywork("Gris", 3), new Engine(1L, true, 120), new Air(50L, true), new Injection(8, true),
					new GasTank());

			Combustion coche3 = new Combustion(3L, "Peugeot", new Tire("Michelin", 2.5F), new Battery(1L, 8),
					new Bodywork("Negro", 3), new Engine(1L, true, 120), new Air(50L, true), new Injection(8, true),
					new GasTank());

			vehiculosCombustion.put(1L, coche1);
			vehiculosCombustion.put(2L, coche2);
			vehiculosCombustion.put(3L, coche3);
		
	}



	/**
	 * Método para recuperar el número de vehículos de combustión.
	 * 
	 * @return cantidad de vehículos de combustión.
	 */
	@Override
	public Integer count() {
		return vehiculosCombustion.keySet().size();
	}

	/**
	 * Método que sirve para encontrar todos los vehículos de combustión.
	 * 
	 * @return lista de vehículos de combustión.
	 */
	@Override
	public List<Combustion> findAll() {
		return new ArrayList<>(vehiculosCombustion.values());
	}

	/**
	 * Método que sirve para encontrar los vehículos de combustión que tengan un
	 * número de puertas concreto.
	 * 
	 * @param door número de puertas solicitado.
	 * @return lista de vehículos con ese número de puertas.
	 */
	@Override
	public List<Combustion> findDoor(int door) {
		ArrayList<Combustion> vehicleList = new ArrayList<>();
		for (Map.Entry<Long, Combustion> entry : vehiculosCombustion.entrySet()) {
			if (entry.getValue().getBodywork().getPuertas() == door) {
				vehicleList.add(entry.getValue());
			}
		}
		return vehicleList;
	}

	/**
	 * Método que sirve para encontrar los vehículos de combustión que tengan un
	 * color concreto.
	 * 
	 * @param color solicitado.
	 * @return lista de vehículos con ese color.
	 */
	@Override
	public List<Combustion> findColor(String color) {
		ArrayList<Combustion> vehicleList = new ArrayList<>();
		for (Map.Entry<Long, Combustion> entry : vehiculosCombustion.entrySet()) {
			if (entry.getValue().getBodywork().getColor().equals(color)) {
				vehicleList.add(entry.getValue());
			}
		}
		return vehicleList;
	}

	/**
	 * Método que sirve para encontrar los vehículos de combustión que tengan un
	 * nombre concreto.
	 * 
	 * @param name que tiene que tener el vehículo.
	 * @return lista de vehículos con ese nombre.
	 */
	@Override
	public List<Combustion> findName(String name) {
		ArrayList<Combustion> vehicleList = new ArrayList<>();
		for (Map.Entry<Long, Combustion> entry : vehiculosCombustion.entrySet()) {
			if (entry.getValue().getModel().equals(name)) {
				vehicleList.add(entry.getValue());
			}
		}
		return vehicleList;
	}

	/**
	 * Método para guardar nuevos vehículos.
	 * 
	 * @param car que hay que guardar.
	 * @return vehículo de combustión guardado.
	 */
	@Override
	public Combustion save(Combustion car) {

		// asignar un id
		if (car.getId() == null || car.getId() == 0L) 
			car.setId(getMaxCombustionId() + 1);

		vehiculosCombustion.remove(car.getId());
		vehiculosCombustion.put(car.getId(), car);
		return car;
	}

	/**
	 * Devuelve el id más alto del mapa vehiculosCombustion
	 * 
	 * @return número de id más alto.
	 */
	private Long getMaxCombustionId() {
		if (vehiculosCombustion.isEmpty())
			return 0L;

		return Collections
				.max(vehiculosCombustion.entrySet(), (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey()))
				.getKey();
	}

	/**
	 * Método que borra un vehículo de combustión por id.
	 * 
	 * @param id del vehículo que hay que borrar.
	 * @return mensaje sobre si se ha borrado o no.
	 */
	@Override
	public boolean delete(Long id) {
		if (id == null || !vehiculosCombustion.containsKey(id))
			return false;
		vehiculosCombustion.remove(id);
		return true;
	}

	/**
	 * Método que borra todos los vehículos de combustión.
	 */
	@Override
	public void deleteAll() {
		if (!vehiculosCombustion.isEmpty())
			vehiculosCombustion.clear();
	}

}
