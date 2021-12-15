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
    public List<Beer> findBeerByBrewery(String beerName){
        List<Beer> beerList = new ArrayList<>();
        String sql = "SELECT * " +
                     "from beer " +
                     "INNER JOIN beer_manifest ON beer.beer_id = beer_manifest.beer_id " +
                     "INNER JOIN brewery on beer_manifest.bb_brewery_id = brewery.bb_brewery_id " +
                     "WHERE brewery_name = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, beerName);
        while(result.next()) {
            Beer beer = mapRowToBeer(result);
            beerList.add(beer);
        }
        return beerList;
    }
    @Override
    public void addBeerToBrewery(Beer beer) {
        System.out.println("add beer to brewery method reached");
        String sql = "INSERT INTO beer  (beer_name, abv, ibu, beer_type) " +
                "VALUES (?, ?, ?, ?) RETURNING beer_id;";
        long newBeer = jdbcTemplate.queryForObject(sql, Long.class,
                beer.getBeer_name(), beer.getAbv(), beer.getIbu(), beer.getBeer_type());
    }

    public void updateBeer(Beer beer){
        String sql = "UPDATE beer " +
                "SET beer_name = ?, abv = ?, ibu = ?, beer_type = ?" +
                "WHERE beer_id = ?;"; //changed

        jdbcTemplate.update(beer.getBeer_name(), beer.getAbv(),
                beer.getIbu(), beer.getBeer_type());

    }

    public Beer viewBeerInformation(String beerName) {
        String sql = "SELECT * " +
                "FROM beer " +
                "WHERE beer_name = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, beerName);
        if(result.next()){
            return mapRowToBeer(result);
        } else {
            throw new RuntimeException("Beer Name " + beerName + " not found.");
        }
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
        String sql = "SELECT beer_name " +
                "FROM beer " +
                "INNER JOIN beer_manifest ON beer.beer_id = beer_manifest.beer_id " +
                "INNER JOIN brewery on beer_manifest.bb_brewery_id = brewery.bb_brewery_id " +
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
        beer.setBeer_id(rs.getLong("beer_id"));
        beer.setBeer_name(rs.getString("beer_name"));
        beer.setAbv(rs.getString("abv"));
        beer.setIbu(rs.getString("ibu"));
        beer.setBeer_type(rs.getString("beer_type"));

        return beer;
    }

}
