package com.techelevator.dao;


import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface BreweryDao {

   Brewery findBreweryByName(String breweryName);

   List<Brewery> findBreweryByZipCode(String zipCode);

   List<Brewery> displayHomePage();
}
