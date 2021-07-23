package com.proyecto.test.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import com.proyecto.domain.Hybrid;
import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.HydrogenTank;
import com.proyecto.domain.pieces.Tire;
import com.proyecto.service.HybridServiceImpl;


public class HybridServiceImplTest {

	HybridServiceImpl sut;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new HybridServiceImpl();

	}
	
	

	@Test
	@DisplayName("Test que comprueba el método count para obtener número de vehículos.")
	void testCount() {
		
		Integer vehiculosHibridos = sut.count();

		assertEquals(3, vehiculosHibridos);
		
		sut.delete(1L);
		
		vehiculosHibridos = sut.count();
		assertEquals(2, vehiculosHibridos);
		
		sut.delete(64L);
		
		vehiculosHibridos = sut.count();
		assertEquals(2, vehiculosHibridos);
		
		sut.deleteAll();
		
		vehiculosHibridos = sut.count();
		assertEquals(0, vehiculosHibridos);
		
	}

	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar todos los vehículos híbridos.")
	void testFindAll() {
		
		List<Hybrid> vehiculos = sut.findAll();
		assertEquals(3, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findAll();
		assertEquals(2, vehiculos.size());

		
	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo de las puertas.")
	void testFindDoor() {
		List<Hybrid> vehiculos = sut.findDoor(5);
		
		assertEquals(3, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(5);
		assertEquals(2, vehiculos.size());
		

	}
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo de las puertas con un 0 como parámetro.")
	void testFindDoorZero() {
		List<Hybrid> vehiculos = sut.findDoor(0);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(0);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo de las puertas con un parámetro negativo.")
	void testFindDoorNegative() {
		List<Hybrid> vehiculos = sut.findDoor(-4);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(-4);
		assertEquals(0, vehiculos.size());
		

	}
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del color.")
	void testFindColor() {
		List<Hybrid> vehiculos = sut.findColor("Rojo");
		assertEquals(1, vehiculos.size());
		
		sut.delete(2L);
		
		vehiculos = sut.findColor("Rojo");
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del color con un parámetro null.")
	void testFindColorNull() {
		List<Hybrid> vehiculos = sut.findColor(null);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor(null);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del color con un parámetro sin resultados.")
	void testFindColorNone() {
		List<Hybrid> vehiculos = sut.findColor("Naranja");
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor("Azul");
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del nombre del modelo.")
	void testFindName() {
		List<Hybrid> vehiculos = sut.findName("Tesla");
		assertEquals(1, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName("Tesla");
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del nombre del modelo con un parámetro null.")
	void testFindNameNull() {
		List<Hybrid> vehiculos = sut.findName(null);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName(null);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del nombre del modelo con un parámetro sin resultados.")
	void testFindNameNone() {
		List<Hybrid> vehiculos = sut.findName("abc");
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName("abc");
		assertEquals(0, vehiculos.size());
	
	}
	
	@Test
	@DisplayName("Test que comprueba el método para guardar un nuevo vehículo híbrido con id autogenerado.")
	void testSaveCreate() {
		int cantidad = sut.findAll().size();
		Hybrid vehiculo = new Hybrid(0L, "Tesla", new Tire("Michelin", 2.5F), new Battery(2L, 8), new Bodywork("Azul", 5),
				new Engine(2L, true, 120), new Air(50L, true), new HydrogenTank(150L));

		
		Hybrid result = sut.save(vehiculo);

		assertNotNull(result.getId());
		
		assertEquals(cantidad+1, sut.findAll().size());

	}
	
	@Test
	@DisplayName("Test que comprueba el método para editar un vehículo híbrido.")
	void testSaveEdit() {
		int amount = sut.findAll().size();
		Hybrid vehiculo =  new Hybrid(2L, "Tesla", new Tire("Michelin", 2.5F), new Battery(2L, 8), new Bodywork("Azul", 5),
				new Engine(2L, true, 120), new Air(50L, true), new HydrogenTank(150L));

		
		Hybrid result = sut.save(vehiculo);
		assertNotNull(result.getId());

		assertEquals(amount, sut.findAll().size());
	}
	
	@Test
	@DisplayName("Test que comprueba el método para guardar un nuevo vehículo con un id nuevo.")
	void testSaveNew() {
		int cantidad = sut.findAll().size();
		Hybrid vehiculo = new Hybrid(6L, "Tesla", new Tire("Michelin", 2.5F), new Battery(2L, 8), new Bodywork("Azul", 5),
				new Engine(2L, true, 120), new Air(50L, true), new HydrogenTank(150L));

		
		Hybrid result = sut.save(vehiculo);

		assertNotNull(result.getId());
		assertEquals(cantidad+1, sut.findAll().size());

	}
	
	
	
	@Test
	@DisplayName("Test que comprueba el método para borrar un vehículo por id.")
	void testDeleteOne() {
		int cantidad = sut.findAll().size();
		boolean delete = sut.delete(1L);
		
		assertTrue(delete);
		assertEquals(cantidad-1, sut.findAll().size());
		
	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para borrar un vehículo por id que no existe.")
	void testDeleteOneNone() {
		int cantidad = sut.findAll().size();
		boolean delete = sut.delete(-4L);

		assertFalse(delete);
		assertEquals(cantidad, sut.findAll().size());
		
	}
	
	@Test
	@DisplayName("Test que comprueba el método para borrar un vehículo por id que no existe.")
	void testDeleteOneNull() {
		int cantidad = sut.findAll().size();
		boolean delete = sut.delete(null);

		assertFalse(delete);
		assertEquals(cantidad, sut.findAll().size());
		
	}
	
	
	
	@Test
	@DisplayName("Test que comprueba el método para borrar todos los vehículos híbridos.")
	void testDeleteAll() {

		sut.deleteAll();
		
		assertEquals(0, sut.findAll().size());
		
	}
	
	@Test
	@DisplayName("Test que comprueba el método para borrar todos los vehículos híbridos y luego crear uno sobre la lista vacía.")
	void testDeleteAllAndSave() {

		sut.deleteAll();
		
		assertEquals(0, sut.findAll().size());
		
		//Comprobación extra para ver que se puede añadir un vehículo a la lista vacía.
		Hybrid vehiculo = new Hybrid(0L, "Toyota", new Tire("Mihcelin", 2.5F), new Battery(2L, 8),
				new Bodywork("Morado", 5), new Engine(2L, true, 120), new Air(50L, true), new HydrogenTank(150L));

		
		sut.save(vehiculo);
		
		assertEquals(1, sut.findAll().size());
		
	}
	
	


	
}

