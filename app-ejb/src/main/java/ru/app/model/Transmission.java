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
import javax.persistence.UniqueConstraint;

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
@Table(name="transmission")
@NamedQueries({
    @NamedQuery(name="getTransmissions",
                query="SELECT c FROM Transmission c"),
    @NamedQuery(name="transmissionByType",
                query="SELECT c FROM Transmission c WHERE c.type = :type"),
})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@transmissionId")
public class Transmission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TRANSMISSION_ID")
	private Integer id;
	
	@Column(name="TRANSMISSION_SERIAL_NUMBER", unique=true)
	private String serialNumber;
	
	@ManyToOne
	@JoinColumn(name="TRANSMISSION_TYPE_ID")
	private TransmissionType type;
	
	@OneToOne(mappedBy="transmission", fetch=FetchType.LAZY)
	private Car car;
	
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
	public TransmissionType getType() {
		return type;
	}
	public void setCarcase(TransmissionType type) {
		this.type = type;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public void setType(TransmissionType type) {
		this.type = type;
	}   
}
