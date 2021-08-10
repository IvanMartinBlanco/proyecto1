package com.proyecto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.proyecto.domain.Electric;
import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.EngineBattery;
import com.proyecto.domain.pieces.Tire;

/**
 * Servicio para gestionar los datos de los vehículos eléctricos.
 * 
 * @author Iván Martín Blanco
 */
@Service
public class ElectricServiceImpl implements ElectricService {

	private Map<Long, Electric> vehiculosElectricos = new HashMap<>();
	
	/**
	 * Constructor sin parámetros.
	 */
	public ElectricServiceImpl() {
		/**
		 * Base de datos emulada
		 */
		
		Electric coche4 = new Electric(2L, "Toyota", new Tire("Michelin", 2.5F), new Battery(2L, 8),
				new Bodywork("Azul", 5), new Engine(2L, true, 120), new Air(50L, true), new EngineBattery(150L));

		Electric coche5 = new Electric(5L, "Ford", new Tire("Mihcelin", 2.5F), new Battery(2L, 8),
				new Bodywork("Naranja", 5), new Engine(2L, true, 120), new Air(50L, true), new EngineBattery(150L));

		Electric coche6 = new Electric(7L, "Seat", new Tire("Mihcelin", 2.5F), new Battery(2L, 8),
				new Bodywork("Amarillo", 5), new Engine(2L, true, 120), new Air(50L, true), new EngineBattery(150L));

		vehiculosElectricos.put(1L, coche4);
		vehiculosElectricos.put(2L, coche5);
		vehiculosElectricos.put(3L, coche6);
		
	}


	/**
	 * Método para recuperar el número de vehículos eléctricos.
	 * 
	 * @return cantidad de vehículos eléctricos.
	 */
	@Override
	public Integer count() {
		return vehiculosElectricos.keySet().size();
	}

	/**
	 * Método que sirve para encontrar todos los vehículos eléctricos.
	 * 
	 * @return lista de vehículos eléctricos.
	 */
	@Override
	public List<Electric> findAll() {
		return new ArrayList<>(vehiculosElectricos.values());
	}

	/**
	 * Método que sirve para encontrar los vehículos eléctricos que tengan un número
	 * de puertas concreto.
	 * 
	 * @param door número de puertas solicitado.
	 * @return lista de vehículos con ese número de puertas.
	 */
	@Override
	public List<Electric> findDoor(int door) {
		ArrayList<Electric> vehicleList = new ArrayList<>();
		for (Map.Entry<Long, Electric> entry : vehiculosElectricos.entrySet()) {
			if (entry.getValue().getBodywork().getPuertas() == door) {
				vehicleList.add(entry.getValue());
			}
		}
		return vehicleList;
	}

	/**
	 * Método que sirve para encontrar los vehículos eléctricos que tengan un color
	 * concreto.
	 * 
	 * @param color solicitado.
	 * @return lista de vehículos con ese color.
	 */
	@Override
	public List<Electric> findColor(String color) {
		ArrayList<Electric> vehicleList = new ArrayList<>();
		for (Map.Entry<Long, Electric> entry : vehiculosElectricos.entrySet()) {
			if (entry.getValue().getBodywork().getColor().equals(color)) {
				vehicleList.add(entry.getValue());
			}
		}
		return vehicleList;
	}

	/**
	 * Método que sirve para encontrar los vehículos eléctricos que tengan un nombre
	 * concreto.
	 * 
	 * @param name que tiene que tener el vehículo.
	 * @return lista de vehículos con ese nombre.
	 */
	@Override
	public List<Electric> findName(String name) {
		ArrayList<Electric> vehicleList = new ArrayList<>();
		for (Map.Entry<Long, Electric> entry : vehiculosElectricos.entrySet()) {
			if (entry.getValue().getModel().equals(name)) {
				vehicleList.add(entry.getValue());
			}
		}
		return vehicleList;
	}

	/**
	 * Método para guardar nuevos vehículos.
	 * 
	 * @param electrico que hay que guardar.
	 * @return vehículo eléctrico guardado.
	 */
	@Override
	public Electric save(Electric electrico) {

		if (electrico.getId() == null || electrico.getId() == 0L)
			electrico.setId(getMaxElectricId() + 1);

		vehiculosElectricos.remove(electrico.getId());

		vehiculosElectricos.put(electrico.getId(), electrico);
		return electrico;
	}

	/**
	 * Devuelve el id más alto del mapa vehiculosElectricos
	 * 
	 * @return número de id más alto.
	 */
	private Long getMaxElectricId() {
		if (vehiculosElectricos.isEmpty())
			return 0L;

		return Collections
				.max(vehiculosElectricos.entrySet(), (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey()))
				.getKey();
	}

	/**
	 * Método que borra un vehículo eléctrico por id.
	 * 
	 * @param id del vehículo que hay que borrar.
	 * @return mensaje sobre si se ha borrado o no.
	 */
	@Override
	public boolean delete(Long id) {
		if (id == null || !vehiculosElectricos.containsKey(id))
			return false;
		vehiculosElectricos.remove(id);
		return true;
	}

	/**
	 * Método que borra todos los vehículos eléctricos.
	 */
	@Override
	public void deleteAll() {
		if (!vehiculosElectricos.isEmpty())
			vehiculosElectricos.clear();
	}

}
