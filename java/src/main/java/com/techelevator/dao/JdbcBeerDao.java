package com.techelevator.dao;

import com.techelevator.model.Beer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

@Service
public class JdbcBeerDao implements BeerDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        String sql = "INSERT INTO beer  (beer_id, brewery_id, beer_name, abv, ibu, beer_type) " +
                     "VALUES (?, ?, ?, ?, ?) RETURNING beer_id;";
        long newBeer = jdbcTemplate.queryForObject(sql, Long.class,
                beer.getBeer_id(), beer.getBrewery_id(), beer.getBeer_name(),
                beer.getAbv(), beer.getIbu(), beer.getBeer_type());
    }

    public void updateBeer(Beer beer){
        String sql = "UPDATE beer " +
                "SET beer_name = ?, abv = ?, ibu = ?, beer_type = ?" +
                "WHERE brewery_id = ?;";
        jdbcTemplate.update(beer.getBeer_name(), beer.getAbv(),
                beer.getIbu(), beer.getBeer_type());

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
