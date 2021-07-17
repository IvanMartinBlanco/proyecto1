package com.proyecto.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.proyecto.service.InvalidVehicle;
import com.proyecto.service.patterns.VehicleFactory;

import org.springframework.stereotype.Component;

/**
 * Clase para crear un vehículo dependiendo del parámetro recibido.
 * 
 * @author Iván Martín Blanco
 *
 */
@Component
@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleController {

	/**
	 * Función que se usará para crear un vehículo con GET en la URL:
	 * http://localhost:8080/api/vehicle/[type] 
	 * Ejemplo: http://localhost:8080/api/vehicle/[type]
	 * 
	 * @param type de vehículo que se va a crear.
	 * @return respuesta sobre si se ha podido crear o no el vehículo.
	 */
	@GET
	@Path("/{type}")
	public Response createByType(@PathParam("type") String type) {

		try {
			return Response.ok().entity(VehicleFactory.createByType(type)).build();
		} catch (InvalidVehicle e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}
}
