package com.mkyong.dao;

import java.util.List;

import javax.ejb.Local;

import com.mkyong.model.Carcase;
import com.mkyong.dao.common.Dao;

@Local
public interface CarcaseDao extends Dao<Carcase> {

	Carcase findCarcaseBySN(String serialNumber);

	List<Carcase> getAllCarcase();

}
