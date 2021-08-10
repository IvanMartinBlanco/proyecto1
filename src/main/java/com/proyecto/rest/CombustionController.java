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

import com.proyecto.domain.Combustion;
import com.proyecto.service.CombustionService;
import com.proyecto.service.CombustionServiceImpl;

/**
 * Clase para conectar el vehículo de combustíon con su servicio.
 * 
 * @author Iván Martín Blanco
 *
 */
@Path("/combustion")
@Component
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class CombustionController {

	private final CombustionService combustionService;

	/**
	 * Constructor del controlador.
	 * 
	 * @param combustionService parámetro del servicio.
	 */
	public CombustionController(CombustionService combustionService) {
		this.combustionService = combustionService;
	}

	/**
	 * Función que se usará para GET en la URL:
	 * http://localhost:8080/api/combustion
	 * 
	 * @return lista con todos los coches de combustión.
	 */
	@GET
	public List<Combustion> findAll() {
		return combustionService.findAll();
	}

	/**
	 * Función que se usará para GET en la URL:
	 * http://localhost:8080/api/combustion/color/[color] 
	 * Ejemplo: http://localhost:8080/api/combustion/color/Rojo
	 * 
	 * @param color que se quiere buscar.
	 * @return lista con todos los coches de combustión de ese color.
	 */
	@GET
	@Path("/color/{color}")
	public List<Combustion> findColor(@PathParam("color") String color) {
		return combustionService.findColor(color);
	}

	/**
	 * Función que se usará para GET en la URL:
	 * http://localhost:8080/api/combustion/doors/[door] 
	 * Ejemplo: http://localhost:8080/api/combustion/doors/5
	 * 
	 * @param door número de puertas que se quieren buscar.
	 * @return lista con todos los coches de combustión con esas puertas.
	 */
	@GET
	@Path("/doors/{door}")
	public List<Combustion> findDoor(@PathParam("door") int door) {
		return combustionService.findDoor(door);
	}

	/**
	 * Función que se usará para GET en la URL:
	 * http://localhost:8080/api/combustion/name/[name] 
	 * Ejemplo: http://localhost:8080/api/combustion/name/Toyota
	 * 
	 * @param name que se quiere buscar.
	 * @return lista con todos los coches de combustión con ese nombre.
	 */
	@GET
	@Path("/name/{name}")
	public List<Combustion> findName(@PathParam("name") String name) {
		return combustionService.findName(name);
	}

	/**
	 * Función que se usará para guardar un vehículo con POST en la URL:
	 * http://localhost:8080/api/combustion
	 * 
	 * @param combustion vehículo de combustión a crear.
	 * @return respuesta sobre si se ha creado o no.
	 */
	@POST
	public Response create(Combustion combustion) {
		if (combustion.getId() != 0)
			return Response.status(Response.Status.BAD_REQUEST).build();

		Combustion result = combustionService.save(combustion);
		return Response.ok(result).build();
	}

	/**
	 * Función que se usará para modificar un vehículo con PUT en la URL:
	 * http://localhost:8080/api/combustion
	 * 
	 * @param combustion vehículo de combustión a modificar.
	 * @return respuesta sobre si se ha modificado o no.
	 */
	@PUT
	public Response update(Combustion combustion) {
		if (combustion.getId() == null || combustion.getId() == 0)
			return Response.status(Response.Status.BAD_REQUEST).build();

		Combustion result = combustionService.save(combustion);
		return Response.ok(result).build();
	}

	/**
	 * Función que se usará para DELETE en la URL:
	 * http://localhost:8080/api/combustion/[id]
	 * 
	 * @param id del vehículo a borrar.
	 * @return respuesta sobre si se ha borrado o no.
	 */
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!combustionService.delete(id))
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(Response.Status.OK).build();
	}

	/**
	 * Función que se usará para borrar todo con DELETE en la URL:
	 * http://localhost:8080/api/combustion
	 * 
	 * @return respuesta sobre si se ha borrado o no.
	 */
	@DELETE
	public Response deleteAll() {
		combustionService.deleteAll();
		return Response.ok(Response.Status.OK).build();
	}

}