package ua.com.service;

import java.util.List;

import ua.com.entity.City;

public interface CityService {

	void save(City city);
	List<City> findAll();
	City findOne(int id);
	void delete(int id);
	
}
