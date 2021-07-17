package com.proyecto.test.service.patterns;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.proyecto.domain.Combustion;
import com.proyecto.domain.Electric;
import com.proyecto.domain.Hybrid;
import com.proyecto.domain.Vehicle;
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
		assertEquals(result.getAir().getOn(),true);		
		assertEquals(result.getEngine().getOn(),true);		
		assertEquals(result.getBattery().getOn(),true);		
		assertEquals(result.getStarted(),true);	
		
		assertTrue(result instanceof Combustion);
	}

}