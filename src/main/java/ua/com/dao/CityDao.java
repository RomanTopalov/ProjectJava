package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
