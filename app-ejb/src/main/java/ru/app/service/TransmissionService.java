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
import ru.app.model.Transmission;

@Stateless
public class TransmissionService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
	public List<Transmission> getTransmissions() {
    	return em.createNamedQuery("getTransmissions").getResultList();
    }
    
//    public Car getCarByName(String name) {
//    	Query q = em.createNamedQuery("carByName");
//    	q.setParameter("name", name);
//    	return (Car) q.getSingleResult();
//    }
//
    public Transmission getTransmission(Integer id) {
    	Query q = em.createNamedQuery("transmissionById");
    	q.setParameter("id", id);
    	return (Transmission) q.getSingleResult();
    }

}
