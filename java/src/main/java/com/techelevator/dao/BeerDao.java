package com.techelevator.dao;

import com.techelevator.model.Beer;

import java.util.List;

public interface BeerDao {

    Beer findBeerWithName(String name);

    Beer findBeerByBrewery(String beerName);

    Beer findBeerByType(String beerType);

    List<Beer> listBeersInBreweries(String breweryName);

    void updateBeer(Beer beer);
}
