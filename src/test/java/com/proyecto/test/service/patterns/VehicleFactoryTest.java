package com.proyecto.test.service.patterns;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.proyecto.domain.Combustion;
import com.proyecto.domain.Electric;
import com.proyecto.domain.Hybrid;
import com.proyecto.domain.Vehicle;

import com.proyecto.service.InvalidVehicle;

import com.proyecto.service.patterns.VehicleFactory;

class VehicleFactoryTest {
//	assertNotNull
//	assertTrue insteanceof
//	assertEquals getname
//	asserte equals id
//	etc+
	
	@Test
	@DisplayName("Comprobar petición de crear un coche eléctrico.")
	void testCaseElectric() throws InvalidVehicle {
		Vehicle vehiculo = VehicleFactory.createByType("electric");
		assertNotNull(vehiculo);
		assertTrue(vehiculo instanceof Electric);
		assertEquals("Default Electric", vehiculo.getModel());
		assertEquals(1L, vehiculo.getId());
	}
	
	
	@Test
	@DisplayName("Comprobar petición de crear un coche a combustión.")
	void testCaseCombustion() throws InvalidVehicle {
		Vehicle vehiculo = VehicleFactory.createByType("combustion");
		assertTrue(vehiculo instanceof Combustion);
		assertNotNull(vehiculo);
		assertEquals("Default Combustion", vehiculo.getModel());
		assertEquals(2L, vehiculo.getId());
	}
	
	@Test
	@DisplayName("Comprobar petición de crear un coche híbrido.")
	void testCasehybrid() throws InvalidVehicle {
		Vehicle vehiculo = VehicleFactory.createByType("hybrid");
		assertTrue(vehiculo instanceof Hybrid);
		assertTrue(vehiculo instanceof Hybrid);
		assertEquals("Default Hybrid", vehiculo.getModel());
		assertEquals(1L, vehiculo.getId());
	}
	
	
	@Test
	@DisplayName("Comprobar envío de excepción con un vehículo no seleccionable.")
	void testCaseInvalid() throws InvalidVehicle {
		Exception exception = assertThrows(InvalidVehicle.class,
				() -> {VehicleFactory.createByType("camion");});
		assertEquals("404 Not found", exception.getMessage());
	}
	
	

}
