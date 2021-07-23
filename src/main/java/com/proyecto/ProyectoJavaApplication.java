package com.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase necesaria para arrancar Jersey.
 * 
 * @author Iván Martín Blanco
 */
@SpringBootApplication
public class ProyectoJavaApplication {

	/**
	 * Método principal del programa.
	 * 
	 * @param args recibidos por línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProyectoJavaApplication.class, args);
	}

}
