package com.proyecto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.proyecto.domain.Hybrid;
import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;

import com.proyecto.domain.pieces.HydrogenTank;

import com.proyecto.domain.pieces.Tire;

/**
 * Servicio para gestionar los datos de los vehículos híbridos.
 * 
 * @author Iván Martín Blanco
 */
@Service
public class HybridServiceImpl implements HybridService {


	private Map<Long, Hybrid> vehiculosHibridos = new HashMap<>();

	/**
	 * Constructor sin parámetros.
	 */
	public HybridServiceImpl() {
		/**
		 * Base de datos emulada
		 */
		
		Hybrid coche1 = new Hybrid(2L, "Tesla", new Tire("Michelin", 2.5F), new Battery(2L, 8), new Bodywork("Azul", 5),
				new Engine(2L, true, 120), new Air(50L, true), new HydrogenTank(150L));

		Hybrid coche2 = new Hybrid(5L, "Ferrari", new Tire("Mihcelin", 2.5F), new Battery(2L, 8),
				new Bodywork("Rojo", 5), new Engine(2L, true, 120), new Air(50L, true), new HydrogenTank(150L));

		Hybrid coche3 = new Hybrid(7L, "Toyota", new Tire("Mihcelin", 2.5F), new Battery(2L, 8),
				new Bodywork("Morado", 5), new Engine(2L, true, 120), new Air(50L, true), new HydrogenTank(150L));

		vehiculosHibridos.put(1L, coche1);
		vehiculosHibridos.put(2L, coche2);
		vehiculosHibridos.put(3L, coche3);
	}

	/**
	 * Método para recuperar el número de vehículos híbridos.
	 * 
	 * @return cantidad de vehículos híbridos.
	 */
	@Override
	public Integer count() {
		return vehiculosHibridos.keySet().size();
	}

	/**
	 * Método que sirve para encontrar todos los vehículos híbridos.
	 * 
	 * @return lista de vehículos híbridos.
	 */
	@Override
	public List<Hybrid> findAll() {
		return new ArrayList<>(vehiculosHibridos.values());
	}

	/**
	 * Método que sirve para encontrar los vehículos híbridos que tengan un número
	 * de puertas concreto.
	 * 
	 * @param door número de puertas solicitado.
	 * @return lista de vehículos con ese número de puertas.
	 */
	@Override
	public List<Hybrid> findDoor(int door) {
		ArrayList<Hybrid> vehicleList = new ArrayList<>();
		for (Map.Entry<Long, Hybrid> entry : vehiculosHibridos.entrySet()) {
			if (entry.getValue().getBodywork().getPuertas() == door) {
				vehicleList.add(entry.getValue());
			}
		}
		return vehicleList;
	}

	/**
	 * Método que sirve para encontrar los vehículos híbridos que tengan un color
	 * concreto.
	 * 
	 * @param color solicitado.
	 * @return lista de vehículos con ese color.
	 */
	@Override
	public List<Hybrid> findColor(String color) {
		ArrayList<Hybrid> vehicleList = new ArrayList<>();
		for (Map.Entry<Long, Hybrid> entry : vehiculosHibridos.entrySet()) {
			if (entry.getValue().getBodywork().getColor().equals(color)) {
				vehicleList.add(entry.getValue());
			}
		}
		return vehicleList;
	}

	/**
	 * Método que sirve para encontrar los vehículos híbridos que tengan un nombre
	 * concreto.
	 * 
	 * @param name que tiene que tener el vehículo.
	 * @return lista de vehículos con ese nombre.
	 */
	@Override
	public List<Hybrid> findName(String name) {
		ArrayList<Hybrid> vehicleList = new ArrayList<>();
		for (Map.Entry<Long, Hybrid> entry : vehiculosHibridos.entrySet()) {
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
	 * @return vehículo híbrido guardado.
	 */
	@Override
	public Hybrid save(Hybrid hibrido) {

		if (hibrido.getId() == null || hibrido.getId() == 0L)
			hibrido.setId(getMaxElectricId() + 1);

		vehiculosHibridos.remove(hibrido.getId());

		vehiculosHibridos.put(hibrido.getId(), hibrido);
		return hibrido;
	}

	/**
	 * Devuelve el id más alto del mapa vehiculosHibridos.
	 * 
	 * @return número de id más alto.
	 */
	private Long getMaxElectricId() {
		if (vehiculosHibridos.isEmpty())
			return 0L;

		return Collections
				.max(vehiculosHibridos.entrySet(), (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey()))
				.getKey();
	}

	/**
	 * Método que borra un vehículo híbridos por id.
	 * 
	 * @param id del vehículo que hay que borrar.
	 * @return mensaje sobre si se ha borrado o no.
	 */
	@Override
	public boolean delete(Long id) {
		if (id == null || !vehiculosHibridos.containsKey(id))
			return false;
		vehiculosHibridos.remove(id);
		return true;
	}

	/**
	 * Método que borra todos los vehículos híbridos.
	 */
	@Override
	public void deleteAll() {
		if (!vehiculosHibridos.isEmpty())
			vehiculosHibridos.clear();
	}

}
