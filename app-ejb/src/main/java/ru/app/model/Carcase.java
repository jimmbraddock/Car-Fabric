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
@Table(name="carcase")
@NamedQueries({
    @NamedQuery(name="getCarcases",
                query="FROM Carcase c WHERE NOT EXISTS(FROM Car st WHERE st.carcase = c)"),
    @NamedQuery(name="carcaseByType",
                query="FROM Carcase c WHERE c.type = :type"),
}) 
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@carcaseId")
public class Carcase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CARCASE_ID")
	private Integer id;
	
	@Column(name="CARCASE_SERIAL_NUMBER")
	private String serialNumber;
	
	@ManyToOne
	@JoinColumn(name="CARCASE_TYPE_ID")
	private CarcaseType type;
	
	@Column(name="DOOR_COUNT")
	private Integer doors;
	
	@OneToOne(mappedBy="carcase", fetch=FetchType.LAZY)
	private Car car;
	
	@Column(name="COLOR")
	private String color;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public CarcaseType getCarcase() {
		return type;
	}


	public void setCarcase(CarcaseType carcasetype) {
		this.type = carcasetype;
	}


	public Integer getDoors() {
		return doors;
	}


	public void setDoors(Integer doors) {
		this.doors = doors;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public CarcaseType getType() {
		return type;
	}


	public void setType(CarcaseType type) {
		this.type = type;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}

   
}
