package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer>{

}
