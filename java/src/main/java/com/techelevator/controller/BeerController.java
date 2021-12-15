package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BeerController {
    private BeerDao beerDao;

    public BeerController(BeerDao beerDao){
      this.beerDao = beerDao;
    }

    @RequestMapping(path = "/beer/{name}", method = RequestMethod.GET)
    public Beer getBeerWithName(@PathVariable("name") String name) {
    return beerDao.findBeerWithName(name);
    }

    @RequestMapping(path = "/brewery/{name}", method = RequestMethod.POST)
    public Beer addBeerToDB(@RequestBody Beer beer) {
        System.out.println("Controller reached");
        beerDao.addBeerToBrewery(beer);
        return beer;
    }

    @RequestMapping(path= "/beer/desc/{name}", method = RequestMethod.GET)
    public Beer viewBeerInfo(@PathVariable("name") String name) {
        return beerDao.viewBeerInformation(name);
    }

    @RequestMapping(path= "/brewery/{name}/beers", method = RequestMethod.GET)
    public List<Beer> viewBreweryBeers(@PathVariable("name") String name) {
        System.out.println("Controller reached");
        List<Beer> beerResults = beerDao.findBeerByBrewery(name);
        return beerResults;
    }

}
