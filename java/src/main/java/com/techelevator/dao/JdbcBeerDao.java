package com.techelevator.dao;

import com.techelevator.model.Beer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


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
            throw new RuntimeException("Beer Name" + beerName + " not found.");
        }
    }

    private Beer mapRowToBeer(SqlRowSet rs){
        Beer beer = new Beer();
        beer.setBeer_id(rs.getString("beer_id"));
        beer.setBeer_name(rs.getString("beer_name"));
        beer.setBeer_type(rs.getString("beer_type"));
        beer.setAbv(rs.getString("abv"));
        beer.setIbu(rs.getString("ibu"));
        beer.setBrewery_id(rs.getString("brewery_id"));
        return beer;
    }

}
