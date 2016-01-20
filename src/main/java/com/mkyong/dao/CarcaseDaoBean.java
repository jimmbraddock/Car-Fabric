package com.mkyong.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mkyong.model.Carcase;
import com.mkyong.dao.common.AbstractDaoBean;

@Stateless
public class CarcaseDaoBean extends AbstractDaoBean<Carcase> implements
		CarcaseDao {

	
	@Override
	public Carcase findCarcaseBySN(String serialNumber) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Carcase> q = cb.createQuery(Carcase.class);
	    Root<Carcase> c = q.from(Carcase.class);
	    Predicate predicate = cb.equal(c.get("carcaseSerialNumber"), serialNumber);
	    q.select(c).where(predicate);

		return getSingleResult(q);
	}

	@Override
	public List<Carcase> getAllCarcase() {
		return findAll();
	}
	


}
