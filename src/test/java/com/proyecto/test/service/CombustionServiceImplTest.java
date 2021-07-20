package com.proyecto.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.proyecto.domain.Combustion;
import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.GasTank;
import com.proyecto.domain.pieces.Injection;
import com.proyecto.domain.pieces.Tire;
import com.proyecto.service.CombustionServiceImpl;


@ExtendWith(MockitoExtension.class)
public class CombustionServiceImplTest {

	CombustionServiceImpl sut;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new CombustionServiceImpl();
		this.demoData();

	}
	
	private void demoData() {
		sut.deleteAll();
		Combustion coche1 = new Combustion(1L, "Mazda", new Tire("Pirelli", 2.5F), new Battery(1L, 8),
				new Bodywork("Blanco", 3), new Engine(1L, true, 120), new Air(50L, true), new Injection(8, true),
				new GasTank());

		Combustion coche2 = new Combustion(2L, "Seat", new Tire("Michelin", 2.5F), new Battery(1L, 8),
				new Bodywork("Gris", 3), new Engine(1L, true, 120), new Air(50L, true), new Injection(8, true),
				new GasTank());

		Combustion coche3 = new Combustion(3L, "Peugeot", new Tire("Michelin", 2.5F), new Battery(1L, 8),
				new Bodywork("Negro", 3), new Engine(1L, true, 120), new Air(50L, true), new Injection(8, true),
				new GasTank());

		sut.save(coche1);
		sut.save(coche2);
		sut.save(coche3);
	}
	

	@Test
	@DisplayName("Método count para obtener número de vehículos.")
	void testCount() {
		
		Integer vehiculoCombustion = sut.count();

		assertEquals(3, vehiculoCombustion);
		
		sut.delete(1L);
		
		vehiculoCombustion = sut.count();
		assertEquals(2, vehiculoCombustion);
		
		sut.delete(64L);
		
		vehiculoCombustion = sut.count();
		assertEquals(2, vehiculoCombustion);
		
		sut.deleteAll();
		
		vehiculoCombustion = sut.count();
		assertEquals(0, vehiculoCombustion);
		
	}

	
	
	@Test
	@DisplayName("Método para recuperar todos los vehículos a combustión.")
	void testFindAll() {
		
		List<Combustion> vehiculos = sut.findAll();
		assertEquals(3, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findAll();
		assertEquals(2, vehiculos.size());
		
		for (Combustion vehiculo : vehiculos) {
			assertNotNull(vehiculo.getId());
		}

		
	}
	
	
	@Test
	@DisplayName("Método para recuperar los vehículos dependiendo de las puertas.")
	void testFindDoor() {
		List<Combustion> vehiculos = sut.findDoor(3);
		assertEquals(3, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(3);
		assertEquals(2, vehiculos.size());
		

	}
	
	@Test
	@DisplayName("Método para recuperar los vehículos dependiendo de las puertas con un 0 como parámetro.")
	void testFindDoorZero() {
		List<Combustion> vehiculos = sut.findDoor(0);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(0);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Método para recuperar los vehículos dependiendo de las puertas con un parámetro negativo.")
	void testFindDoorNegative() {
		List<Combustion> vehiculos = sut.findDoor(-4);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(-4);
		assertEquals(0, vehiculos.size());
		

	}
	
	@Test
	@DisplayName("Método para recuperar los vehículos dependiendo del color.")
	void testFindColor() {
		List<Combustion> vehiculos = sut.findColor("Negro");
		assertEquals(1, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor("Negro");
		assertEquals(1, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Método para recuperar los vehículos dependiendo del color con un parámetro null.")
	void testFindColorNull() {
		List<Combustion> vehiculos = sut.findColor(null);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor(null);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Método para recuperar los vehículos dependiendo del color con un parámetro sin resultados.")
	void testFindColorNone() {
		List<Combustion> vehiculos = sut.findColor("Azul");
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor("Azul");
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Método para recuperar los vehículos dependiendo del nombre del modelo.")
	void testFindName() {
		List<Combustion> vehiculos = sut.findName("Mazda");
		assertEquals(1, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName("Mazda");
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Método para recuperar los vehículos dependiendo del nombre del modelo con un parámetro null.")
	void testFindNameNull() {
		List<Combustion> vehiculos = sut.findName(null);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName(null);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Método para recuperar los vehículos dependiendo del nombre del modelo con un parámetro sin resultados.")
	void testFindNameNone() {
		List<Combustion> vehiculos = sut.findName("abc");
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName("abc");
		assertEquals(0, vehiculos.size());
	
	}
	
	@Test
	@DisplayName("Método para guardar un nuevo vehículo de combustión.")
	void testSaveCreate() {
		int cantidad = sut.findAll().size();
		Combustion vehiculo = new Combustion(0L, "Ford", new Tire("Branston", 4.5F), new Battery(6L, 12),
				new Bodywork("Naranja", 5), new Engine(6L, true, 220), new Air(60L, true), new Injection(12, true),
				new GasTank());
		
		Combustion result = sut.save(vehiculo);

		assertNotNull(result.getId());
		
		assertEquals(cantidad+1, sut.findAll().size());

	}
	
	@Test
	@DisplayName("Método para editar un vehículo de combustión.")
	void testSaveEdit() {
		int cantidad = sut.findAll().size();
		Combustion vehiculo = new Combustion(1L, "Ford", new Tire("Branston", 4.5F), new Battery(6L, 12),
				new Bodywork("Naranja", 5), new Engine(6L, true, 220), new Air(60L, true), new Injection(12, true),
				new GasTank());
		
		Combustion result = sut.save(vehiculo);
		assertNotNull(result.getId());
		
		assertEquals(cantidad, sut.findAll().size());
	}
	
	
	
//	@Override
//	public Combustion save(Combustion smartphone) {
//
//		// asignar un id
//		if (smartphone.getId() == null || smartphone.getId() == 0L) 
//			smartphone.setId(getMaxCombustionId() + 1);
//
//		vehiculosCombustion.remove(smartphone.getId());
//		vehiculosCombustion.put(smartphone.getId(), smartphone);
//		return smartphone;
//	}
	
	
	
	


	
}
