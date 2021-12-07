package com.techelevator.controller;


import com.techelevator.model.Brewery;
import com.techelevator.services.BreweryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BreweryController {
    private BreweryService breweryService;
    private RestTemplate restTemplate = new RestTemplate();

    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

public BreweryController() {
    //no arg
}

    @RequestMapping(path = "/api/breweries", method = RequestMethod.GET)
    public Brewery getBreweryList() {
        Brewery brewery = breweryService.getList();
        System.out.println(brewery);
        return brewery;
    }
}
