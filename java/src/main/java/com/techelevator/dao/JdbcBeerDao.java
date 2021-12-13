package com.techelevator.dao;

import com.techelevator.model.Beer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcBeerDao implements BeerDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

@Override
    public Beer findBeerWithName(String beerName){
        String sql = "SELECT * " +
                     "FROM beer " +
                     "WHERE beer_name = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, beerName);
        if(result.next()) {
            return mapRowToBeer(result);
        } else {
            throw new RuntimeException("Beer Name " + beerName + " not found.");
        }
    }

@Override
    public Beer findBeerByBrewery(String beerName){
        String sql = "SELECT * " +
                     "FROM beer " +
                     "WHERE brewery_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, beerName);
        if(result.next()) {
            return mapRowToBeer(result);
        } else {
            throw new RuntimeException("Brewery " + beerName + " not found.");
        }
    }

    public void addBeerToBrewery(Beer beer){
        String sql = "INSERT INTO beer  (brewery_id, beer_name, abv, ibu, beer_type) " +
                     "VALUES (?, ?, ?, ?) RETURNING beer_id;";
        long newBeer = jdbcTemplate.queryForObject(sql, Long.class,
                beer.getBeer_id(), beer.getBrewery_id(), beer.getBeer_name(),
                beer.getAbv(), beer.getIbu(), beer.getBeer_type());
    }

    public void updateBeer(Beer beer){
        String sql = "UPDATE beer " +
                "SET beer_name = ?, abv = ?, ibu = ?, beer_type = ?" +
                "WHERE beer_id = ?;"; //changed

        jdbcTemplate.update(beer.getBeer_name(), beer.getAbv(),
                beer.getIbu(), beer.getBeer_type());

    }

        //added
@Override
    public Beer findBeerByType(String beerType){
        String sql = "SELECT * " +
                "FROM beer " +
                "WHERE beer_type = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, beerType);
        if(result.next()) {
            return mapRowToBeer(result);
        } else {
            throw new RuntimeException("Beer Name " + beerType + " not found.");
        }
    }

@Override
    public List<Beer> listBeersInBreweries(String breweryName) {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_name\n" +
                "FROM beer\n" +
                "INNER JOIN brewery ON beer.brewery_id = brewery.bb_brewery_id \n" +
                "WHERE brewery_name = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, breweryName);
        if(result.next()) {
            beers.add(mapRowToBeer(result));
            return beers;
        } else {
            throw new RuntimeException("Brewery Name" + breweryName + " not found.");
        }
    }




    private Beer mapRowToBeer(SqlRowSet rs){
        Beer beer = new Beer();
        beer.setBb_beer_id(rs.getLong("bb_beer_id"));
        beer.setBeer_id(rs.getString("beer_id"));
        beer.setBeer_name(rs.getString("beer_name"));
        beer.setBeer_type(rs.getString("beer_type"));
        beer.setAbv(rs.getString("abv"));
        beer.setIbu(rs.getString("ibu"));
        beer.setBrewery_id(rs.getString("brewery_id"));
        return beer;
    }

}
