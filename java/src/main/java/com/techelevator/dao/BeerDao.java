package com.techelevator.dao;

import com.techelevator.model.Beer;

public interface BeerDao {

    Beer findBeerWithName(String name);

    Beer findBeerByBrewery(String beerName);
}
