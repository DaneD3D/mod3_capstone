package com.techelevator.services;

import com.techelevator.model.Brewery;
import org.springframework.web.client.RestTemplate;

public interface BreweryService {
    Brewery getList();
}
