package com.proyecto.service;

import java.util.List;

import com.proyecto.domain.Hybrid;

/**
 * Servicio para gestionar los datos de los vehículos híbridos.
 * 
 * @author Iván Martín Blanco
 */
public interface HybridService {

	/**
	 * Método para recuperar el número de vehículos híbridos.
	 * 
	 * @return cantidad de vehículos híbridos.
	 */
	Integer count();

	/**
	 * Método que sirve para encontrar todos los vehículos híbridos.
	 * 
	 * @return lista de vehículos híbridos.
	 */
	List<Hybrid> findAll();

	/**
	 * Método que sirve para encontrar los vehículos híbridos que tengan un color
	 * concreto.
	 * 
	 * @param color solicitado.
	 * @return lista de vehículos con ese color.
	 */
	List<Hybrid> findColor(String color);

	/**
	 * Método que sirve para encontrar los vehículos híbridos que tengan un número
	 * de puertas concreto.
	 * 
	 * @param door número de puertas solicitado.
	 * @return lista de vehículos con ese número de puertas.
	 */
	List<Hybrid> findDoor(int door);

	/**
	 * Método que sirve para encontrar los vehículos híbridos que tengan un nombre
	 * concreto.
	 * 
	 * @param name que tiene que tener el vehículo.
	 * @return lista de vehículos con ese nombre.
	 */
	List<Hybrid> findName(String name);

	/**
	 * Método para guardar nuevos vehículos.
	 * 
	 * @param hibrido que hay que guardar.
	 * @return vehículo híbrido guardado.
	 */
	Hybrid save(Hybrid hibrido);

	/**
	 * Método que borra un vehículo híbridos por id.
	 * 
	 * @param id del vehículo que hay que borrar.
	 * @return mensaje sobre si se ha borrado o no.
	 */
	boolean delete(Long id);

	/**
	 * Método que borra todos los vehículos híbridos.
	 */
	void deleteAll();
}
