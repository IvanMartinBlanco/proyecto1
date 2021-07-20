package com.proyecto.test.service.patterns;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
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
import com.proyecto.service.InvalidVehicle;
import com.proyecto.service.patterns.VehicleFacade;
import com.proyecto.service.patterns.VehicleFactory;

public class VehicleFactoryTest {
//	assertNotNull
//	assertTrue insteanceof
//	assertEquals getname
//	asserte equals id
//	etc+
	
	@Test
	@DisplayName("Comprobar petición de crear un coche eléctrico.")
	void testCaseElectric() throws InvalidVehicle {
		Vehicle vehiculo = VehicleFactory.createByType("electric");
		assertTrue(vehiculo instanceof Electric);

	}
	
	
	@Test
	@DisplayName("Comprobar petición de crear un coche a combustión.")
	void testCaseCombustion() throws InvalidVehicle {
		Vehicle vehiculo = VehicleFactory.createByType("combustion");
		assertTrue(vehiculo instanceof Combustion);

	}
	
	@Test
	@DisplayName("Comprobar petición de crear un coche híbrido.")
	void testCasehybrid() throws InvalidVehicle {
		Vehicle vehiculo = VehicleFactory.createByType("hybrid");
		assertTrue(vehiculo instanceof Hybrid);

	}
	
	
	@Test
	@DisplayName("Comprobar envío de excepción con un vehículo no seleccionable.")
	void testCaseInvalid() throws InvalidVehicle {
		Assertions.assertThrows(InvalidVehicle.class, () -> {
			VehicleFactory.createByType("camión");
		  });
	}

}
