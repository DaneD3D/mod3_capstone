package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
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
    public List<Brewery> homepageBreweries() {
        return breweryDao.displayHomePage();
    }

    @RequestMapping(path = "/brewery/update", method = RequestMethod.PUT)
    public void update(@RequestBody Brewery brewery) {
        breweryDao.updateBrewery(brewery);
    }

    @RequestMapping(path = "/brewery/new", method = RequestMethod.POST)
    public void add(@RequestBody Brewery brewery) {
        breweryDao.addBrewery(brewery);
    }

    @RequestMapping(path = "/brewery/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        breweryDao.deleteBrewery(id);
    }

}
