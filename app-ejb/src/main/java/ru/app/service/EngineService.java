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
import ru.app.model.Engine;

@Stateless
public class EngineService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
	public List<Engine> getEngines() {
    	return em.createNamedQuery("getEngines").getResultList();
    }
    
//    public Car getCarByName(String name) {
//    	Query q = em.createNamedQuery("carByName");
//    	q.setParameter("name", name);
//    	return (Car) q.getSingleResult();
//    }
//
    public Engine getEngine(Integer id) {
    	Query q = em.createNamedQuery("engineById");
    	q.setParameter("id", id);
    	return (Engine) q.getSingleResult();
    }

}
