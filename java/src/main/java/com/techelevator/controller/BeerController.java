package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import org.springframework.web.bind.annotation.*;

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

}
