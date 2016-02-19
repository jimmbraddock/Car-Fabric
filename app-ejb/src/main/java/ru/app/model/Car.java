package ru.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
    @NamedQuery(name="carById",
                query="SELECT c FROM Car c WHERE c.id = :id")    
}) 
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@carId")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CAR_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@JoinColumn(name="CARCASE_ID")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Carcase carcase;
	
	@JoinColumn(name="ENGINE_ID")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Engine engine;
	
	@JoinColumn(name="TRANSMISSION_ID")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Transmission transmission;
	
	
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
	public Carcase getCarcase() {
		return carcase;
	}
	public void setCarcase(Carcase carcase) {
		this.carcase = carcase;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Transmission getTransmission() {
		return transmission;
	}
	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}
   
}
