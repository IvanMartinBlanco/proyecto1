package com.proyecto.test.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.proyecto.service.InvalidVehicle;

public class InvalidVehicleTest {

	@Test
	@DisplayName("Comprobar constructor sin parámetros.")
	void testConstructor() {
		InvalidVehicle noExiste = new InvalidVehicle();
assertNotNull(noExiste);	

	}
	
	
	@Test
	@DisplayName("Comprobar constructor con parámetros.")
	void testConstructorParametros() {
		InvalidVehicle noExiste = new InvalidVehicle("No existe");
assertNotNull(noExiste);	

	}
	
	@Test
	@DisplayName("Comprobar respuesta .")
	void testGetError() {
		InvalidVehicle noExiste = new InvalidVehicle("No existe");
		
		assertEquals(Response.status(Response.Status.NOT_FOUND).build().toString(), noExiste.getError().toString());

	}

}
