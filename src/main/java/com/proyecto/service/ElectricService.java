package com.proyecto.service;

import java.util.List;

import com.proyecto.domain.Electric;

/**
 * Interfaz para el servicio de los vehículos eléctricos.
 * 
 * @author Iván Martín Blanco.
 *
 */
public interface ElectricService {

	/**
	 * Método para recuperar el número de vehículos eléctricos.
	 * 
	 * @return cantidad de vehículos eléctricos.
	 */
	Integer count();

	/**
	 * Método que sirve para encontrar todos los vehículos eléctricos.
	 * 
	 * @return lista de vehículos eléctricos.
	 */
	List<Electric> findAll();

	/**
	 * Método que sirve para encontrar los vehículos eléctricos que tengan un color
	 * concreto.
	 * 
	 * @param color solicitado.
	 * @return lista de vehículos con ese color.
	 */
	List<Electric> findColor(String color);

	/**
	 * Método que sirve para encontrar los vehículos eléctricos que tengan un número
	 * de puertas concreto.
	 * 
	 * @param door número de puertas solicitado.
	 * @return lista de vehículos con ese número de puertas.
	 */
	List<Electric> findDoor(int door);

	/**
	 * Método que sirve para encontrar los vehículos eléctricos que tengan un nombre
	 * concreto.
	 * 
	 * @param name que tiene que tener el vehículo.
	 * @return lista de vehículos con ese nombre.
	 */
	List<Electric> findName(String name);

	/**
	 * Método para guardar nuevos vehículos.
	 * 
	 * @param electrico que hay que guardar.
	 * @return vehículo eléctrico guardado.
	 */
	Electric save(Electric electrico);

	/**
	 * Método que borra un vehículo eléctrico por id.
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
