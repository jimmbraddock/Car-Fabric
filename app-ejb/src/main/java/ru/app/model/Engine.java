package ru.app.model;

import java.io.Serializable;

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
@Table(name="engine")
@NamedQueries({
    @NamedQuery(name="getEngines",
                query="SELECT c FROM Engine c"),
    @NamedQuery(name="engineByType",
                query="SELECT c FROM Engine c WHERE c.type = :type"),
})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@engineId")
public class Engine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ENGINE_ID")
	private Integer id;
	
	@Column(name="ENGINE_SERIAL_NUMBER")
	private String serialNumber;
	
	@Column(name="CAPACITY")
	private Float capacity;
	@Column(name="POWER")
	private Float power;
	
	@OneToOne(mappedBy="engine", fetch=FetchType.LAZY)
	private Car car;
	
	@ManyToOne
	@JoinColumn(name="ENGINE_TYPE_ID")
	private EngineType type;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String number) {
		this.serialNumber = number;
	}
	public Float getCapacity() {
		return capacity;
	}
	public void setCapacity(Float capacity) {
		this.capacity = capacity;
	}
	public Float getPower() {
		return power;
	}
	public void setPower(Float power) {
		this.power = power;
	}
	public EngineType getType() {
		return type;
	}
	public void setType(EngineType type) {
		this.type = type;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
   
}
