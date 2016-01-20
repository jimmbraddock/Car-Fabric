package com.mkyong.dao;

import java.util.List;

import javax.ejb.Local;

import com.mkyong.dao.common.Dao;
import com.mkyong.model.Car;



@Local
public interface CarDao extends Dao<Car> {

	List<Car> getAllCars();

}
