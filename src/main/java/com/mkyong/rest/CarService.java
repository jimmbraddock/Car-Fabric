package com.mkyong.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.mkyong.dao.CarDao;
import com.mkyong.dao.CarDaoBean;
import com.mkyong.model.Car;


@Named
@Stateless
@Path("/cars")
public class CarService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CarDao carDao;
	
	@PersistenceContext(name="jpa-example")
	   private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars(){
    	InitialContext ctx;
        try {
            ctx = new InitialContext();
            EntityManagerFactory factory = (EntityManagerFactory)ctx.lookup("java:/MyEntityManagerFactory");
             
            System.out.println("Factory is "+factory);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return carDao.getAllCars();
    }

}
