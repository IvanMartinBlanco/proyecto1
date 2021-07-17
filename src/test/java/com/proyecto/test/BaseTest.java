package com.proyecto.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
	/**
	 * Se ejecuta una vez al principio de todo.
	 * 
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	/**
	 * Se ejecuta después de todo.
	 * @throws Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}
	
	/**
	 * Se ejecuta antes de cada método de test, una vez por cada test que haya.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
	}

	/**
	 * Se ejecuta después de cada método de test, una vez por cada test que haya
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("setDown");
	}
}
