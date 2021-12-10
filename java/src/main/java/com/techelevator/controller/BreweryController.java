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

    // Testing Open Brewery DB API
    @RequestMapping(path = "/breweries", method = RequestMethod.GET)
    public List<Object> getBreweries() {
        String url = "https://api.openbrewerydb.org/breweries?by_city=chicago";
        RestTemplate restTemplate = new RestTemplate();
        Brewery[] testBrew = restTemplate.getForObject(url, Brewery[].class);
        Object[] breweries = restTemplate.getForObject(url, Object[].class);
        for (Brewery item: testBrew) {
            System.out.println(item.toString());
        }
        System.out.println(testBrew.length);
        return Arrays.asList(testBrew);
    }

    @RequestMapping(path= "/breweries/{name}", method = RequestMethod.GET)
    public Brewery getBreweryWithName(@PathVariable("name") String name) {
        return breweryDao.findBreweryByName(name);
    }
}
