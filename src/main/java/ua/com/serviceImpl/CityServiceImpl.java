package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.dao.CityDao;
import ua.com.entity.City;
import ua.com.service.CityService;
@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao cityDao;

	public void save(City city) {
		cityDao.save(city);
	}

	public List<City> findAll() {
		return cityDao.findAll();
	}

	public City findOne(int id) {
		return cityDao.findOne(id);
	}

	public void delete(int id) {
		cityDao.delete(id);
	}
	
	
	
}
