package com.mkyong.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name="CARCASE")
@AttributeOverrides({
    @AttributeOverride(name="id", column=@Column(name="CARCASE_ID")),
    @AttributeOverride(name="name", column=@Column(name="CARCASE_SERIAL_NUMBER", unique=true))
})
public class Carcase extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY, optional = false)
	@JoinColumn(name="CARCASE_TYPE_ID")
	private CarcaseType type;

	@Column(name="COLOR")
	private String color;

	@Column(name="DOOR_COUNT")
	private Integer door_count;

//	@Column(name="CARCASE_SERIAL_NUMBER", unique=true)
//	private String carcaseSerialNumber;

	public CarcaseType getType() {
		return type;
	}

	public void setType(CarcaseType type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getDoor_count() {
		return door_count;
	}

	public void setDoor_count(Integer door_count) {
		this.door_count = door_count;
	}

//	public String getCarcaseSerialNumber() {
//		return carcaseSerialNumber;
//	}
//
//	public void setCarcaseSerialNumber(String carcaseSerialNumber) {
//		this.carcaseSerialNumber = carcaseSerialNumber;
//	}

}
