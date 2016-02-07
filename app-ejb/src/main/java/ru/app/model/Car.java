package ru.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Car
 *
 */
@Entity
@Table(name="car_park")
@NamedQueries({
    @NamedQuery(name="getCars",
                query="SELECT c FROM Car c"),
    @NamedQuery(name="carByName",
                query="SELECT c FROM Car c WHERE c.name = :name"),
}) 
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CAR_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CARCASE_ID")
	private Integer carcase;
	@Column(name="ENGINE_ID")
	private Integer engine;
	@Column(name="TRANSMISSION_ID")
	private Integer transmission;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCarcase() {
		return carcase;
	}
	public void setCarcase(Integer carcase) {
		this.carcase = carcase;
	}
	public Integer getEngine() {
		return engine;
	}
	public void setEngine(Integer engine) {
		this.engine = engine;
	}
	public Integer getTransmission() {
		return transmission;
	}
	public void setTransmission(Integer transmission) {
		this.transmission = transmission;
	}
   
}
