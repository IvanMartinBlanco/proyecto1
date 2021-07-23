package com.proyecto.service;

import java.util.List;

import com.proyecto.domain.Combustion;

/**
 * Interfaz para el servicio de los vehículos de combustión.
 * 
 * @author Iván Martín Blanco.
 *
 */
public interface CombustionService {

	/**
	 * Método para recuperar el número de vehículos de combustión.
	 * 
	 * @return cantidad de vehículos de combustión.
	 */
	Integer count();

	/**
	 * Método que sirve para encontrar todos los vehículos de combustión.
	 * 
	 * @return lista de vehículos de combustión.
	 */
	List<Combustion> findAll();

	/**
	 * Método que sirve para encontrar los vehículos de combustión que tengan un
	 * color concreto.
	 * 
	 * @param color solicitado.
	 * @return lista de vehículos con ese color.
	 */
	List<Combustion> findColor(String color);

	/**
	 * Método que sirve para encontrar los vehículos de combustión que tengan un
	 * número de puertas concreto.
	 * 
	 * @param door número de puertas solicitado.
	 * @return lista de vehículos con ese número de puertas.
	 */
	List<Combustion> findDoor(int door);

	/**
	 * Método que sirve para encontrar los vehículos de combustión que tengan un
	 * nombre concreto.
	 * 
	 * @param name que tiene que tener el vehículo.
	 * @return lista de vehículos con ese nombre.
	 */
	List<Combustion> findName(String name);

	/**
	 * Método para guardar nuevos vehículos.
	 * 
	 * @param car que hay que guardar.
	 * @return vehículo de combustión guardado.
	 */
	Combustion save(Combustion car);

	/**
	 * Método que borra un vehículo de combustión por id.
	 * 
	 * @param id del vehículo que hay que borrar.
	 * @return mensaje sobre si se ha borrado o no.
	 */
	boolean delete(Long id);

	/**
	 * Método que borra todos los vehículos de combustión.
	 */
	void deleteAll();
}
