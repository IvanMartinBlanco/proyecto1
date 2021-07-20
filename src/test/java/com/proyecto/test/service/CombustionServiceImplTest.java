package com.proyecto.test.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


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

	}
	
	

	@Test
	@DisplayName("Test que comprueba el método count para obtener número de vehículos.")
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
	@DisplayName("Test que comprueba el método para recuperar todos los vehículos a combustión.")
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
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo de las puertas.")
	void testFindDoor() {
		List<Combustion> vehiculos = sut.findDoor(3);
		assertEquals(3, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(3);
		assertEquals(2, vehiculos.size());
		

	}
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo de las puertas con un 0 como parámetro.")
	void testFindDoorZero() {
		List<Combustion> vehiculos = sut.findDoor(0);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(0);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo de las puertas con un parámetro negativo.")
	void testFindDoorNegative() {
		List<Combustion> vehiculos = sut.findDoor(-4);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findDoor(-4);
		assertEquals(0, vehiculos.size());
		

	}
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del color.")
	void testFindColor() {
		List<Combustion> vehiculos = sut.findColor("Negro");
		assertEquals(1, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor("Negro");
		assertEquals(1, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del color con un parámetro null.")
	void testFindColorNull() {
		List<Combustion> vehiculos = sut.findColor(null);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor(null);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del color con un parámetro sin resultados.")
	void testFindColorNone() {
		List<Combustion> vehiculos = sut.findColor("Azul");
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findColor("Azul");
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del nombre del modelo.")
	void testFindName() {
		List<Combustion> vehiculos = sut.findName("Mazda");
		assertEquals(1, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName("Mazda");
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del nombre del modelo con un parámetro null.")
	void testFindNameNull() {
		List<Combustion> vehiculos = sut.findName(null);
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName(null);
		assertEquals(0, vehiculos.size());
		

	}
	
	
	@Test
	@DisplayName("Test que comprueba el método para recuperar los vehículos dependiendo del nombre del modelo con un parámetro sin resultados.")
	void testFindNameNone() {
		List<Combustion> vehiculos = sut.findName("abc");
		assertEquals(0, vehiculos.size());
		
		sut.delete(1L);
		
		vehiculos = sut.findName("abc");
		assertEquals(0, vehiculos.size());
	
	}
	
	@Test
	@DisplayName("Test que comprueba el método para guardar un nuevo vehículo de combustión con id autogenerado.")
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
	@DisplayName("Test que comprueba el método para editar un vehículo de combustión.")
	void testSaveEdit() {
		int amount = sut.findAll().size();
		Combustion vehiculo = new Combustion(1L, "Ford", new Tire("Branston", 4.5F), new Battery(6L, 12),
				new Bodywork("Naranja", 5), new Engine(6L, true, 220), new Air(60L, true), new Injection(12, true),
				new GasTank());
		
		Combustion result = sut.save(vehiculo);
		assertNotNull(result.getId());

		assertEquals(amount, sut.findAll().size());
	}
	
	@Test
	@DisplayName("Test que comprueba el método para guardar un nuevo vehículo con un id nuevo.")
	void testSaveNew() {
		int cantidad = sut.findAll().size();
		Combustion vehiculo = new Combustion(6L, "Ford", new Tire("Branston", 4.5F), new Battery(6L, 12),
				new Bodywork("Naranja", 5), new Engine(6L, true, 220), new Air(60L, true), new Injection(12, true),
				new GasTank());
		
		Combustion result = sut.save(vehiculo);

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
	@DisplayName("Test que comprueba el método para borrar todos los vehículos de combustión.")
	void testDeleteAll() {

		sut.deleteAll();
		
		assertEquals(0, sut.findAll().size());
		
	}
	
	@Test
	@DisplayName("Test que comprueba el método para borrar todos los vehículos de combustión y luego crear uno sobre la lista vacía.")
	void testDeleteAllAndSave() {

		sut.deleteAll();
		
		assertEquals(0, sut.findAll().size());
		
		//Comprobación extra para ver que se puede añadir un vehículo a la lista vacía.
		Combustion vehiculo = new Combustion(0L, "Ford", new Tire("Branston", 4.5F), new Battery(6L, 12),
				new Bodywork("Naranja", 5), new Engine(6L, true, 220), new Air(60L, true), new Injection(12, true),
				new GasTank());
		
		sut.save(vehiculo);
		
		assertEquals(1, sut.findAll().size());
		
	}
	
	


	
}
