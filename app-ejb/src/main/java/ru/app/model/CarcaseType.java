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
@Table(name="carcase_type")
public class CarcaseType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CARCASE_TYPE_ID")
	private Integer id;
	
	@Column(name="CARCASE_TYPE_NAME")
	private String name;
	
	
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
	
}
