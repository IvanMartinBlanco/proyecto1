package com.proyecto.test.service.patterns;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.proyecto.domain.Combustion;
import com.proyecto.domain.Electric;
import com.proyecto.domain.Hybrid;
import com.proyecto.domain.Vehicle;
import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.EngineBattery;
import com.proyecto.domain.pieces.Tire;
import com.proyecto.service.patterns.VehicleFacade;
import com.proyecto.test.BaseTest;

public class VehicleFacadeTest extends BaseTest{

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
		assertEquals(result.getAir().getOn(),true);		
		assertEquals(result.getEngine().getOn(),true);		
		assertEquals(result.getBattery().getOn(),true);		
		assertEquals(result.getStarted(),true);	
		
		assertTrue(result instanceof Electric);

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
		assertEquals(result.getAir().getOn(),true);		
		assertEquals(result.getEngine().getOn(),true);		
		assertEquals(result.getBattery().getOn(),true);		
		assertEquals(result.getStarted(),true);	

		assertTrue(result instanceof Hybrid);
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
		assertEquals(result.getAir().getOn(),true);		
		assertEquals(result.getEngine().getOn(),true);		
		assertEquals(result.getBattery().getOn(),true);		
		assertEquals(result.getStarted(),true);	
		
		assertTrue(result instanceof Combustion);
	}

}