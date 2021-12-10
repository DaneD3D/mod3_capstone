package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class BreweryController {

    private BreweryDao breweryDao;

    public BreweryController(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }


    @RequestMapping(path = "/breweries/name", method = RequestMethod.GET)
    public Brewery getBreweryWithName(@RequestParam String breweryName) {
        return breweryDao.findBreweryByName(breweryName);
    }

    @RequestMapping(path = "/homepage", method = RequestMethod.GET)
    public List<Brewery> homepageBreweries(String city) {
        return breweryDao.displayHomePage();
    }
}
