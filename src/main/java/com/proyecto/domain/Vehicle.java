package com.proyecto.domain;

import com.proyecto.domain.pieces.Air;
import com.proyecto.domain.pieces.Battery;
import com.proyecto.domain.pieces.Bodywork;
import com.proyecto.domain.pieces.Engine;
import com.proyecto.domain.pieces.Tire;

/**
 * Clase abstracta sobre vehículos.
 * 
 * @author Iván Martín Blanco
 *
 */
public abstract class Vehicle {

	private Long id;
	private String model;
	private Tire tire;
	private Battery battery;
	private Bodywork bodywork;
	private Boolean started;
	private Engine engine;
	private Air air;

	/**
	 * Constructor para vehículos sin parámetros.
	 */
	protected Vehicle() {

	}

	/**
	 * Constructor para vehículos con parámetros.
	 * 
	 * @param id       del vehículo.
	 * @param model    del vehículo.
	 * @param tire     del vehículo.
	 * @param battery  del vehículo.
	 * @param bodywork del vehículo.
	 * @param engine   del vehículo.
	 * @param air      del vehículo.
	 */
	protected Vehicle(Long id, String model, Tire tire, Battery battery, Bodywork bodywork, Engine engine, Air air) {
		this.id = id;
		this.model = model;
		this.tire = tire;
		this.battery = battery;
		this.bodywork = bodywork;
		this.engine = engine;
		this.air = air;
		this.started = true;
	}

	/**
	 * Método que devuelve el id del vehículo.
	 * 
	 * @return id del vehículo.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que modifica el id del vehículo.
	 * 
	 * @param id que va a tener el vehículo.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que devuelve el modelo del vehículo.
	 * 
	 * @return modelo del vehículo.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Método que modifica el modelo del vehículo.
	 * 
	 * @param model que va a tener el vehículo.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Método que devuelve los neumáticos del vehículo.
	 * 
	 * @return neumáticos del vehículo.
	 */
	public Tire getTire() {
		return new Tire(tire.getBrand(), tire.getPressure());
	}

	/**
	 * Método que modifica los neumáticos del vehículo.
	 * 
	 * @param tire que va a tener el vehículo.
	 */
	public void setTire(Tire tire) {
		this.tire = new Tire(tire.getBrand(), tire.getPressure());
	}

	/**
	 * Método que devuelve la batería del vehículo.
	 * 
	 * @return batería del vehículo.
	 */
	public Battery getBattery() {
		return new Battery(battery.getId(), battery.getCapacity());
	}

	/**
	 * Método que modifica la batería del vehículo.
	 * 
	 * @param battery que va a tener el vehículo.
	 */
	public void setBattery(Battery battery) {
		this.battery = new Battery(battery.getId(), battery.getCapacity());
	}

	/**
	 * Método que devuelve la carrocería del vehículo.
	 * 
	 * @return carrocería del vehículo.
	 */
	public Bodywork getBodywork() {
		return new Bodywork(bodywork.getColor(),bodywork.getPuertas());
	}

	/**
	 * Método que modifica la carrocería del vehículo.
	 * 
	 * @param bodywork que va a tener el vehículo.
	 */
	public void setBodywork(Bodywork bodywork) {
		this.bodywork = new Bodywork(bodywork.getColor(), bodywork.getPuertas());
	}

	/**
	 * Método que devuelve si el vehículo está o no arrancado.
	 * 
	 * @return true o false.
	 */
	public Boolean getStarted() {
		return started;
	}

	/**
	 * Método que modifica si está arrancado o no el vehículo.
	 * 
	 * @param started valor sobre si está o no arrancado el vehículo.
	 */
	public void setStarted(Boolean started) {
		this.started = started;
	}

	/**
	 * Método que devuelve el motor del vehículo.
	 * 
	 * @return motor del vehículo.
	 */
	public Engine getEngine() {
		return new Engine(engine.getId(),engine.getOn(), engine.getPower());
	}

	/**
	 * Método que modifica el motor del vehículo.
	 * 
	 * @param engine que va a tener el vehículo.
	 */
	public void setEngine(Engine engine) {
		this.engine = new Engine(engine.getId(), engine.getOn(), engine.getPower());
	}

	/**
	 * Método que devuelve el aire del vehículo.
	 * 
	 * @return aire del vehículo.
	 */
	public Air getAir() {
		return new Air(air.getGas(), air.getOn());
	}

	/**
	 * Método que modifica el aire del vehículo.
	 * 
	 * @param air que va a tener el vehículo.
	 */
	public void setAir(Air air) {
		this.air = new Air(air.getGas(), air.getOn());
	}

	/**
	 * Método que devuelve los datos del vehículo.
	 */
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", tire=" + tire + ", battery=" + battery + ", bodywork="
				+ bodywork + ", started=" + started + ", engine=" + engine + ", air=" + air + "]";
	}

}
	
	
	


	

