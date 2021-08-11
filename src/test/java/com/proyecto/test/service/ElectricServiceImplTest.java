package com.proyecto.test.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.proyecto.domain.Electric;
import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.EngineBattery;   
import com.proyecto.domain.pieces.Tire;
import com.proyecto.service.ElectricServiceImpl;

class ElectricServiceImplTest {

	ElectricServiceImpl sut;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new ElectricServiceImpl();

	}
	
	

	@Test
	@DisplayName("Test que comprueba el método count para obtener número de vehículos.")
	void testCount() {
		
		Integer vehiculosElectricos = sut.count();

		assertEquals(3, vehiculosElectricos);
		
		sut.delete(1L);
		
		vehiculosElectricos = sut.count();
		assertEquals(2, vehiculosElectricos);
		
		sut.delete(64L);
		
		vehiculosElectricos = sut.count();
		assertEquals(2, vehiculosElectricos);
		
		sut.deleteAll();
		
		vehiculosElectricos = sut.count();
		assertEquals(0, vehiculosElectricos);
		
	}

	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar todos los vehículos eléctricoss.")
	void testFindAll() {
		
		List<Electric> vehiculos = sut.findAll();
		assertEquals(3, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findAll();
		assertEquals(2, vehiculos.size());

		
	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo de las puertas.")
	void testFindDoor() {
		List<Electric> vehiculos = sut.findDoor(5);
		
		assertEquals(3, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(5);
		assertEquals(2, vehiculos.size());
		

	}
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo de las puertas con un 0 como parámetro.")
	void testFindDoorZero() {
		List<Electric> vehiculos = sut.findDoor(0);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(0);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo de las puertas con un parámetro negativo.")
	void testFindDoorNegative() {
		List<Electric> vehiculos = sut.findDoor(-4);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(-4);
		assertEquals(0, vehiculos.size());
		

	}
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del color.")
	void testFindColor() {
		List<Electric> vehiculos = sut.findColor("Naranja");
		assertEquals(1, vehiculos.size());
		
		sut.delete(2L);
		
		vehiculos = sut.findColor("Rojo");
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del color con un parámetro null.")
	void testFindColorNull() {
		List<Electric> vehiculos = sut.findColor(null);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor(null);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del color con un parámetro sin resultados.")
	void testFindColorNone() {
		List<Electric> vehiculos = sut.findColor("Rojo");
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor("Azul");
		assertEquals(0, vehiculos.size());
		

	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Toyota", "abc"})
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del nombre del modelo.")
	void testFindName(String args) {
		List<Electric> vehiculos = sut.findName(args);
		if(args.equals("Toyota")) {
			assertEquals(1, vehiculos.size());
			
			sut.delete(1L);
			
			vehiculos = sut.findName(args);
			assertEquals(0, vehiculos.size());
		}else {
			assertEquals(0, vehiculos.size());
			
			sut.delete(1L);
			
			vehiculos = sut.findName(args);
			assertEquals(0, vehiculos.size());
		}
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del nombre del modelo con un parámetro null.")
	void testFindNameNull() {
		List<Electric> vehiculos = sut.findName(null);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName(null);
		assertEquals(0, vehiculos.size());
		

	}

	
	@Test
	@DisplayName("Test que comprueba el método para guardar un nuevo vehículo eléctrico con id autogenerado.")
	void testSaveCreate() {
		int cantidad = sut.findAll().size();
		Electric vehiculo = new Electric(0L, "Toyota", new Tire("Michelin", 2.5F), new Battery(2L, 8), new Bodywork("Azul", 5),
				new Engine(2L, true, 120), new Air(50L, true), new EngineBattery(150L));
		
		Electric result = sut.save(vehiculo);

		assertNotNull(result.getId());
		
		assertEquals(cantidad+1, sut.findAll().size());

	}
	
	@Test
	@DisplayName("Test que comprueba el método para editar un vehículo eléctrico.")
	void testSaveEdit() {
		int amount = sut.findAll().size();
		Electric vehiculo =  new Electric(2L, "Toyota", new Tire("Michelin", 2.5F), new Battery(2L, 8), new Bodywork("Azul", 5),
				new Engine(2L, true, 120), new Air(50L, true), new EngineBattery(150L));
		
		Electric result = sut.save(vehiculo);
		assertNotNull(result.getId());

		assertEquals(amount, sut.findAll().size());
	}
	
	@Test
	@DisplayName("Test que comprueba el método para guardar un nuevo vehículo con un id nuevo.")
	void testSaveNew() {
		int cantidad = sut.findAll().size();
		Electric vehiculo = new Electric(6L, "Toyota", new Tire("Michelin", 2.5F), new Battery(2L, 8), new Bodywork("Azul", 5),
				new Engine(2L, true, 120), new Air(50L, true), new EngineBattery(150L));
		
		Electric result = sut.save(vehiculo);

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
	@DisplayName("Test que comprueba el método para borrar todos los vehículos eléctricos.")
	void testDeleteAll() {

		sut.deleteAll();
		
		assertEquals(0, sut.findAll().size());
		
	}
	
	@Test
	@DisplayName("Test que comprueba el método para borrar todos los vehículos eléctricos y luego crear uno sobre la lista vacía.")
	void testDeleteAllAndSave() {

		sut.deleteAll();
		
		assertEquals(0, sut.findAll().size());
		
		//Comprobación extra para ver que se puede añadir un vehículo a la lista vacía.
		Electric vehiculo = new Electric(0L, "Toyota", new Tire("Mihcelin", 2.5F), new Battery(2L, 8),
				new Bodywork("Morado", 5), new Engine(2L, true, 120), new Air(50L, true), new EngineBattery(150L));
		
		sut.save(vehiculo);
		
		assertEquals(1, sut.findAll().size());
		
	}
	
	


	
}