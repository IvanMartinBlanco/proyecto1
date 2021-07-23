package com.proyecto.test.service.patterns;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.proyecto.domain.Combustion;
import com.proyecto.domain.Electric;
import com.proyecto.domain.Hybrid;
import com.proyecto.domain.Vehicle;
import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.Tire;
import com.proyecto.service.patterns.VehicleFacade;

public class VehicleFacadeTest{

	@Test
	@DisplayName("Comprobar la creación de vehículo eléctrico.")
	void testElectricVehicle() {
		Vehicle result = VehicleFacade.createElectric();
		assertEquals(result.getModel(),"Default Electric");
		assertEquals(result.getId(),1L);
		assertEquals(result.getBattery().getId(),1L);
		assertEquals(result.getBattery().getCapacity(),12);
		assertTrue(result.getTire() instanceof Tire);
		assertTrue(result.getBodywork() instanceof Bodywork);
		assertTrue(result.getAir() instanceof Air);
		assertTrue(result.getEngine() instanceof Engine);
		assertNotNull(result);
		assertTrue(result instanceof Electric);

	}
	
	@Test
	@DisplayName("Comprobar el encendido del vehículo eléctrico.")
	void testElectricVehicleOn() {
		Vehicle result = VehicleFacade.createElectric();
		assertEquals(result.getAir().getOn(),true);		
		assertEquals(result.getEngine().getOn(),true);		
		assertEquals(result.getBattery().getOn(),true);		
		assertEquals(result.getStarted(),true);	


	}
	
	
	
	@Test
	@DisplayName("Comprobar la creación de vehículo híbrido.")
	void testHybridVehicle() {
		Vehicle result = VehicleFacade.createHybrid();
		assertEquals(result.getModel(),"Default Hybrid");
		assertEquals(result.getId(),1L);
		assertEquals(result.getBattery().getId(),1L);
		assertEquals(result.getBattery().getCapacity(),12);
		assertTrue(result.getTire() instanceof Tire);
		assertTrue(result.getBodywork() instanceof Bodywork);
		assertTrue(result.getAir() instanceof Air);
		assertTrue(result.getEngine() instanceof Engine);
		assertNotNull(result);
		assertTrue(result instanceof Hybrid);
	}
	
	
	@Test
	@DisplayName("Comprobar el encendido del vehículo híbrido.")
	void testHybridVehicleOn() {
		Vehicle result = VehicleFacade.createHybrid();

		assertEquals(result.getAir().getOn(),true);		
		assertEquals(result.getEngine().getOn(),true);		
		assertEquals(result.getBattery().getOn(),true);		
		assertEquals(result.getStarted(),true);	

	}
	
	@Test
	@DisplayName("Comprobar la creación de vehículo a combustión.")
	void testCombustionVehicle() {
		Vehicle result = VehicleFacade.createCombustion();
		assertEquals(result.getModel(),"Default Combustion");
		assertEquals(result.getId(),2L);
		assertEquals(result.getBattery().getId(),1L);
		assertEquals(result.getBattery().getCapacity(),12);
		assertTrue(result.getTire() instanceof Tire);
		assertTrue(result.getBodywork() instanceof Bodywork);
		assertTrue(result.getAir() instanceof Air);
		assertNotNull(result);
		assertTrue(result instanceof Combustion);
	}
	
	@Test
	@DisplayName("Comprobar la creación de vehículo a combustión.")
	void testCombustionVehicleOn() {
		Vehicle result = VehicleFacade.createCombustion();
		
		assertEquals(result.getAir().getOn(),true);		
		assertEquals(result.getEngine().getOn(),true);		
		assertEquals(result.getBattery().getOn(),true);		
		assertEquals(result.getStarted(),true);	

	}

}