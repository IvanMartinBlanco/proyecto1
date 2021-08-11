package com.proyecto.test.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import java.util.Arrays;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

import com.proyecto.domain.Electric;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestElectricController {

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
	@DisplayName("Test GET con todos los coches eléctricos.")
	void testFindAllElectric() {
		ResponseEntity<Electric[]> entity = this.testRestTemplate.getForEntity("/api/electric", Electric[].class);

		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}


	@Order(2)
	@ParameterizedTest
	@ValueSource(strings = {"Azul", "Rojo"})
	@DisplayName("Test GET con coches según color.")
	void testFindByColorElectric(String args) {

		ResponseEntity<Electric[]> response = this.testRestTemplate.getForEntity("/api/electric/color/"+args,
				Electric[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Electric[] vehiculo = response.getBody();
		if(args.equals("Rojos")) {
			assertEquals(0, vehiculo.length);
		}else {
			for (Electric electric : vehiculo) {
				assertEquals(args, electric.getBodywork().getColor());
			}
		}
		
	}

	@Order(3)
	@Test
	@DisplayName("Test GET con coches según número de puertas.")
	void testFindByDoorElectric() {

		ResponseEntity<Electric[]> response = this.testRestTemplate.getForEntity("/api/electric/doors/5",
				Electric[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Electric[] vehiculo = response.getBody();
		assertNotEquals(0, vehiculo.length);
		for (Electric electric : vehiculo) {
			assertEquals(5, electric.getBodywork().getPuertas());
		}
	}

	@Order(4)
	@Test
	@DisplayName("Test GET con coches según número de puertas que no existe.")
	void testFindByDoorElectricNone() {

		ResponseEntity<Electric[]> response = this.testRestTemplate.getForEntity("/api/electric/doors/9",
				Electric[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Electric[] vehiculo = response.getBody();
		assertEquals(0, vehiculo.length);
	}

	@Order(5)
	@Test
	@DisplayName("Test GET con coches según nombre del modelo.")
	void testFindByNameElectric() {

		ResponseEntity<Electric[]> response = this.testRestTemplate.getForEntity("/api/electric/name/Toyota",
				Electric[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		Electric[] vehiculo = response.getBody();
		assertNotEquals(0, vehiculo.length);
		for (Electric electric : vehiculo) {
			assertEquals("Toyota", electric.getModel());
		}
	}

	@Order(6)
	@Test
	@DisplayName("Test GET con coches según nombre del modelo que no existe.")
	void testFindByNameElectricNone() {

		ResponseEntity<Electric[]> response = this.testRestTemplate.getForEntity("/api/electric/name/Mazda",
				Electric[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Electric[] vehiculo = response.getBody();

		assertEquals(0, vehiculo.length);
	}

	@Order(7)
	@Test
	@DisplayName("Test POST para guardar un coche pasando un id incorrecto.")
	void testSaveElectricNone() {
		
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

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/electric", HttpMethod.POST,
				request, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}
	
	@Order(8)
	@Test
	@DisplayName("Test PUT para modificar un coche pasando un id incorrecto.")
	void testEditElectricNone() {
		
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

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/electric", HttpMethod.PUT,
				request, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}
	
	
	@Order(9)
	@Test
	@DisplayName("Test DELETE para borrar un coche pasando un id.")
	void testDeleteElectric() {

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/electric/3", HttpMethod.DELETE,
				null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());


	}
	
	@Order(10)
	@Test
	@DisplayName("Test DELETE para borrar un coche pasando un id incorrecto.")
	void testDeleteElectricNone() {

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/electric/6", HttpMethod.DELETE,
				null, String.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());


	}

	@Order(11)
	@Test
	@DisplayName("Test DELETE para borrar todos los coches.")
	void testDeleteAllElectric() {

		final ResponseEntity<String> response = testRestTemplate.exchange("/api/electric", HttpMethod.DELETE,
				null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());


	}


}