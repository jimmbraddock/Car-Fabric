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
@Table(name="engine_type")
public class EngineType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ENGINE_TYPE_ID")
	private Integer id;
	
	@Column(name="ENGINE_TYPE_NAME")
	private String name;
   
}
