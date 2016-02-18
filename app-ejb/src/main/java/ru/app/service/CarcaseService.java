package ru.app.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import ru.app.model.Car;
import ru.app.model.Carcase;

@Stateless
public class CarcaseService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
	public List<Carcase> getCarcases() {
    	return em.createNamedQuery("getCarcases").getResultList();
    }
    
//    public Car getCarByName(String name) {
//    	Query q = em.createNamedQuery("carByName");
//    	q.setParameter("name", name);
//    	return (Car) q.getSingleResult();
//    }
//
//    public Car getCarById(Integer id) {
//    	Query q = em.createNamedQuery("carById");
//    	q.setParameter("id", id);
//    	return (Car) q.getSingleResult();
//    }

}
