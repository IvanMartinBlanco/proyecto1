package com.proyecto.test.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.proyecto.domain.Combustion;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestCombustionController {

	private TestRestTemplate testRestTemplate;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@LocalServerPort
	private int port;

	@BeforeEach
	void setup() {
		restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
		testRestTemplate = new TestRestTemplate(restTemplateBuilder);
	}

	@Order(1)
	@Test
	@DisplayName("Test GET con todos los coches de combustión.")
	void testFindAllCombustion() {
		ResponseEntity<Combustion[]> entity = this.testRestTemplate.getForEntity("/api/combustion", Combustion[].class);

		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}

	@Order(2)
	@Test
	@DisplayName("Test GET con coches según color.")
	void testFindByColorCombustion() {

		ResponseEntity<Combustion[]> response = this.testRestTemplate.getForEntity("/api/combustion/color/Blanco",
				Combustion[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Combustion[] vehiculo = response.getBody();
		assertNotEquals(0, vehiculo.length);
		for (Combustion combustion : vehiculo) {
			assertEquals("Blanco", combustion.getBodywork().getColor());
		}
	}

	@Order(3)
	@Test
	@DisplayName("Test GET con coches según color que no existe.")
	void testFindByColorCombustionNone() {

		ResponseEntity<Combustion[]> response = this.testRestTemplate.getForEntity("/api/combustion/color/Morado",
				Combustion[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Combustion[] vehiculo = response.getBody();
		assertEquals(0, vehiculo.length);
	}

	@Order(4)
	@Test
	@DisplayName("Test GET con coches según número de puertas.")
	void testFindByDoorCombustion() {

		ResponseEntity<Combustion[]> response = this.testRestTemplate.getForEntity("/api/combustion/doors/3",
				Combustion[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Combustion[] vehiculo = response.getBody();
		assertNotEquals(0, vehiculo.length);
		for (Combustion combustion : vehiculo) {
			assertEquals(3, combustion.getBodywork().getPuertas());
		}
	}

	@Order(5)
	@Test
	@DisplayName("Test GET con coches según número de puertas que no existe.")
	void testFindByDoorCombustionNone() {

		ResponseEntity<Combustion[]> response = this.testRestTemplate.getForEntity("/api/combustion/doors/9",
				Combustion[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Combustion[] vehiculo = response.getBody();
		assertEquals(0, vehiculo.length);
	}

	@Order(6)
	@Test
	@DisplayName("Test GET con coches según nombre del modelo.")
	void testFindByNameCombustion() {

		ResponseEntity<Combustion[]> response = this.testRestTemplate.getForEntity("/api/combustion/name/Mazda",
				Combustion[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Combustion[] vehiculo = response.getBody();
		assertNotEquals(0, vehiculo.length);
		for (Combustion combustion : vehiculo) {
			assertEquals("Mazda", combustion.getModel());
		}
	}

	@Order(7)
	@Test
	@DisplayName("Test GET con coches según nombre del modelo que no existe.")
	void testFindByNameCombustionNone() {

		ResponseEntity<Combustion[]> response = this.testRestTemplate.getForEntity("/api/combustion/name/Ford",
				Combustion[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Combustion[] vehiculo = response.getBody();

		assertEquals(0, vehiculo.length);
	}

	@Order(8)
	@Test
	@DisplayName("Test POST para guardar un coche.")
	void testSaveCombustion() {
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String productPayload = """
				{
				"id":0,
				"model":"Seat",
				"tire":{
					"brand":"Michelin",
					"pressure":2.5
				},
				"battery":{
					"id":1,
					"on":true,
					"capacity":8
				},
				"bodywork":{
					"color":"Gris",
					"puertas":3
				},
				"started":true,
				"engine":{
				"id":1,
				"on":true,
				"power":120
				},
				"air":{
					"gas":50,
					"on":true
				},
				"injection":{
					"number":8,
					"sequential":true
				},
				"gasTank":{
					"capacity":500
				}
				}
											""";

		final HttpEntity<String> request = new HttpEntity<>(productPayload, headers);

		final ResponseEntity<Combustion> response = testRestTemplate.exchange("/api/combustion", HttpMethod.POST,
				request, Combustion.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Combustion car = response.getBody();
		assertNotNull(car.getBodywork());
		assertEquals("Seat", car.getModel());

	}
	
	@Order(9)
	@Test
	@DisplayName("Test POST para guardar un coche pasando un id incorrecto.")
	void testSaveCombustionNone() {
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String productPayload = """
				{
				"id":1,
				"model":"Seat",
				"tire":{
					"brand":"Michelin",
					"pressure":2.5
				},
				"battery":{
					"id":1,
					"on":true,
					"capacity":8
				},
				"bodywork":{
					"color":"Gris",
					"puertas":3
				},
				"started":true,
				"engine":{
				"id":1,
				"on":true,
				"power":120
				},
				"air":{
					"gas":50,
					"on":true
				},
				"injection":{
					"number":8,
					"sequential":true
				},
				"gasTank":{
					"capacity":500
				}
				}
											""";

		final HttpEntity<String> request = new HttpEntity<>(productPayload, headers);

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/combustion", HttpMethod.POST,
				request, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}
	
	@Order(10)
	@Test
	@DisplayName("Test PUT para modificar un coche pasando un id.")
	void testEditCombustion() {
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String productPayload = """
				{
				"id":2,
				"model":"Seat",
				"tire":{
					"brand":"Michelin",
					"pressure":2.5
				},
				"battery":{
					"id":1,
					"on":true,
					"capacity":8
				},
				"bodywork":{
					"color":"Gris",
					"puertas":3
				},
				"started":true,
				"engine":{
				"id":1,
				"on":true,
				"power":120
				},
				"air":{
					"gas":50,
					"on":true
				},
				"injection":{
					"number":8,
					"sequential":true
				},
				"gasTank":{
					"capacity":500
				}
				}
											""";

		final HttpEntity<String> request = new HttpEntity<>(productPayload, headers);

		final ResponseEntity<Combustion> response = testRestTemplate.exchange("/api/combustion", HttpMethod.PUT,
				request, Combustion.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Combustion car = response.getBody();
		assertEquals("Seat", car.getModel());

	}
	
	@Order(11)
	@Test
	@DisplayName("Test PUT para modificar un coche pasando un id incorrecto.")
	void testEditCombustionNone() {
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String productPayload = """
				{
				"id":0,
				"model":"Seat",
				"tire":{
					"brand":"Michelin",
					"pressure":2.5
				},
				"battery":{
					"id":1,
					"on":true,
					"capacity":8
				},
				"bodywork":{
					"color":"Gris",
					"puertas":3
				},
				"started":true,
				"engine":{
				"id":1,
				"on":true,
				"power":120
				},
				"air":{
					"gas":50,
					"on":true
				},
				"injection":{
					"number":8,
					"sequential":true
				},
				"gasTank":{
					"capacity":500
				}
				}
											""";


		final HttpEntity<String> request = new HttpEntity<>(productPayload, headers);

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/combustion", HttpMethod.PUT,
				request, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}
	
	
	@Order(12)
	@Test
	@DisplayName("Test DELETE para borrar un coche pasando un id.")
	void testDeleteCombustion() {

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/combustion/3", HttpMethod.DELETE,
				null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());


	}
	
	@Order(13)
	@Test
	@DisplayName("Test DELETE para borrar un coche pasando un id incorrecto.")
	void testDeleteCombustionNone() {

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/combustion/6", HttpMethod.DELETE,
				null, String.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());


	}

	@Order(14)
	@Test
	@DisplayName("Test DELETE para borrar todos los coches.")
	void testDeleteAllCombustion() {

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/combustion", HttpMethod.DELETE,
				null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());


	}


}
