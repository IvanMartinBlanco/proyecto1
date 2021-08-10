package com.proyecto.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.proyecto.domain.Electric;
import com.proyecto.service.ElectricService;
import com.proyecto.service.ElectricServiceImpl;

/**
 * Clase para conectar el vehículo eléctrico con su servicio.
 * 
 * @author Iván Martín Blanco
 *
 */
@Path("/electric")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ElectricController {

	private final ElectricService electricService;

	/**
	 * Constructor del controlador.
	 * 
	 * @param electricService parámetro del servicio.
	 */
	public ElectricController(ElectricService electricService) {
		this.electricService = electricService;
	}

	/**
	 * Función que se usará para GET en la URL:
	 * http://localhost:8080/api/electric
	 * 
	 * @return lista con todos los coches eléctricos.
	 */
	@GET
	public List<Electric> findAll() {
		return electricService.findAll();
	}

	/**
	 * Función que se usará para GET en la URL:
	 * http://localhost:8080/api/electric/color/[color]
	 * Ejemplo: http://localhost:8080/api/electric/color/Rojo
	 * 
	 * @param color que se quiere buscar.
	 * @return lista con todos los coches eléctricos de ese color.
	 */
	@GET
	@Path("/color/{color}")
	public List<Electric> findColor(@PathParam("color") String color) {
		return electricService.findColor(color);
	}

	/**
	 * Función que se usará para GET en la URL:
	 * http://localhost:8080/api/electric/doors/[door]
	 * Ejemplo: http://localhost:8080/api/electric/doors/5
	 * 
	 * @param door número de puertas que se quieren buscar.
	 * @return lista con todos los coches eléctricos con esas puertas.
	 */
	@GET
	@Path("/doors/{door}")
	public List<Electric> findDoor(@PathParam("door") int door) {
		return electricService.findDoor(door);
	}

	/**
	 * Función que se usará para GET en la URL:
	 * http://localhost:8080/api/electric/name/[name]
	 * Ejemplo: http://localhost:8080/api/electric/name/Toyota
	 * 
	 * @param name nombre que se quiere buscar.
	 * @return lista con todos los coches eléctricos con ese nombre.
	 */
	@GET
	@Path("/name/{name}")
	public List<Electric> findName(@PathParam("name") String name) {
		return electricService.findName(name);
	}

	/**
	 * Función que se usará para guardar un vehículo con POST en la URL:
	 * http://localhost:8080/api/electric
	 * 
	 * @param electrico vehículo eléctrico a crear.
	 * @return respuesta sobre si se ha creado o no.
	 */
	@POST 
	public Response create(Electric electrico) {
		if (electrico.getId() != 0) 
			return Response.status(Response.Status.BAD_REQUEST).build();

		Electric result = electricService.save(electrico);
		return Response.ok(result).build();
	}

	/**
	 * Función que se usará para actualizar un vehículo con PUT en la URL:
	 * http://localhost:8080/api/electric
	 * 
	 * @param electrico vehículo eléctrico a modificar.
	 * @return respuesta sobre si se ha modificado o no.
	 */
	@PUT // ACTUALIZAR
	public Response update(Electric electrico) {
		if (electrico.getId() == null || electrico.getId() == 0)
			return Response.status(Response.Status.BAD_REQUEST).build();

		Electric result = electricService.save(electrico);
		return Response.ok(result).build();
	}

	/**
	 * Función que se usará para DELETE en la URL:
	 * http://localhost:8080/api/electric/[id]
	 * 
	 * @param id del vehículo a borrar.
	 * @return respuesta sobre si se ha borrado o no.
	 */
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!electricService.delete(id))
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(Response.Status.OK).build();
	}

	/**
	 * Función que se usará para borrar todo con DELETE en la URL:
	 * http://localhost:8080/api/electric
	 * 
	 * @return respuesta sobre si se ha borrado o no.
	 */
	@DELETE
	public Response deleteAll() {
		electricService.deleteAll();
		return Response.ok(Response.Status.OK).build();
	}

}