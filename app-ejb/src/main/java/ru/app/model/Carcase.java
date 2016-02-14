package ru.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Car
 *
 */
@Entity
@Table(name="carcase")
@NamedQueries({
    @NamedQuery(name="getCarsaces",
                query="SELECT c FROM Carcase c"),
    @NamedQuery(name="carcaseByType",
                query="SELECT c FROM Carcase c WHERE c.type = :type"),
}) 
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

   
}
