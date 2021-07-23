package com.proyecto.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Clase para configurar Jersey.
 * 
 * @author Iván Martín Blanco
 *
 */
@ApplicationPath("/api")
@Component
public class JerseyConfig extends ResourceConfig {

	/**
	 * Método que conecta con el paquete que tiene los controladores.
	 */
	public JerseyConfig() {
		this.packages("com.proyecto.rest");
	}
}
