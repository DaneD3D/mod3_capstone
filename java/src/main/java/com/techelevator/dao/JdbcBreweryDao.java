package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcBreweryDao implements BreweryDao{

    private JdbcTemplate jdbcTemplate;


    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Query the DB for what we want. Put it into a Java Object (by calling mapRowToBrewery)
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

    public List<Brewery> displayHomePage() {
        //loop through bb_brewery_id, increment by one
        //filter by ones in chicago
        List<Brewery> breweries = new ArrayList<>();
        String city = "Chicago";
        String sql = "SELECT * " +
                     "FROM brewery " +
                     "WHERE city = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, city);
        while(results.next()) {
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
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

//    //changed
//    public void updateBrewery(Brewery brewery){
//        String sql = "UPDATE brewery " +
//                "SET brewery_id = ?, brewery_name = ?, brewery_type = ?, street = ?, " +
//                "address_2 = ?, address_3 = ?, city = ?, state = ?, county_province = ?, " +
//                "postal_code = ?, website_url = ?, phone = ?, country = ?, longitude = ?, latitude = ?, image_url = ?, " +
//                "brewery_desc = ?, opening_time = ?, closing_time = ?, cost_rating = ?, noise_rating = ?, three_word_desc = ? tags = ?" +
//                "WHERE bb_brewery_id = ?;";
//
//        //changed
//
//        jdbcTemplate.update(beer.getBeer_name(), beer.getAbv(),
//                beer.getIbu(), beer.getBeer_type());
//
//    }
//
//
//    public void addBrewery(Brewery brewery){
//        String sql = "INSERT INTO brewery (brewery_id, brewery_name, brewery_type, street, address_2, address_3, city, " +
//                "state, county_province, postal_code, website_url, phone, country, longitude, latitude, image_url, brewery_desc, " +
//                "opening_time, closing_time, cost_rating, noise_rating, three_word_desc, tags) " +
//
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        jdbcTemplate.
//
//    }





    // Takes the database stuff and puts it into a Java Object ("Brewery")
    private Brewery mapRowToBrewery(SqlRowSet rs) {
        Brewery brewery = new Brewery();
        brewery.setBb_brewery_id(rs.getLong("bb_brewery_id"));
        brewery.setBrewery_id(rs.getString("brewery_id"));
        brewery.setBrewery_name(rs.getString("brewery_name"));
        brewery.setBrewery_type(rs.getString("brewery_type"));
        brewery.setStreet(rs.getString("street"));
        brewery.setAddress_2(rs.getString("address_2"));
        brewery.setAddress_3(rs.getString("address_3"));
        brewery.setCity(rs.getString("city"));
        brewery.setState(rs.getString("state"));
        brewery.setCounty_province(rs.getString("county_province"));
        brewery.setPostal_code(rs.getString("postal_code"));
        brewery.setCountry(rs.getString("country"));
        brewery.setLongitude(rs.getString("longitude"));
        brewery.setLatitude(rs.getString("latitude"));
        brewery.setPhone(rs.getString("phone"));
        brewery.setWebsite_url(rs.getString("website_url"));
        brewery.setImage_url(rs.getString("image_url"));
        brewery.setTags(rs.getString("tags"));
        brewery.setBrewery_desc(rs.getString("brewery_desc"));
        brewery.setOpening_time(rs.getTime("opening_time"));
        brewery.setClosing_time(rs.getTime("closing_time"));
        brewery.setCost_rating(rs.getInt("cost_rating"));
        brewery.setNoise_rating(rs.getInt("noise_rating"));
        brewery.setThree_word_Desc(rs.getString("three_word_desc"));
        return brewery;
    }

}