package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcBreweryDao implements BreweryDao{

    private JdbcTemplate jdbcTemplate;


    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Brewery findBreweryByName(String breweryName) {
        String sql = "SELECT * " +
                     "FROM brewery " +
                     "WHERE brewery_name = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, breweryName);
        if(result.next()) {
            return mapRowToBrewery(result);
        } else {
            throw new RuntimeException("Brewery Name" + breweryName + " not found.");
        }
    }

    public List<Brewery> findBreweryByZipCode(String zipCode) {
        List<Brewery> breweries = new ArrayList<>();
        String strZip = zipCode.substring(0, 3);
        String sql = "SELECT * " +
                     "FROM brewery " +
                     "WHERE CAST(postal_code AS TEXT) LIKE ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, strZip);
        while(results.next()) {
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }

    private Brewery mapRowToBrewery(SqlRowSet rs) {
        Brewery brewery = new Brewery();
        brewery.setId(rs.getString("id"));
        brewery.setName(rs.getString("name"));
        brewery.setBrewery_type(rs.getString("brewery_type"));
        brewery.setStreet(rs.getString("street"));
        brewery.setCity(rs.getString("city"));
        brewery.setState(rs.getString("state"));
        brewery.setPostal_code(rs.getString("postal_code"));
        brewery.setPhone(rs.getString("phone"));
        brewery.setWebsite_url(rs.getString("website_url"));
        brewery.setImage_url(rs.getString("image_url"));
        return brewery;
    }



}
