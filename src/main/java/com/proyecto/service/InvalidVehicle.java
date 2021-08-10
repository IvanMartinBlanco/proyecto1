package com.proyecto.service;

import javax.ws.rs.core.Response;

/**
 * Método para controlar la excepción si se pide un tipo de vehículo que no
 * existe.
 * 
 * @author Iván Martín Blanco.
 *
 */
public class InvalidVehicle extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor con parámetros para la clase.
	 * 
	 * @param error mensaje con el error producido.
	 */
	public InvalidVehicle(String error) {
		super(error);
	}

	/**
	 * Constructor sin parámetros para la clase.
	 */
	public InvalidVehicle() {
	}

	/**
	 * Método que devuelve la respuesta.
	 * 
	 * @return Respuesta con el mensaje de no encontrado.
	 */
	public Response getError() {
		return Response.status(Response.Status.NOT_FOUND).build();

	}
}