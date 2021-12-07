package com.techelevator.services;

import org.springframework.stereotype.Component;
import com.techelevator.model.Brewery;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestBreweryService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Brewery getList() {
        return restTemplate.getForObject("https://api.openbrewerydb.org/breweries?per_page=25", Brewery.class);
    }
}
