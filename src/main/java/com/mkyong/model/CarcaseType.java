package com.mkyong.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name="CARCASE_TYPE")
@AttributeOverrides({
    @AttributeOverride(name="name", column=@Column(name="CARCASE_TYPE_NAME")),
    @AttributeOverride(name="id", column=@Column(name="CARCASE_TYPE_ID"))
})
public class CarcaseType extends AbstractEntity {

	private static final long serialVersionUID = 1L;

}
