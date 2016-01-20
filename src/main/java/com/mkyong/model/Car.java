package com.mkyong.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;


@XmlRootElement
@Entity
@Table(name="CAR_PARK")
@AttributeOverrides({
    @AttributeOverride(name="id", column=@Column(name="CAR_ID")),
    @AttributeOverride(name="name", column=@Column(name="NAME"))
})
public class Car extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CARCASE_ID")
	private Carcase carcase;

	public Carcase getCarcase() {
		return carcase;
	}

	public void setCarcase(Carcase carcase) {
		this.carcase = carcase;
	}

}
