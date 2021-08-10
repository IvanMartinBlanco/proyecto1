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

import com.proyecto.domain.Hybrid;
import com.proyecto.service.HybridService;

/**
 * Clase para conectar el vehículo híbrido con su servicio.
 * 
 * @author Iván Martín Blanco
 *
 */
@Path("/hybrid")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HybridController {

	private final HybridService hybridService;

	/**
	 * Constructor del controlador.
	 * 
	 * @param hybridService parámetro del servicio.
	 */
	public HybridController(HybridService hybridService) {
		this.hybridService = hybridService;
	}

	/**
	 * Método que se usará para GET en la URL:
	 * http://localhost:8080/api/hybrid
	 * 
	 * @return lista con todos los coches híbridos.
	 */
	@GET
	public List<Hybrid> findAll() {
		return hybridService.findAll();
	}

	/**
	 * Método que se usará para GET en la URL:
	 * http://localhost:8080/api/hybrid/color/[color]
	 * Ejemplo: http://localhost:8080/api/hybrid/color/Rojo
	 * 
	 * @param color que se quiere buscar.
	 * @return lista con todos los coches híbridos de ese color.
	 */
	@GET
	@Path("/color/{color}")
	public List<Hybrid> findColor(@PathParam("color") String color) {
		return hybridService.findColor(color);
	}

	/**
	 * Método que se usará para GET en la URL:
	 * http://localhost:8080/api/hybrid/doors/[door]
	 * Ejemplo: http://localhost:8080/api/hybrid/doors/5
	 * 
	 * @param door número de puertas que se quieren buscar.
	 * @return lista con todos los coches híbridos con esas puertas.
	 */
	@GET
	@Path("/doors/{door}")
	public List<Hybrid> findDoor(@PathParam("door") int door) {
		return hybridService.findDoor(door);
	}

	/**
	 * Método que se usará para GET en la URL:
	 * http://localhost:8080/api/hybrid/name/[name]
	 * Ejemplo: http://localhost:8080/api/hybrid/name/Toyota
	 * 
	 * @param name nombre que se quiere buscar.
	 * @return lista con todos los coches híbridos con ese nombre.
	 */
	@GET
	@Path("/name/{name}")
	public List<Hybrid> findName(@PathParam("name") String name) {
		return hybridService.findName(name);
	}

	/**
	 * Método que se usará para guardar un vehículo con POST en la URL:
	 * http://localhost:8080/api/hybrid
	 * 
	 * @param hibrido vehículo híbrido a crear.
	 * @return respuesta sobre si se ha creado o no.
	 */
	@POST
	public Response create(Hybrid hibrido) {
		if (hibrido.getId() != 0)
			return Response.status(Response.Status.BAD_REQUEST).build();

		Hybrid result = hybridService.save(hibrido);
		return Response.ok(result).build();
	}

	/**
	 * Método que se usará para actualizar un vehículo con PUT en la URL:
	 * http://localhost:8080/api/hybrid
	 * 
	 * @param hibrido vehículo híbrido a modificar.
	 * @return respuesta sobre si se ha modificado o no.
	 */
	@PUT
	public Response update(Hybrid hibrido) {
		if (hibrido.getId() == null || hibrido.getId() == 0)
			return Response.status(Response.Status.BAD_REQUEST).build();

		Hybrid result = hybridService.save(hibrido);
		return Response.ok(result).build();
	}

	/**
	 * Método que se usará para DELETE en la URL:
	 * http://localhost:8080/api/hybrid/[id]
	 * 
	 * @param id del vehículo a borrar.
	 * @return respuesta sobre si se ha borrado o no.
	 */
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!hybridService.delete(id))
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(Response.Status.OK).build();
	}

	/**
	 * Método que se usará para borrar todo con DELETE en la URL:
	 * http://localhost:8080/api/hybrid
	 * 
	 * @return respuesta sobre si se ha borrado o no.
	 */
	@DELETE
	public Response deleteAll() {
		hybridService.deleteAll();
		return Response.ok(Response.Status.OK).build();
	}

}
