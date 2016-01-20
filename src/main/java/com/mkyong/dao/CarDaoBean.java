package com.mkyong.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mkyong.dao.common.AbstractDaoBean;
import com.mkyong.model.Car;

@Stateless
public class CarDaoBean extends AbstractDaoBean<Car> implements
		CarDao {

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Car> getAllCars() {
		return findAll();
	}
}
