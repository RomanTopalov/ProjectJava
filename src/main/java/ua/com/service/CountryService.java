package ua.com.service;

import java.util.List;

import ua.com.entity.Country;

public interface CountryService {

	void save(Country country);

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

}
