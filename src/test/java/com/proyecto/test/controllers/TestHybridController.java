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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

import com.proyecto.domain.Hybrid;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestHybridController {

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
	@DisplayName("Test GET con todos los coches híbridos.")
	void testFindAllHybrid() {
		ResponseEntity<Hybrid[]> entity = this.testRestTemplate.getForEntity("/api/hybrid", Hybrid[].class);

		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}

	@Order(2)
	@Test
	@DisplayName("Test GET con coches según color.")
	void Hybrid() {

		ResponseEntity<Hybrid[]> response = this.testRestTemplate.getForEntity("/api/hybrid/color/Azul",
				Hybrid[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Hybrid[] vehiculo = response.getBody();
		assertNotEquals(0, vehiculo.length);
		for (Hybrid hibrido : vehiculo) {
			assertEquals("Azul", hibrido.getBodywork().getColor());
		}
	}

	@Order(3)
	@Test
	@DisplayName("Test GET con coches según color que no existe.")
	void testFindByColorHybridNone() {

		ResponseEntity<Hybrid[]> response = this.testRestTemplate.getForEntity("/api/hybrid/color/Blanco",
				Hybrid[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Hybrid[] vehiculo = response.getBody();
		assertEquals(0, vehiculo.length);
		for (Hybrid combustion : vehiculo) {
			assertEquals("Blanco", combustion.getBodywork().getColor());
		}
	}

	@Order(4)
	@Test
	@DisplayName("Test GET con coches según número de puertas.")
	void testFindByDoorHybrid() {

		ResponseEntity<Hybrid[]> response = this.testRestTemplate.getForEntity("/api/hybrid/doors/5",
				Hybrid[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Hybrid[] vehiculo = response.getBody();
		assertNotEquals(0, vehiculo.length);
		for (Hybrid hybrid : vehiculo) {
			assertEquals(5, hybrid.getBodywork().getPuertas());
		}
	}

	@Order(5)
	@Test
	@DisplayName("Test GET con coches según número de puertas que no existe.")
	void testFindByDoorElectricNone() {

		ResponseEntity<Hybrid[]> response = this.testRestTemplate.getForEntity("/api/hybrid/doors/9",
				Hybrid[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Hybrid[] vehiculo = response.getBody();
		assertEquals(0, vehiculo.length);
	}

	@Order(6)
	@Test
	@DisplayName("Test GET con coches según nombre del modelo.")
	void testFindByNameHybrid() {

		ResponseEntity<Hybrid[]> response = this.testRestTemplate.getForEntity("/api/hybrid/name/Toyota",
				Hybrid[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		Hybrid[] vehiculo = response.getBody();
		assertNotEquals(0, vehiculo.length);
		for (Hybrid hybrid : vehiculo) {
			assertEquals("Toyota", hybrid.getModel());
		}
	}

	@Order(7)
	@Test
	@DisplayName("Test GET con coches según nombre del modelo que no existe.")
	void testFindByNameHybridNone() {

		ResponseEntity<Hybrid[]> response = this.testRestTemplate.getForEntity("/api/hybrid/name/Mazda",
				Hybrid[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Hybrid[] vehiculo = response.getBody();

		assertEquals(0, vehiculo.length);
	}

	@Order(8)
	@Test
	@DisplayName("Test POST para guardar un coche.")
	void testSaveHybrid() {
		
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
				}
				}
											""";

		final HttpEntity<String> request = new HttpEntity<>(productPayload, headers);

		final ResponseEntity<Hybrid> response = testRestTemplate.exchange("/api/hybrid", HttpMethod.POST, 
				request, Hybrid.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Hybrid car = response.getBody();
		assertNotNull(car.getBodywork());
		assertEquals("Seat", car.getModel());

	}
	
	@Order(9)
	@Test
	@DisplayName("Test POST para guardar un coche pasando un id incorrecto.")
	void testSaveHybridNone() {
		
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
				}
				}
											""";

		final HttpEntity<String> request = new HttpEntity<>(productPayload, headers);

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/hybrid", HttpMethod.POST,
				request, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}
	
	@Order(10)
	@Test
	@DisplayName("Test PUT para modificar un coche pasando un id.")
	void testEditHybrid() {
		
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
				}
				}
				
											""";

		final HttpEntity<String> request = new HttpEntity<>(productPayload, headers);

		final ResponseEntity<Hybrid> response = testRestTemplate.exchange("/api/hybrid", HttpMethod.PUT,
				request, Hybrid.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Hybrid car = response.getBody();
		assertEquals("Seat", car.getModel());

	}
	
	@Order(11)
	@Test
	@DisplayName("Test PUT para modificar un coche pasando un id incorrecto.")
	void testEditHybridNone() {
		
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
				}
				}
				
											""";


		final HttpEntity<String> request = new HttpEntity<>(productPayload, headers);

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/hybrid", HttpMethod.PUT,
				request, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}
	
	
	@Order(12)
	@Test
	@DisplayName("Test DELETE para borrar un coche pasando un id.")
	void testDeleteHybrid() {

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/hybrid/3", HttpMethod.DELETE,
				null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());


	}
	
	@Order(13)
	@Test
	@DisplayName("Test DELETE para borrar un coche pasando un id incorrecto.")
	void testDeleteHybridNone() {

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/hybrid/6", HttpMethod.DELETE,
				null, String.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());


	}

	@Order(14)
	@Test
	@DisplayName("Test DELETE para borrar todos los coches.")
	void testDeleteAllHybrid() {

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/hybrid", HttpMethod.DELETE,
				null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());


	}


}
